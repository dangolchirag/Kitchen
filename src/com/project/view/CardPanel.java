package com.project.view;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import com.project.model.Detail;
import com.project.model.Result;
import com.project.model.Result.Results;


public class CardPanel extends JPanel {

	private static final long serialVersionUID = 3541738959589111063L;
	private final JList<Result.Results> list;
	private final DetailPanel detailPanel;
	private final DefaultListModel<Result.Results> listItem;
	private Result data;
	public CardPanel() {		
		setLayout(new GridBagLayout());
		listItem = new DefaultListModel<>();		
		list = new JList<>(listItem);				
		list.setVisibleRowCount(-1);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFixedCellHeight(40);
		
		list.setCellRenderer(new LRender());
		JScrollPane jp = new JScrollPane(list);
		detailPanel = new DetailPanel();
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(8,8,8,8);
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 1;
		c.weightx = 0.3;
		c.gridx = 0;
		add(jp, c);
		c.weightx = 0.7;
		c.gridx = 1;
		add(detailPanel, c);
		list.setFixedCellWidth(100);
		
	}
	public DefaultListModel<Result.Results> getListItems() {
		return listItem;
	}
	public DetailPanel getDetailPanel() {
		return detailPanel;
	}
	
	public JList<Result.Results> getList() {
		return list;
	}

	public void populateData(Result data,ListSelectionListener l) {	
		this.data = data;
		listItem.removeAllElements();
		for (Results r : data.results) {			
			listItem.addElement(r);
		}
		list.addListSelectionListener(l);
		//list.setSelectedIndex(0);
	}
	
	public void populateDetail(Detail detail) {
		detailPanel.setDetail(detail);
	}
	
}
