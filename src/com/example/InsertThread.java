package com.example;

import java.sql.SQLException;
import java.util.Scanner;

public class InsertThread extends Thread{
	
	private final Worker worker;	
	InsertThread(Worker worker){
		this.worker = worker;
		
	}

	@Override
	public void run() {
		super.run();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				worker.insert(scanner);
			} catch (SQLException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}				
		
			
	}
	void someMethod() {
		
	}
}
