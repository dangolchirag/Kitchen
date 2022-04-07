package com.tt;



import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.example.model.Result;
import com.example.utils.API;
import com.example.utils.APIResult;


public class Test {
	private static String SOURCE = "https://www.nepalpolice.gov.np/api/v1/news?format=json";
	public static void main(String[] args) throws Exception{
	
		
		JFrame f = new JFrame("asdf");
		
		JTextArea l = new JTextArea();
		JScrollPane jp = new JScrollPane(l);
		l.setEditable(false);		
		f.add(jp);
		l.setText(SOURCE);
		StringBuffer s = new StringBuffer();
		
		new API<Result>().get(SOURCE, Result.class, new APIResult<Result>() {
			
			@Override
			public void onResult(Result data) {
				System.out.println(data);
				for(Result.Results r: data.results) {
					s.append(r.title_np);
					s.append("\n");
				}
				l.setText(s.toString());
				f.pack();
			}
			
			@Override
			public void onError(Exception e) {
				
			}
		});
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		l.setText("Called");
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - f.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - f.getHeight()) / 2);
	    f.setLocation(x, y);
		
	}

}
