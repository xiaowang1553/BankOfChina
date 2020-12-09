<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/jquery/1.8.3/jquery.js"></script>
    <script type="text/javascript">
    $(function(){
       $("#btn").click(function(){
         $.ajax({
          url:"login",
          type:"POST",
          dataType:"string",
          success:function(msg){
           console.log(msg);
          }
         })
       })
    })
    </script>
  </head>
  
  <body>
    <a href="userRegister">点击跳转</a>
    <form action="userRegisterValidate" method="post">
    id:<input name="id" type="text" /> <br>
    username: <input name="userName" type="text"></input><br>
    password:<input name="password" type="password"/><br>
    address:<input name="address" type="text"/><br>
    phoneNum:<input name="phoneNum" type="text"/><br>
    <input type="submit" id="sub" value="登录" ><br>
    <input type="button" name="btn" value="1000"/>
    </form>
  </body>
</html>
