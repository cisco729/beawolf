package com.fmsolutions.folder.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.fmsolutions.database.dao.StatusDao;
import com.fmsolutions.folder.status.StatusForm;

public class StatusAction extends DispatchAction{

	public ActionForward statusPage(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception{

		System.out.println("---Entered Status Action Class ---");
		
		StatusForm status = new StatusForm();
		status = (StatusForm) form;
		String forward = "statusPage";
	
		status = (StatusForm) form;
		
		ArrayList<StatusInfo> listOfStatuses = this.getStatusData(response);
		
		// set values
		status.setStatusCode(listOfStatuses.get(0).getStatusCode());
		status.setStatusName(listOfStatuses.get(0).getStatusName());
		status.setMaintId(listOfStatuses.get(0).getMaintId());
		status.setMaintDate(listOfStatuses.get(0).getMaintDate());
		
		return mapping.findForward(forward);
	
	}
	
	public ArrayList<StatusInfo> getStatusData(HttpServletResponse response) throws Exception{
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
		
		return listOfStatuses;
	}
	
}
