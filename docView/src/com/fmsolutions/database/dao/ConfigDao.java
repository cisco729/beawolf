package com.fmsolutions.database.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fmsolutions.database.base.AbstractDAO;
import com.fmsolutions.folder.config.ConfTableInfo;

public class ConfigDao extends AbstractDAO{
	
	public ArrayList<String> getStores(){
		StringBuffer queryString = new StringBuffer();
		ArrayList<String> storeList = new ArrayList<String>();
		
		queryString.append("Select store_id from stores");
		try{
			result = dbSelect(queryString.toString());
			while(result.next()){
				storeList.add(result.getString("store_id"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return storeList;
	}
	
	public ArrayList<ConfTableInfo> getConfTables(){
		ArrayList<ConfTableInfo> confTableList = new ArrayList<ConfTableInfo>();
		
		StringBuffer queryString = new StringBuffer();
		queryString.append("SELECT tab_table_name ");
		queryString.append("From Config_Tabs ");
		queryString.append("Where tab_status = 'A'");
		
		try{
			result = dbSelect(queryString.toString());
			
			while(result.next()){
				confTableList.add(new ConfTableInfo(result.getString("tab_table_name")));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return confTableList;
	}
	
	public ArrayList<Map<String,String>> getTableColumns(String tableName){
		ArrayList<Map<String,String>> columns = new ArrayList<Map<String,String>>();
		final String columnName = "columnName";
		StringBuffer queryString = new StringBuffer();
		queryString.append("select column_name ");
		queryString.append("from information_schema.columns ");
		queryString.append("where table_name = '"+tableName+"'");
		
		try{
			result=dbSelect(queryString.toString());
			while(result.next()){
				Map<String,String> columnRow = new HashMap<String,String>();
				columnRow.put(columnName, result.getString("column_name"));
				columns.add(columnRow);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return columns;
	}

}
