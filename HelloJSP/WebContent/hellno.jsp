<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "duke";
	public String getName(){ return name; }
%>
<%
	String age = request.getParameter("age");
%>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b2>Hell No World<br></b2>
	<b2><%=name %><br></b2>
	<b2><%=age %><br></b2>
</body>
</html>