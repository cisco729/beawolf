var xhr;

function xhrGetCall(url,callback){
	xhr = new XMLHttpRequest();
	xhr.open("GET",url,true);
	xhr.onreadystatechange=callback;
	xhr.send();
	
}

function manage(){
	var choice = $(mcForm)[0].manage.value;
	url = "http://localhost:8080/docView/managementServices.do?method=getManagementInfo&tablename="+choice;
	
	xhrGetCall(url,function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = JSON.parse(xhr.response);
		}
	});
	
}