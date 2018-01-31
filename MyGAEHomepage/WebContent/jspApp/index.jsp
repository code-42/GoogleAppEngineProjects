<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>My GAE Homepage</title>
</head>
<body>

<jsp:include page="header.html" />
<br>
Hello from /WebContent/index.jsp
<br>

<br>User-Agent: 
<%= request.getHeader("User-Agent") %>
<br><br>

<br>
<jsp:include page="footer.jsp" />
</body>
</html>