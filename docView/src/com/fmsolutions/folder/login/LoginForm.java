package com.fmsolutions.folder.login;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm{
	
	private String userAlias;
	private String password;
	
	public String getUserAlias() {
		return userAlias;
	}
	public String getPassword() {
		return password;
	}
	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
