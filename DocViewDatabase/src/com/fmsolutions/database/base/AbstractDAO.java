package com.fmsolutions.database.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

public class AbstractDAO {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/doc";
	
	//Credentials
	static final String DB_USER = "appdoc";
	static final String DB_PASS = "p@ssword1";
	Connection conn = null;
	Statement stmt = null;
	
	private void getConnection(){
		try{
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
