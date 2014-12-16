package com.fmsolutions.folder.config;

public class ConfTableInfo {
	private String confTableName;
	
	public ConfTableInfo(String tableName){
		setConfTableName(tableName);
	}
	
	public void setConfTableName(String tableName){
		confTableName = tableName;
	}
	
	public String getConfTableName(){
		return confTableName;
	}
	
}
