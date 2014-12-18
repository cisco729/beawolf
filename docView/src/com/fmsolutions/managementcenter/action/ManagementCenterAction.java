package com.fmsolutions.managementcenter.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.fmsolutions.commons.LabelValueBean;
import com.fmsolutions.managementcenter.dao.ConfigurationDao;

public class ManagementCenterAction extends DispatchAction{

	public ActionForward managementConsole(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		
		//Todo:  Add login for access to Management Console
		
		//Begin setting up Management Console
		ConfigurationDao config = new ConfigurationDao();
		ArrayList<LabelValueBean> manageList = config.getManageTables();
		
		session.setAttribute("manageList",manageList);
		
		return mapping.findForward("mc");
		
	}
}
