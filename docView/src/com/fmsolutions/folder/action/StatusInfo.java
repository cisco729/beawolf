package com.fmsolutions.folder.action;

public class StatusInfo {
	// declare variables
	private String statusCode;
	private String statusName;
	private String maintId;
	private String maintDate;
	
	
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMaintId() {
		return maintId;
	}
	public void setMaintId(String maintId) {
		this.maintId = maintId;
	}
	public String getMaintDate() {
		return maintDate;
	}
	public void setMaintDate(String maintDate) {
		this.maintDate = maintDate;
	}
	
}
