var xhr;
var userAvailable;

function xhrGetCall(url,callback){
	xhr = new XMLHttpRequest();
	xhr.open("GET",url,true);
	xhr.onreadystatechange=callback;
	xhr.send();
	
}

function checkUserName(){
	var userAlias = $("[name=userAlias]")[0].value;
	var url="http://localhost:8080/docView/regServices.do?method=checkExistingUserId&userAlias="+userAlias;
	
	xhrGetCall(url,function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = JSON.parse(xhr.response);
			var alias = $("[name=userAlias]")[0];
			var showStatus;
			
			if(res.exists=="true"){
				showStatus = "images/invalid.png"	
				userAvailable = "false";
			}
			else{
				showStatus = "images/checkmark.jpeg"
				userAvailable = "true";
			}
			$("#userAliasStatus").attr("src",showStatus);
			$("#userAliasStatus").fadeIn("fast",function(){
				
			});
		}
	});
	
}

function registerUser(){
	if(userAvailable == "true"){
		var url = "/docView/regServices.do?method=registerUser";
		var params = $("[name=registrationForm").serialize();
		var params;
		if($("[name=password]")[0].value == $("[name=confirmPassword]")[0].value){
			var url = url+"&"+params;
			xhrGetCall(url, function(){
				if(xhr.readyState==4 && xhr.status==200){
					var result = xhr.responseText;
				}
			});
		}
	}
}