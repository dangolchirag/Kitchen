package com.example;

import java.sql.SQLException;

public class ShowThread extends Thread{
	
	private final Worker worker;
	
	ShowThread(Worker worker){
		this.worker = worker;
	}
	
	@Override
	public void run() {		
		super.run();
		while(true) {
			try {
				worker.show();
			} catch (SQLException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
