package com.example;

public class Main {
	public static void main(String[] args) {
			
			System.out.println("Entered to kitchen");
			Kitchen kitchen = new Kitchen();
			
			ChefThread ct = new ChefThread(kitchen);
			ConsumerThread cont = new ConsumerThread(kitchen);			
			
			ct.start();
			cont.start();
			//cont2.start();
			System.out.println("Exited From kitchen");
		}
}
