package com.project.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;

import java.awt.Graphics;


import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;


import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class BatchJTabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	private BatchJTabbedPaneUI c;
	private List<TabItem> items;
	private List<Component> components;
	BatchJTabbedPane() {
		super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	public void setData(boolean fixedTab, List<TabItem> items) {
		this.items = items;
		this.components = new ArrayList<>();
		c = new BatchJTabbedPaneUI(fixedTab);
		for (TabItem item : items) {
			addTab(item.title, item.component);
			components.add(item.component);
		}
		setUI(c);
	}

	public void updateBatch(int index, int count) {
		c.updateBatch(index, count);
		repaint();
	}

	public void update() {
		Component c = items.get(getSelectedIndex()).component;
		c.invalidate();
		c.repaint();
	}
	public int getTotalCount() {
		int count = 0;

		for (int i = 0; i < getTabCount(); i++) {
			count += c.getBatchCount(i);
		}
		return count;
	}

	public List<Component> getAllComponents(){
		if(components == null) {
			return new ArrayList<Component>();
		}
		return components;
	}
	public static class BatchJTabbedPaneUI extends BasicTabbedPaneUI {
		int[] batches;
		boolean fixedTab = true;		
		

		BatchJTabbedPaneUI(boolean fixedTab) {
			this.fixedTab = fixedTab;
		}

		@Override
		protected void installDefaults() {
			super.installDefaults();
			batches = new int[tabPane.getTabCount()];
		}

		public int getBatchCount(int index) {
			return batches[index];
		}

		@Override
		protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
			if (fixedTab) {
				return (tabPane.getWidth() / tabPane.getTabCount() - 2);
			} else {
				return super.calculateTabWidth(tabPlacement, tabIndex, metrics) + 40;
			}
		}

		public void updateBatch(int index, int count) {
			batches[index] = count;

		}

		@Override
		protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex,
				String title, Rectangle textRect, boolean isSelected) {
			int batch = batches[tabIndex];
			if (batch == 0) {
				super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
				return;
			}
			Rectangle r = new Rectangle(textRect.x - 20, textRect.y, textRect.height, textRect.width);
			super.paintText(g, tabPlacement, font, metrics, tabIndex, title, r, isSelected);
			g.setColor(Color.red);
			g.fillOval(textRect.x + 32, textRect.y - 5, 25, 25);
			g.setColor(Color.white);			
			if (batch > 99) {
				batch = 99;
			}
			String b = String.valueOf(batch);
			Rectangle2D bounce = metrics.getStringBounds(b, g);
			int Ilength = (int) bounce.getWidth();
			int Iheight = (int) bounce.getHeight();			
			g.drawString(b,  textRect.x + ((textRect.width) / 2) - (Ilength / 2),(
					textRect.y + ((Iheight + textRect.height) / 2))-2);

		}

		@Override
		protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
			return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight) + 20;
		}

		@Override
		protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
				boolean isSelected) {
			if (isSelected) {
				g.setColor(Color.blue);
				g.fillRect(x, h - 5, w, h);
			} else {
				g.setColor(new Color(255, 255, 244));
				g.fillRect(x, y, w, h);
			}
		}
	}

	public static class TabItem {
		String title;
		Component component;

		/**
		 * @param title
		 * @param component
		 */
		public TabItem(String title, Component component) {
			super();
			this.title = title;
			this.component = component;
		}

	}

}
