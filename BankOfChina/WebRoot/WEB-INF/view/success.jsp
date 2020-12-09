<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<a href="accountLogin">账户登录</a>
<form action="accountLogin" method="post">
账户类型：<input type="text" name="type"/><br>
卡号：<input type="text" name="accountNum"/><br>
密码：<input type="password" name="password"/><br>
<input type="submit" value="登录" />
</form>
  <h2>SUCCESS</h2>
</body>
</html>