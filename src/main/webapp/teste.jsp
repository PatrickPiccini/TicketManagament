<%@page import="com.massa.servlet.Servlet" %>
<%@page import="com.massa.dbutilities.BDManip" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>
<%
	BDManip.viewTickets(1);
%>
</p>
</body>
</html>