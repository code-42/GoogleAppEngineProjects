<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="net.ed.JsoupScraper" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
This is index.jsp<br>
edit web.xml to run this file on startup<br>
The time on the server is <%= new java.util.Date() %><br>
Request user agent: <%= request.getHeader("User-Agent") %><br>
Local language: <%= request.getLocale() %>

    <table>
      <tr><td colspan="2" style="font-weight:bold;">Available Servlets:</td></tr>
      <tr><td><a href="/hello">HelloAppEngine</a></td></tr>
      <tr><td><a href="/HelloWorldServlet">HelloWorldServlet</a></td></tr>
       <tr><td><a href="/QuoteTableServlet">QuoteTableServlet</a></td></tr>
       <tr><td><a href="/CoinMarketCapServlet">CoinMarketCap Scraper</a></td></tr>
    </table>

Enter a ticker symbol to download QuoteTable file: 


</body>
</html>