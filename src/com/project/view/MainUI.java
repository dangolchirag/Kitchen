package com.project.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.project.model.Model;
import com.project.utils.Type;
import com.project.view.BatchJTabbedPane.TabItem;

public class MainUI extends JFrame {

	private static final long serialVersionUID = -5838165085124803417L;
	private List<BatchJTabbedPane.TabItem> items;
	private final BatchJTabbedPane stateTP;

	public MainUI() {
		super("News/Notice");
		stateTP = new BatchJTabbedPane();
		stateTP.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				stateTP.update();
			}
		});
		add(stateTP);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private SettingsPanel sp;

	public void populateData(Model model) {
		items = new ArrayList<TabItem>();
		for (String state : model.getStates()) {
			if (state.equals("Settings")) {
				sp = new SettingsPanel(model);
				items.add(new TabItem(state, sp));

			} else {
				TabPanel tp = new TabPanel();
				List<String> subItems = new ArrayList<>();
				for (com.project.utils.Type t : com.project.utils.Type.values()) {
					subItems.add(t.toString());
				}
				items.add(new TabItem(state, tp));

				tp.populateSubTabs(subItems);

			}
		}
		stateTP.setData(true, items);
		setVisible(true);
	}

	public BatchJTabbedPane getStateTP() {
		return stateTP;
	}
}
