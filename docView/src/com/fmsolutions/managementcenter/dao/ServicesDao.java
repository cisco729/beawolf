package com.fmsolutions.managementcenter.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fmsolutions.database.base.AbstractDAO;
import com.fmsolutions.managementcenter.services.ManagementInfo;

public class ServicesDao extends AbstractDAO{

	public ManagementInfo getColumns(ManagementInfo managementInfo){
		//Initalize Variables
		ArrayList<String> columns = new ArrayList<String>();
		String tablename = managementInfo.getTablename();
		StringBuffer queryString = new StringBuffer();
		
		//Write Query
		queryString.append("Select column_name ");
		queryString.append("from information_schema.columns ");
		queryString.append("where table_name = '"+tablename+"'");
		
		//exeute query
		try{
			result = dbSelect(queryString.toString());
			while(result.next()){
				columns.add(result.getString("column_name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Set columns to the management info object
		managementInfo.setColumns(columns);
		
		return managementInfo;
	}
	
	public ManagementInfo getData(ManagementInfo managementInfo){
		//Initalize Variables
		ArrayList<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		String tablename = managementInfo.getTablename();
		ArrayList<String> columns = managementInfo.getColumns();
		StringBuffer queryString = new StringBuffer();
		
		//write query
		queryString.append("SELECT ");
		for(int count=0; count < columns.size(); count++){
			queryString.append(columns.get(count));
			if(count < (columns.size()-1)){
				queryString.append(", ");
			}
			else{
				queryString.append(" ");
			}
		}
		queryString.append("from "+tablename+" ");
		
		//excute Query
		
		try{
			result = dbSelect(queryString.toString());
			while(result.next()){
				Map<String,String> dataMap = new HashMap<String,String>();
				for(int col=0; col < columns.size(); col++){
					dataMap.put(columns.get(col), result.getString(columns.get(col)));
				}
				dataList.add(dataMap);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		managementInfo.setData(dataList);
		
		return managementInfo;
	}
}
