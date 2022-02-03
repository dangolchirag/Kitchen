package com.example;

public class ConsumerThread extends Thread{

	private final Kitchen kitchen;
	
	public ConsumerThread(Kitchen kitchen) {
		this.kitchen = kitchen; 
	}
	@Override
	public void run() {
		
		
		while (true) {
			
			kitchen.consumeFood();
			
			
		}
	}
}
