package com.project.controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.project.model.Detail;
import com.project.model.Model;
import com.project.model.Result;
import com.project.model.Result.Results;
import com.project.utils.API;
import com.project.utils.APIResult;
import com.project.utils.Contants;
import com.project.utils.Type;
import com.project.view.BatchJTabbedPane;
import com.project.view.CardPanel;
import com.project.view.DetailPanel;
import com.project.view.MainUI;
import com.project.view.TabPanel;

public class Controller {

	private final MainUI ui;
	private final BatchJTabbedPane statePane;
	private ExecutorService ex;

	public Controller(MainUI ui, Model model) {
		ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		this.ui = ui;
		this.statePane = ui.getStateTP();
		this.ui.populateData(model);

		callApi();

//		statePane.addChangeListener((e) -> {
//			callApi();
//		});
		
		for(int i = 0; i < statePane.getTabCount(); i++) {
			Component c = statePane.getAllComponents().get(i);
			if (c instanceof TabPanel) {
				TabPanel tp = (TabPanel) c;
				BatchJTabbedPane bp = tp.getSubTabs();
				bp.addChangeListener((e) -> {
					callApi();
				});
			}
		}

	}

	private void callApi() {
		final int selectedPos = statePane.getSelectedIndex();
		Component c = statePane.getAllComponents().get(selectedPos);
		if (c instanceof TabPanel) {
			TabPanel tp = (TabPanel) c;
			BatchJTabbedPane bp = tp.getSubTabs();
			Type t = Type.values()[bp.getSelectedIndex()];
			final String url = t.buildUrl(Contants.URLs.get(selectedPos));
			CardPanel cp = (CardPanel) bp.getAllComponents().get(bp.getSelectedIndex());
			getList(url, handleResponse(cp, url));
		}
	}

	private APIResult<Result> handleResponse(final CardPanel cp, final String url) {
		return new APIResult<Result>() {

			@Override
			public void onResult(Result data) {
				
				SwingUtilities.invokeLater(() -> {
					cp.populateData(data, new SelectionListener(cp, data, Controller.this, url));
				});

			}

			@Override
			public void onError(Exception e) {

			}

		};
	}

	private static class SelectionListener implements ListSelectionListener {
		private final Result data;
		private final Controller c;
		private final String url;
		private final CardPanel cp;

		SelectionListener(CardPanel cp, Result data, Controller c, String url) {
			this.data = data;
			this.c = c;
			this.url = url;
			this.cp = cp;
		}

		int lastIndex = -1;

		@SuppressWarnings("unchecked")
		@Override
		public void valueChanged(ListSelectionEvent e) {
			JList<Results> jl = (JList<Results>) e.getSource();
			if (lastIndex == jl.getSelectedIndex()) {
				return;
			}
			Results r = data.results.get(jl.getSelectedIndex());
			lastIndex = jl.getSelectedIndex();
			c.getDetail(url + "/" + r.id, new APIResult<Detail>() {

				@Override
				public void onResult(Detail data) {
					SwingUtilities.invokeLater(() -> {
						cp.populateDetail(data);
					});

				}

				@Override
				public void onError(Exception e) {
					// TODO Auto-generated method stub

				}

			});
		}

	}

	private void getList(String url, APIResult<Result> result) {
		String mUrl = url + "?format=json";
		ex.execute(() -> {
			new API<Result>().get(mUrl, Result.class, new APIResult<Result>() {

				@Override
				public void onResult(Result data) {
					get(mUrl,result,data.count);
				}

				@Override
				public void onError(Exception e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			//new API<Result>().get(mUrl, Result.class, result);

		});
	}		

	private void get(String url, APIResult<Result> result, int count) {		
		String fUrl = url +"&limit="+count+"&offset=0asdfazzz";											
		new API<Result>().get(fUrl, Result.class, result);		
	}
	private void getDetail(String url, APIResult<Detail> result) {
		String mUrl = url + "?format=json";	
		ex.execute(() -> {
			new API<Detail>().get(mUrl, Detail.class, result);
		});
	}

}
