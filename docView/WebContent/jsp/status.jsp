<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Status</title>
<link rel="stylesheet" href="themes/base.css">
<script type="text/javascript">
function status(){
	document.forms[0].action.value;
	document.forms[0].method.value = "status";
	document.forms[0].submit();
}

</script>
</head>
<body style="background-color: white;">
	<%session.setAttribute("headerTitle","Status"); %>
	<jsp:include page="components/header.jsp"></jsp:include>

	<form name="statusForm" action="statusPage;">
	<div class="StatusForm">
			Status Info:
			<ul>
				<li> 
					<span>Status Code:</span> <input type="text" name="statusCode"/>
				</li>
				<li>
					<span>Status Name:</span>  <input type="text" name="statusName"/>
				</li>
			</ul>
	</div>
	</form>
</body>
</html>