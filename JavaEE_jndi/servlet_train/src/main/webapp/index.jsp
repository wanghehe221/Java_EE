<%--
  Created by IntelliJ IDEA.
  User: WL
  Date: 2023-03-07
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>登录</title>
</head>
<style>
  /*这是设置样式，使他们居中*/
  div.US{
    text-align:center;
  }
  div.PW{
    text-align:center;
  }
  div.MSG{
    text-align:center;
  }
  div.BT{
    text-align:center;
  }
  div.CC{
    text-align:center;
  }
  a.bb{
    text-align:center;
  }
</style>
<body>
<a >（测试）用户名为：张三  密码为：123456</a>
<form action="res"  method="post">
<span class="errorMsg">
  <br>
  <div class="US"> 用户名：<input type="text"  name="username" value="" /></div><br>
  <div class="PW">密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="text"  name="password" value="" /></div><br>
  <br>
  <div class="MSG">
    <%
      if(request.getAttribute("Msg")!=null){
        out.print(request.getAttribute("Msg"));
      }
    %>
  </div>
  <br>
  <div class="BT">
    <input type="submit" name="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </div>
  </span>
</form>
<div class="cc">
  </div>
</body>
</html>