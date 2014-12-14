package com.fmsolutions.database.dao;

import java.util.ArrayList;

import com.fmsolutions.database.base.AbstractDAO;
import com.fmsolutions.folder.action.StatusInfo;

public class StatusDao extends AbstractDAO{

	public ArrayList<StatusInfo> getStatusInfo(){
		
		StringBuffer queryString = new StringBuffer();
		ArrayList<StatusInfo> statusList = new ArrayList<StatusInfo>();
		
		queryString.append("SELECT STATUS_CODE, STATUS_NAME, MAINT_ID, MAINT_DATE ");
		queryString.append("FROM STATUS");
								
		result = dbSelect(queryString.toString());
		try{
			while(result.next()){
				StatusInfo statusInfo = new StatusInfo();
				
				statusInfo.setStatusCode(result.getString("status_code"));
				statusInfo.setStatusName(result.getString("status_name"));
				statusInfo.setMaintId(result.getString("maint_id"));
				statusInfo.setMaintDate(result.getString("maint_date"));
				
				statusList.add(statusInfo);
			}
		}catch(Exception e){
				e.printStackTrace();
		} finally{
			cleanUp();
		}
		return statusList;	
	}
}