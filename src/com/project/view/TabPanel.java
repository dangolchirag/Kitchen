package com.project.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JPanel;


public class TabPanel extends JPanel{

	
	private static final long serialVersionUID = -379453766518889136L;
	private final List<BatchJTabbedPane.TabItem> items;
	private final BatchJTabbedPane subTabs;	
	
	TabPanel(){		
		subTabs = new BatchJTabbedPane();
		items = new ArrayList<BatchJTabbedPane.TabItem>();		
		setLayout(new BorderLayout());
			
						
	}	
	
	public void populateSubTabs(List<String> states) {		
		for(String subItems: states) {
			items.add(new BatchJTabbedPane.TabItem(subItems,new CardPanel()));
		}
		
		subTabs.setData(false,items);	
		add(subTabs,BorderLayout.CENTER);	
	}
	
	public BatchJTabbedPane getSubTabs() {
		return subTabs;
	}
	
}
