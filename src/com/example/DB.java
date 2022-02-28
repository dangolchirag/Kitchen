package com.example;



public class DB {

	
	
	public static void main(String[] args) throws Exception {	
		Worker worker = new Worker();
		ShowThread st = new ShowThread(worker);		
		InsertThread it = new InsertThread(worker);
		it.start();
		st.start();				
		it.join();
		st.join();		
		worker.close();
		
	}
	
	

}
