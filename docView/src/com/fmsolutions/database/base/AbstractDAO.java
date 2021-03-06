package com.fmsolutions.database.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;


public class AbstractDAO {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:MySQL://localhost:3307/fmsolutions";
	
	//Credentials
	static final String DB_USER = "root";
	static final String DB_PASS = "Dillon07";
	Connection conn = null;
	Statement stmt = null;
	public ResultSet result;
	
	private void getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public ResultSet dbSelect(String selectStatement){
		ResultSet result = null;
		this.getConnection();
		try{
			stmt = conn.createStatement();
			result = stmt.executeQuery(selectStatement);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
	
	public int dbInsert(String insertStatement){
		this.getConnection();
		int row=0;
		try{
			stmt = conn.createStatement();
			row = stmt.executeUpdate(insertStatement);

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return row;
	}
	
	public void cleanUp(){
		if(conn!=null){
			try{
				stmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	
}
