package com.fmsolutions.folder.login;

public class LoginConstants {

	public static final String getPasswordQuery = "select user_id, password from user_profile where user_id = (select user_id from user where user_alias = '?')";
}
