<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Config Page</title>
<link rel="stylesheet" href="themes/base.css">
<script type="text/javascript" src="javascript/jquery-2.1.1.js"></script>
<script>
var xhr;

function xhrGetCall(url,callback){
	xhr = new XMLHttpRequest();
	xhr.open("GET",url,true);
	xhr.onreadystatechange=callback;
	xhr.send();
	
}

function getCols(tableName){
	var url="http://localhost:8080/docView/config.do?method=getColumnHeaders&tableName="+tableName;
	xhrGetCall(url,function(){
		if(xhr.readyState==4 && xhr.status==200){
			$("#colList").html("");
			var res = JSON.parse(xhr.response);
			res.Columns.forEach(function(cols){
				$("<li>").html(cols.columnName).appendTo($("#colList"));
				});
		}
	});
}

</script>
</head>
<body>
	<%session.setAttribute("headerTitle","Configuration Tables"); %>
	<jsp:include page="components/header.jsp"></jsp:include>
	
	<div id="sidebar" class="sidebar">
		
		<ul>
			<logic:iterate id="tables" name="confTables">
				<li>
					<bean:write name="tables" property="confTableName"/>
				</li>
			</logic:iterate>
		</ul>
	</div>
	
	<div id="confHeadersDiv">
		<ul id="colList">
					
		</ul>
	
	</div>

</body>
</html>