package com.fmsolutions.managementcenter.services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.fmsolutions.managementcenter.dao.ServicesDao;
import com.google.gson.Gson;

public class ManagementServices extends DispatchAction{
	
	public void getManagementInfo(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ManagementInfo managementInfo = new ManagementInfo();
		
		managementInfo.setTablename(request.getParameter("tablename"));
		ServicesDao servicesDao = new ServicesDao();
		
		managementInfo = servicesDao.getColumns(managementInfo);
		managementInfo = servicesDao.getData(managementInfo);
		
		Map<String,Object> managementInfoMap = new HashMap<String,Object>();
		managementInfoMap.put("columns", managementInfo.getColumns());
		managementInfoMap.put("data", managementInfo.getData());
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		
		responseMap.put("ManagementInfo", managementInfoMap);
		
		String resp = new Gson().toJson(responseMap);
		
		response.setStatus(200);
		response.getWriter().print(resp);
		response.flushBuffer();
 
	}
}
