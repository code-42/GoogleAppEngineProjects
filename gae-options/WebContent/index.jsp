<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="net.ed.QuoteTableDownload" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>You Got Options</title>
</head>
<body>

The time on the server is <%= new java.util.Date() %><br>
Request user agent: <%= request.getHeader("User-Agent") %><br>
Local language: <%= request.getLocale() %>

<form action="QuoteTableServlet" method="GET">
	enter stock symbol: 
	<input type="text" name="ticker">
	<input type="submit" value="Submit">
</form>


</body>
</html>