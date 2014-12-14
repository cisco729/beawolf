package com.fmsolutions.folder.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.fmsolutions.database.dao.StatusDao;

public class StatusAction extends DispatchAction{

	public ActionForward statusPage(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception{

	System.out.println("---Entered Status Action Class ---");
	
	return (mapping.findForward("statusPage"));
	
	}
	
	public void getStatusData(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("---Entered Status Action Class ---");
		
		StatusDao status = new StatusDao();
		
		ArrayList<StatusInfo> listOfStatuses = status.getStatusInfo();
		
		response.setStatus(200);
		response.getWriter().print("HERE IS THE FIRST RECORD");
		response.getWriter().print(listOfStatuses.get(0).getStatusCode());
		response.getWriter().print(listOfStatuses.get(0).getStatusName());
		response.getWriter().print(listOfStatuses.get(0).getMaintId());
		response.getWriter().print(listOfStatuses.get(0).getMaintDate());
		response.flushBuffer();
	}
	
}
