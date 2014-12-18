package com.fmsolutions.commons;

public class LabelValueBean{
	
	private String label;
	private String value;
	
	public LabelValueBean(){
		super();
	}
	
	public LabelValueBean(String label, String value){
		this.setLabel(label);
		this.setValue(value);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
