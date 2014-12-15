<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="themes/base.css">
<script type="text/javascript">
function login(){
	document.forms[0].action.value;
	document.forms[0].method.value = "login";
	document.forms[0].submit();
}

</script>
</head>
<body>
	<%session.setAttribute("headerTitle","Login"); %>
	<jsp:include page="components/header.jsp"></jsp:include>
	
	<html:form name="loginForm" type="com.fmsolutions.folder.login.LoginForm" action="login" method="POST">
	<html:hidden property="method" value="login"/>
	<div class="loginInfo">
			Please Login:
			<ul>
				<li>
					<span>User Name:</span> <input type="text" name="userAlias"/>
				</li>
				<li>
					<span>Password:</span>  <input type="password" name="password"/>
				</li>
			</ul>
	</html:form>	
			<button type="submit" title="Login" name="submitButton" style="margin-left:34%;width:30%;" onclick="login();">Login</button>		
		</div>
	
</body>
</html>