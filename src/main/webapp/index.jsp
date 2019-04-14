<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<h1 style="color:#ff0000">登录</h1>
<form action="loginServlet" method="get">
    用户名：<input type="text" name="name"><br>
    密 码：<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>