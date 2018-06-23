<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.simplejavaee.model.NameM"%>
<jsp:useBean id="nameM" scope="session" class="com.simplejavaee.model.NameM"/>

<%
String yourName = nameM.getName();
System.out.println(" ################################################################# : yourName : " + yourName);
%>

Your name: <%=yourName%>


</body>
</html>