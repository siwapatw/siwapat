<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World Java EE</title>
</head>
<body>
	<h1>Hello JSP and Servlet!</h1>

<form name="helloServletForm" action="SimpleJavaEEServlet" method="post">
	<input type="hidden" name="action" value="searchName">
		
	Enter your name: 
	<input type="text" id="yourName" name="yourName" size="20">
	<input type="button" value="Call Servlet" onclick="javascript:validateTextBox();"/>
	
		
</form>

<script language="JavaScript" type="text/JavaScript">
function validateTextBox() {
	var yourName = document.getElementById("yourName").value;
	if( trim_space(yourName)!=''){
		document.helloServletForm.submit();		
	} else {
		alert('Please submit your name!!');
	}
}

function trim_space(str) {
	while (str.substring(0,1) == ' ')
		str = str.substring(1);
	while (str.substring(str.length-1,str.length) == ' ')
		str = str.substring(0,str.length-1);
	return str;
}
</script>
</body>
</html>