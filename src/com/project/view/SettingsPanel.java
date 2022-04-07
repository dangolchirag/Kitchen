package com.project.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.project.model.Model;
import com.project.utils.Type;

public class SettingsPanel extends JPanel{

	
	private static final long serialVersionUID = -5810036979826318277L;
	
	SettingsPanel(Model model){
		setLayout(new BorderLayout());
        final JCheckBoxTree cbt = new JCheckBoxTree();
        add(cbt);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("States");
        DefaultMutableTreeNode parent;
        
        
        for(String state : model.getStates()) {
        	parent = new DefaultMutableTreeNode(state);
            root.add(parent);
            for(Type t: Type.values()) {
            	parent.add(new DefaultMutableTreeNode(t.toString()));
            }
        }

        DefaultTreeModel d = new DefaultTreeModel(root);
        cbt.setModel(d);
        cbt.addCheckChangeEventListener(new JCheckBoxTree.CheckChangeEventListener() {
            public void checkStateChanged(JCheckBoxTree.CheckChangeEvent event) {
                System.out.println("event");
                TreePath[] paths = cbt.getCheckedPaths();
                for (TreePath tp : paths) {
                    for (Object pathPart : tp.getPath()) {
                        System.out.print(pathPart + ",");
                    }                   
                    System.out.println();
                }
            }           
        });    
        
        
	}

}
