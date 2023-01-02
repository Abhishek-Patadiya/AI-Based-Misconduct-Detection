<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	
	function fn1 (){
		var userName = document.getElementById("userName");
		var loginId = document.getElementById("loginId");
		
		alert(userName.value);
		alert(loginId);
		alert(loginId.value);
		
		
		htp = new XMLHttpRequest();
		
		htp.onreadystatechange = function(){
			
			if(readyState==4){
				
				alert(htp.responseText)
			}
		}
		htp.open("get","http://127.0.0.1:5011/?userName="+userName.value+"&loginId="+loginId.value,true);
		htp.send();
	}
	

</script>
</head>
<body>
	<input type="hidden" id="loginId" value="${loginVO.loginId}">
	<input type="hidden" id = "userName" value="${loginVO.username}">
	<input type="button" value="Detection" onclick="fn1()">
	
</body>
</html>