package com.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class DBPool {
	String connString;    
    String user;
    String pwd;

    private final static int INITIAL_CAPACITY = Runtime.getRuntime().availableProcessors();
    
    private LinkedList<Connection> pool = new LinkedList<Connection>();
    public String getConnString() {
        return connString;
    }
    public String getPwd() {
        return pwd;
    }

    public String getUser() {
        return user;
    }

    public DBPool() throws Exception {
        this.connString = Contants.URL;
        this.user = Contants.USERNAME;
        this.pwd = Contants.PASSWORD;
        Class.forName("com.mysql.jdbc.Driver");            
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
             pool.add(DriverManager.getConnection(connString, user, pwd));
        }        
    }

    public synchronized Connection getConnection() throws SQLException {
        if (pool.isEmpty()) {
            pool.add(DriverManager.getConnection(connString, user, pwd));
        }
        return pool.pop();
    }
  
    public synchronized void returnConnection(Connection connection) {
        pool.push(connection);
    } 
    public void close() throws SQLException {
    	for (int i = 0; i < pool.size(); i++) {
    		pool.pop().close();
    	}
    }
}
