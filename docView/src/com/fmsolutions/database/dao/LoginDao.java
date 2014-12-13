package com.fmsolutions.database.dao;

import com.fmsolutions.database.base.AbstractDAO;
import com.fmsolutions.database.base.DbUtilities;
import com.fmsolutions.folder.action.LoginInfo;
import com.fmsolutions.folder.login.LoginConstants;

public class LoginDao extends AbstractDAO{

	public LoginInfo getLoginInfo(String[] params){
		String queryString=DbUtilities.constructQuery(LoginConstants.getPasswordQuery, params);
		LoginInfo loginInfo = new LoginInfo();
		
		result = dbSelect(queryString);
		try{
			while(result.next()){
				
				loginInfo.setUserId(result.getString("user_id"));
				loginInfo.setPassword(result.getString("password"));
			}
		}catch(Exception e){
				e.printStackTrace();
		}
		return loginInfo;	
	}
}
