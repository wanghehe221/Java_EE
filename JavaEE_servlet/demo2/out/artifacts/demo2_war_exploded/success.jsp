<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录成功</title>
</head>
<body>
<form action="loginServlet" method="get">
    <%
    String username=session.getAttribute("Name").toString();
    %>
    欢迎
    <%
    out.print("用户名为： "+username+"的用户");
    %>
</form>
</body>
</html>