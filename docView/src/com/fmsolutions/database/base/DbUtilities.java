package com.fmsolutions.database.base;


public class DbUtilities {
	
	public static String constructQuery(String query, String[] params){
		String queryString;
		
		for(int count=0;count<params.length;count++){
			query=query.replaceFirst("\\?", params[count]);
		}
		
		return query;
	}
}
