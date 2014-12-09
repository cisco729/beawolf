package com.fmsolutions.database.dao;

import java.sql.SQLException;

import com.fmsolutions.database.base.AbstractDAO;
import com.fmsolutions.folder.registration.UserRegistration;

public class RegistrationDao extends AbstractDAO {
	
	public String registerUser(UserRegistration userReg){
		String result = "";
		StringBuffer insertString = new StringBuffer();
		
		insertString.append("INSERT INTO USER_PROFILE ");
		
		
		return result;
	}
	
	public int getNextUserId(){
		int userId = 0001;
		StringBuffer queryString = new StringBuffer();
		
		queryString.append("SELECT MAX(USER_ID) ");
		queryString.append("FROM USER");
		
		try{
			result = dbSelect(queryString.toString());
			
			while(result.next()){
				userId = result.getInt(0);
			}
			
		}catch(SQLException sqle){
			return userId;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return userId;
	}
}
