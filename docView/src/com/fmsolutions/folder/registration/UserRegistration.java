package com.fmsolutions.folder.registration;

public class UserRegistration {
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String address;
	private String address2;
	private String city;
	private String state;
	private String phoneNumber;
	private String userName;
	private String password;
	private String email;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = validateString(email);
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = validateString(firstName);
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = validateString(middleInitial);
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = validateString(lastName);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = validateString(address);
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = validateString(address2);
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = validateString(city);
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = validateString(state);
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = validateString(phoneNumber);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = validateString(userName);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = validateString(password);
	}
	
	private String validateString(String value){
		if(value.equalsIgnoreCase("")){
			return null;
		}
		else{
			return value;
		}
	}
	
}
