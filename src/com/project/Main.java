package com.project;

import javax.swing.UIManager;

import com.project.controller.Controller;
import com.project.model.Model;

import com.project.view.MainUI;

public class Main {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		final Model model = new Model();
		final MainUI ui = new MainUI();
		new Controller(ui, model);
			
		
		
	}
}
