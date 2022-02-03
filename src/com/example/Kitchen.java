package com.example;

import java.util.ArrayList;

public class Kitchen {

	//int i = 0;
	boolean hasPrepared = false;
	
	ArrayList<String> food = new ArrayList<>();
	synchronized public void prepareFood(ArrayList<String> food) {		
		this.food = food;		
		
		try {
			if(hasPrepared) {
				wait();
			}
			
			
			System.out.println("Preparing food...");
			for (String string : food) {
				System.out.println(string+" Prepared.");
				Thread.sleep(2000);
			}
			
		}catch(Exception ignored) {
			
		}

		hasPrepared = true;
		notify();
	}
	
	synchronized public ArrayList<String>  consumeFood() {
		
		try {
			if(!hasPrepared) {
				wait();
			}
			
			System.out.println("consuming foods...");
			
			for (String string : food) {
				System.out.println(string+" consumed");
				Thread.sleep(2000);
			}
						
		}catch(Exception ignored) {
			
		}
		
		
		
		System.out.println("--------------------------------------------------------------");
		hasPrepared = false;
		
		notify();
		return food;
	}
}
