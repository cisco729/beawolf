package com.fmsolutions.managementcenter.services;

import java.util.ArrayList;
import java.util.Map;

public class ManagementInfo {
	private String tablename;
	private ArrayList<String> columns;
	private ArrayList<Map<String,String>> data;
	
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public ArrayList<String> getColumns() {
		return columns;
	}
	public void setColumns(ArrayList<String> columns) {
		this.columns = columns;
	}
	public ArrayList<Map<String, String>> getData() {
		return data;
	}
	public void setData(ArrayList<Map<String, String>> data) {
		this.data = data;
	}
	
	
}
