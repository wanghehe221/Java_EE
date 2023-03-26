<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录成功</title>
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
<form action="" method="get">
    <%
    String username=session.getAttribute("Name").toString();
    %>
    欢迎
    <%
    out.print("用户名为： "+username+"的用户");
    %>
</form>
<form action="jndi"  method="get">
<span class="errorMsg">
  <br>
  <div class="US"> 绑定名称：<input type="text"  name="bindname" value="" /></div><br>
  <div class="MSG">
    <%
        if(request.getAttribute("value")!=null){
            out.print("查找结果为："+request.getAttribute("value"));
        }
    %>
  </div>
  <br>
  <div class="BT">
    <input type="submit" name="submit" value="查找"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </div>
    </span>
</form>


<form action="jndi"  method="post">
    <input type="text" name="_method" style = "display:none"  value="delete" >
<span class="errorMsg">
  <br>
  <div class="US"> 解绑名称：<input type="text"  name="bindname" value="" /></div><br>
  <div class="MSG">
    <%
        if(request.getAttribute("deletevalue")!=null){
            out.print("删除绑定值："+request.getAttribute("deletevalue"));
        }
    %>
  </div>
  <br>
  <div class="BT">
    <input type="submit" name="submit" value="解绑"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </div>
    </span>
</form>

<form action="jndi"  method="post">
    <input type="text" name="_method" style = "display:none"  value="post" >
<span class="errorMsg">
  <br>
  <div class="US"> 绑定名称：<input type="text"  name="bindname" value="" /></div><br>
  <div class="PW">绑定值：<input type="text"  name="bindvalue" value="" /></div><br>
  <div class="BT">
    <input type="submit" name="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </div>
    </span>
</form>

<form action="jndi"  method="post">
    <input type="text" name="_method" style = "display:none"  value="put" >
<span class="errorMsg">
  <br>
  <div class="US"> 绑定名称：<input type="text"  name="bindname" value="" /></div><br>
  <div class="PW">绑定值：<input type="text"  name="bindvalue" value="" /></div><br>
  <div class="BT">
    <input type="submit" name="submit" value="重新绑定"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </div>
    <div class="MSG">
    <%
        if(request.getAttribute("revalue")!=null){
            out.print("重新绑定值为："+request.getAttribute("revalue"));
        }
    %>
  </div>
    </span>
</form>
</body>
</html>