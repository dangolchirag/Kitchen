package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Worker {

	
	
	private static final String URL = "jdbc:mysql://localhost:3306/sp?characterEncoding=latin1&useConfigs=maxPerformance";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Ktmnepal@1";
	private Boolean shouldPrint = false;
	DBPool pool;
	Worker(){
		try {
			pool = new DBPool(URL,USERNAME,PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	synchronized void insert(Scanner scanner) throws SQLException,InterruptedException {
		if(shouldPrint) {
			wait();
		}
		
		Connection connection = pool.getConnection();
		
		PreparedStatement st = connection.prepareStatement("insert into user420 values (?,?)");
		
		for(int i = 0; i < 3; i++) {		
			System.out.println("Enter id: ");
			int id = scanner.nextInt();
			st.setInt(1, id);			
			System.out.println("Enter name: ");
			String name = scanner.next();
			st.setString(2, name);
			st.addBatch();
		}
		
		st.executeBatch();		
		pool.returnConnection(connection);	
		shouldPrint = true;
		notify();
	}
	
	synchronized void show() throws SQLException, InterruptedException {
		
		if(!shouldPrint) {
			wait();
		}		
		Connection connection = pool.getConnection();
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from user420");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		shouldPrint = false;
		notify();
	}
	void close() {
		try {
			pool.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
