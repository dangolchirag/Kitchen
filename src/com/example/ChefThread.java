package com.example;

import java.util.ArrayList;
import java.util.Random;

public class ChefThread extends Thread{

	static ArrayList<String> foodList = new ArrayList<>();
	Random random = new Random();
	static {
		foodList.add("Pizza");
		foodList.add("Momo");
		foodList.add("Burger");
		foodList.add("Chicken");
		foodList.add("Pasta");
		foodList.add("Rice");
		foodList.add("Roti");
		foodList.add("Salad");
		foodList.add("Thukpa");
		foodList.add("Chowmien");
		
	}
	private final Kitchen kitchen;
	
	
	public ChefThread(Kitchen kitchen) {
		this.kitchen = kitchen; 
		
	}
	
	
	private ArrayList<String> getFood() {
		
		ArrayList<String> food = new ArrayList<>();
		ArrayList<String> dummyList = new ArrayList<>();
		dummyList.addAll(foodList);
			
		
		
		for(int i =0; i < 3; i++) {			
			String foodToAdd = dummyList.get(random.nextInt(dummyList.size()));
			food.add(foodToAdd);
			dummyList.remove(foodToAdd);
		
		}
		return food;
	}
	
	
	@Override
	public void run() {
		
		
		while (true) {
			
			kitchen.prepareFood(getFood());
			
			
		}
	}
}
