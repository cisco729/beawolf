package com.fmsolutions.database.dao;

import java.util.ArrayList;

import com.fmsolutions.database.base.AbstractDAO;

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

}
