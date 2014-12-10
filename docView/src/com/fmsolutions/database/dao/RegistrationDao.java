package com.fmsolutions.database.dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fmsolutions.database.base.AbstractDAO;
import com.fmsolutions.folder.registration.UserRegistration;

public class RegistrationDao extends AbstractDAO {
	
	String userId;
	
	public String registerUser(UserRegistration userReg){
		String result = "";
		StringBuffer insertString = new StringBuffer();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat datetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		
		insertString.append("INSERT INTO USER_PROFILE values(");
		insertString.append(userId+",");
		insertString.append("'"+userReg.getFirstName()+"',");
		insertString.append(userReg.getMiddleInitial()+",");
		insertString.append("'"+userReg.getLastName()+"',");
		insertString.append("'"+userReg.getAddress()+"',");
		insertString.append(userReg.getAddress2()+",");
		insertString.append("'"+userReg.getCity()+"',");
		insertString.append("'"+userReg.getState()+"',");
		insertString.append("'"+userReg.getPhoneNumber()+"',");
		insertString.append("'"+userReg.getPassword()+"',");
		insertString.append("'"+userReg.getEmail()+"',");
		insertString.append("'"+dateFormat.format(date)+"',");
		insertString.append("'"+dateFormat.format(date)+"',");
		insertString.append("'appdoc',");
		insertString.append("'"+datetime.format(date)+"')");
		
		System.out.println("Insert String: "+insertString.toString());
		try{
			int row = dbInsert(insertString.toString());
			if(row!=0){
				insertString = new StringBuffer();
				insertString.append("INSERT INTO USER Values(");
				insertString.append(userId+",");
				insertString.append("'"+userReg.getUserName()+"',");
				insertString.append("'A',");
				insertString.append("1,");
				insertString.append("2,");
				insertString.append("0,");
				insertString.append("'appdoc')");
				
				row = dbInsert(insertString.toString());
				if(row!=0){
					result = "success";
				}
				else
					result = "failed";
			}
			else{
				result = "failed";
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			cleanUp();
		}
		
		
		return result;
	}
	
	
	public String getNextUserId(){
		StringBuffer queryString = new StringBuffer();
		
		queryString.append("SELECT MAX(USER_ID) ");
		queryString.append("FROM USER");
		
		try{
			result = dbSelect(queryString.toString());
			
			result.next();
			int id = result.getInt("MAX(USER_ID)") + 1;	
			userId = Integer.toString(id);
			
		}catch(SQLException sqle){
			return userId="0001";
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			cleanUp();
		}
		
		
		return userId;
	}
	
	public boolean checkExistingUserId(String userId){
		boolean exists = false;
		
		return exists;
	}
}
