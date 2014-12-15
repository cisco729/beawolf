package com.fmsolutions.folder.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

import com.fmsolutions.database.dao.RegistrationDao;
import com.fmsolutions.folder.registration.UserRegistration;

public class RegistrationAction extends DispatchAction{
	
	private static Random rand = new Random((new Date()).getTime());
	
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
		userReg.setEmail(request.getParameter("email"));
		System.out.println(userReg.getMiddleInitial());
		
		//encode password
		userReg.setPassword(encrypt(request.getParameter("password")));
		
		String userId = dbRegistration.getNextUserId();
		System.out.println(userId);
		String result = dbRegistration.registerUser(userReg);
		
		response.setStatus(200);
		response.getWriter().print(result);
		response.flushBuffer();
		
		
		
	}
	
	public void testEncryption(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("---testing encryption---");
		String password = request.getParameter("password");
		ArrayList<String> returnList = new ArrayList<String>();
		
		String enc = encrypt(password);
		returnList.add("encoded: "+enc);
		String dec = decrypt(enc);
		returnList.add("decoded: "+dec);
		
		response.setStatus(200);
		response.getWriter().print(returnList);
		response.flushBuffer();
		
	}
	
	public String getNextUserId(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		RegistrationDao dbRegistration = new RegistrationDao();
		String userId = dbRegistration.getNextUserId();
		
		return userId;
		
	}
	
	public static String encrypt(String password){
		BASE64Encoder encoder = new BASE64Encoder();
		byte[] salt = new byte[8];
		rand.nextBytes(salt);
		
		return encoder.encode(salt)+encoder.encode(password.getBytes());
		
	}
	
	public String decrypt(String encryptedString){
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
	
	public void checkExistingUserId(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String userAlias = request.getParameter("userAlias");
		RegistrationDao dbReg = new RegistrationDao();
		
		boolean userAliasExists = dbReg.checkExistingUserAlias(userAlias);
		
		response.setStatus(200);
		response.getWriter().print("{\"exists\":\""+userAliasExists+"\"}");
		response.flushBuffer();
	}
	
}
