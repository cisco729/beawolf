package com.fmsolutions.folder.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sun.misc.BASE64Encoder;

import com.fmsolutions.database.dao.RegistrationDao;
import com.fmsolutions.folder.registration.UserRegistration;

public class RegistrationAction {
	
	public ActionForward registerPage(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return mapping.findForward("register");
	}
	
	//Services
	public void registerUser(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		UserRegistration userReg = new UserRegistration();
		RegistrationDao dbRegistration = new RegistrationDao();
		
		//Set up Registration Object
		userReg.setFirstName(request.getParameter("firstName"));
		userReg.setMiddleInitial(request.getParameter("middleInitial"));
		userReg.setLastName(request.getParameter("lastName"));
		userReg.setAddress(request.getParameter("address"));
		userReg.setAddress2(request.getParameter("address2"));
		userReg.setCity(request.getParameter("city"));
		userReg.setState(request.getParameter("state"));
		userReg.setPhoneNumber(request.getParameter("phoneNumber"));
		userReg.setUserName(request.getParameter("userAlias"));
		
		//encode password
		BASE64Encoder encoder = new BASE64Encoder();
		userReg.setPassword(encoder.encode(request.getParameter("password").getBytes()));
		
		int userId = dbRegistration.getNextUserId();
		
		
		
		
	}
	
}
