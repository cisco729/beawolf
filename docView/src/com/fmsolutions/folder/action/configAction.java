package com.fmsolutions.folder.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.fmsolutions.database.dao.ConfigDao;
import com.fmsolutions.folder.config.ConfTableInfo;
import com.google.gson.Gson;

public class configAction extends DispatchAction{
	
	
	public ActionForward configPage(ActionMapping mapping, ActionForm form,
								   HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("---Entered Action Class ---");
		
		
		return (mapping.findForward("configPage"));
		
	}
	
	public ActionForward conf(ActionMapping mapping, ActionForm form,
								   HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("---Entered Action Class ---");
		
		HttpSession session = request.getSession();
		
		ConfigDao dbConfig = new ConfigDao();
		ArrayList<ConfTableInfo> confTableList = dbConfig.getConfTables();
		
		session.setAttribute("confTables", confTableList);
		
		return (mapping.findForward("conf"));
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
	
	public void getColumnHeaders(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String tableName = request.getParameter("tableName");
		
		ConfigDao config = new ConfigDao();
		ArrayList<Map<String,String>> columns = config.getTableColumns(tableName);
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("Columns", columns);
		String resp = new Gson().toJson(responseMap);
		
		response.setStatus(200);
		response.getWriter().print(resp);
		response.flushBuffer();
	} 

}
