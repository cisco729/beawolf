<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>  
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>  
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>  
<link rel="stylesheet" href="themes/header.css">

<div class="header">
	<div class="compImage">
		Image Here
		<div class="headerTitle">
			<bean:write name="headerTitle"/>
		</div>
		<div class="folderLogo">
			folder logo
		</div>	
	</div>
</div>