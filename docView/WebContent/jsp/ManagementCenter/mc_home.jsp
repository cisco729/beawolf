<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Management Center</title>
<link rel="stylesheet" href="themes/base.css">
<script type="text/javascript" src="javascript/jquery-2.1.1.js"></script>
<script type="text/javascript" src="javascript/managementcenter.js"></script>
</head>
<body>
	<%session.setAttribute("headerTitle","Management Center"); %>
	<jsp:include page="../components/header.jsp"></jsp:include>
	
	<html:form action="/managementCenter">
	<div class="sidebar" style="background-color: #CACACA">
		Manage:  <html:select property="manage">
			<html:option value="">---Select---</html:option>
			<html:options collection="manageList" labelProperty="label" property="value"/>
		</html:select>
		<hr style="width:100%">
		<div id="manageContents">
			<ul>
				
			
			</ul>
		</div>
	</div>
		
	</html:form>
</body>
</html>