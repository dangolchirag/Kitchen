package com.project.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;




import javax.swing.BorderFactory;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;



import com.project.model.Result;

public class LRender extends JLabel implements ListCellRenderer<Result.Results> {

	private static final long serialVersionUID = -2966126222395772519L;
	public LRender() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Result.Results> list, Result.Results value, int index,
            boolean isSelected, boolean cellHasFocus) {

        setLayout(new FlowLayout());
        setText(value.title_np);
      
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
        if(cellHasFocus) {
        	setBackground(Color.blue);
        	setForeground(Color.white);
        }else {
        	setBackground(null);
        	setForeground(Color.black);
        }       
        return this;
    }
//    public void getImage(JLabel l){
////    	 ExecutorService executor = Executors.newFixedThreadPool(5);
////    	 
////    	 executor.execute(()->{
////    		
////    	 });
//    	
//    	 try{
//           URL url = new URL("https://i.stack.imgur.com/OVOg3.jpg");   
//           Image image = ImageIO.read(url.openStream());
//           SwingUtilities.invokeLater(()->{
//           	l.setIcon(new ImageIcon());
//           });    	            
//       }
//       catch(Exception e){
//           e.printStackTrace();           
//       }
//        
//    }

}