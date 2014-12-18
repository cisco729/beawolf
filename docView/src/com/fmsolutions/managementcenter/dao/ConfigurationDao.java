package com.fmsolutions.managementcenter.dao;

import java.util.ArrayList;

import com.fmsolutions.commons.LabelValueBean;
import com.fmsolutions.database.base.AbstractDAO;

public class ConfigurationDao extends AbstractDAO{

	public ArrayList<LabelValueBean> getManageTables(){
		//declare variables
		ArrayList<LabelValueBean> managementList = new ArrayList<LabelValueBean>();
		StringBuffer queryString = new StringBuffer();
		
		//Query to get managementList from database
		queryString.append("Select table_name, display_name ");
		queryString.append("from mc_conf_manage ");
		queryString.append("where status_code = 'A' ");
		queryString.append("order by order_id");
		
		try{
			//Query Database
			result = dbSelect(queryString.toString());
			
			//loop through result and set label value beans to an array list
			while(result.next()){
				LabelValueBean lvb = new LabelValueBean(result.getString("display_name"),result.getString("table_name"));

				managementList.add(lvb);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return managementList;
		 
	}
}
