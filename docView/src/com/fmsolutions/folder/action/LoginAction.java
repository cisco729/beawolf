package com.fmsolutions.folder.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.fmsolutions.database.base.DbUtilities;
import com.fmsolutions.database.dao.LoginDao;
import com.fmsolutions.folder.login.LoginConstants;
import com.fmsolutions.folder.login.LoginForm;

import sun.misc.BASE64Decoder;

public class LoginAction extends DispatchAction{
	
	public ActionForward loginPage(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return mapping.findForward("login");
	}
	
	public ActionForward login(ActionMapping mapping, ActionForm form,
								   HttpServletRequest request, HttpServletResponse response) throws Exception{
		//start login
		System.out.println("Entering Login");
		
		LoginForm login = new LoginForm();
		LoginDao dbLogin = new LoginDao();
		String forward = "";
		
		login = (LoginForm) form;
		
		//Get user id and encrypted password
		String[] params = new String[1];
		params[0] = login.getUserAlias();
		LoginInfo loginInfo = dbLogin.getLoginInfo(params);
		
		if(this.comparePassword(loginInfo, login.getPassword())){
			forward = "success";
		}
		else{
			forward = "failed";
		}
		
		return mapping.findForward(forward);
		
		
	}
	
	private String decrypt(String encryptedString){
		if (encryptedString.length() > 12){
			String cipher = encryptedString.substring(12);
			BASE64Decoder decode = new BASE64Decoder();
			
			try{
				
				byte[] decodedString = decode.decodeBuffer(cipher);
				
				return new String(decodedString);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	private boolean comparePassword(LoginInfo loginInfo,String passwordEntered){
		boolean result = false;
		if(this.decrypt(loginInfo.getPassword()).equalsIgnoreCase(passwordEntered)){
			result = true;
		}
		
		return result;
	}
}
