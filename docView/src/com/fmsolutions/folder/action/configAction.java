package com.fmsolutions.folder.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.fmsolutions.database.dao.ConfigDao;

public class configAction extends DispatchAction{
	
	
	public ActionForward configPage(ActionMapping mapping, ActionForm form,
								   HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("---Entered Action Class ---");
		
		return (mapping.findForward("configPage"));
		
	}
	
	public void getSomeDataBack(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("---Entered Action Class ---");
		
		ConfigDao config = new ConfigDao();
		
		ArrayList<String> listOfStores = config.getStores();
		
		response.setStatus(200);
		response.getWriter().print(listOfStores);
		response.flushBuffer();
		
	}

}
