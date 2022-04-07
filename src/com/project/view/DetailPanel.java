package com.project.view;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTextPane;
import javax.swing.SpringLayout;

import com.project.model.Detail;

public class DetailPanel extends JPanel {

	private static final long serialVersionUID = -3882356847542949375L;

	private final JLabel title, date;
	private final JTextPane desc;

	public DetailPanel() {
		title = new JLabel("title");
		title.setFont(new Font(title.getFont().getName(), Font.BOLD, title.getFont().getSize() + 7));
		date = new JLabel("date");
		date.setForeground(new Color(0X727272));
		date.setFont(getFont().deriveFont(14.0f));
		desc = new JTextPane();
		desc.setFont(getFont().deriveFont(18.0f));
		desc.setBackground(null);
		desc.setEditable(false);
		desc.setContentType("text/html");
		desc.setEditorKit(new WrappedHtmlEditorKit());
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		JScrollPane sp = new JScrollPane(desc);
		add(title);
		add(date);
		add(sp);

		layout.putConstraint(SpringLayout.NORTH, title, 8, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, this, 8, SpringLayout.EAST, title);
		layout.putConstraint(SpringLayout.WEST, title, 8, SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH, date, 8, SpringLayout.SOUTH, title);
		layout.putConstraint(SpringLayout.EAST, this, 8, SpringLayout.EAST, date);
		layout.putConstraint(SpringLayout.WEST, date, 8, SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH, sp, 16, SpringLayout.SOUTH, date);
		layout.putConstraint(SpringLayout.EAST, this, 8, SpringLayout.EAST, sp);
		layout.putConstraint(SpringLayout.WEST, sp, 8, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, this, 8, SpringLayout.SOUTH, sp);

	}

	public JLabel getTitleLabel() {
		return title;
	}

	public JLabel getDateLabel() {
		return date;
	}

	public JEditorPane getDescTextArea() {
		return desc;
	}

	public void setDetail(Detail detail) {
		title.setText(detail.title_np);
		date.setText(detail.published_date);
		System.out.println(detail.content_np);
		desc.setText(detail.content_np);

	}

}
