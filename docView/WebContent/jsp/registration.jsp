<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="themes/base.css">
<title>Registration</title>
<script type="text/javascript" src="javascript/jquery-2.1.1.js"></script>
<script type="text/javascript" src="javascript/registration.js"></script>

<script>
function reset(){
	$("input").val("");
	$("#userAliasStatus").attr("src","");
	$("#userAliasStatus").css("display","none");
}

</script>

</head>
<body style="background-color: black;">
	<%session.setAttribute("headerTitle","Registration"); %>
	<jsp:include page="components/header.jsp"></jsp:include>

	<form name="registrationForm" action="doNothing();">
	<div class="loginInfo">
			Login Information:
			<ul>
				<li>
					<span>User Name:</span> <input type="text" name="userAlias" onchange="checkUserName();"/>
					<img id="userAliasStatus" style="display:none;"></img>
				</li>
				<li>
					<span>Password:</span>  <input type="password" name="password"/>
				</li>
				<li>
					<span>Confirm Password:</span>  <input type="password" name="confirmPassword"/>
				</li>
			</ul>		
		</div>
		<hr>
		<div class="info">
		Personal Information:
		<ul>
			<li>
			<span>First Name:</span>  <input type="text" name="firstName"/>
			</li>
			<li>
			<span>Middle Initial:</span> <input type="text" name="middleInitial"/>
			</li>
			<li>
			<span>Last Name:</span>  <input type="text" name="lastName"/>
			</li>
			<li>		
			<span>Address1:</span>  <input type="text" name="address"/>
			</li>
			<li>
			<span>Address2:</span>  <input type="text" name="address2"/>
			</li>
			<li>
			<span>City:</span>	   <input type="text" name="city"/>
			</li>
			<li>
			<span>State:</span>	   <input type="text" name="state"/>
			</li>
			<li>
			<span>Phone:</span>	   <input type="text" name="phoneNumber"/>
			</li>
			<li>
			<span>E-mail Address:</span>  <input type="text" name="email"/>
			</li>
		</ul>
		</div>
		<hr>
	</form>
	
	<button type="submit" title="Register" name="submitButton" style="margin-left:34%;" onclick="registerUser();">Register</button>
	<button type="submit" title="Reset" name="submitButton" style="margin-left:6%;" onclick="reset();">Clear</button>
	
</body>
</html>