<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>error</title>
</head>
<body>
<p>发生错误</p>
<div class="MSG">
  <%
  if(request.getAttribute("error")!=null){
  out.print(request.getAttribute("error"));
  }
  %>
</div>
<a href="index.jsp">返回</a>
</body>
</html>