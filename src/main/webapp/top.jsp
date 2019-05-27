<%@ page import="com.lcy.web.entity.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = null;
    User user = (User) session.getAttribute("user");
    if(user != null){
        name = user.getUsername();
    }
%>
<%
    if(name != null){
        out.print("当前登录的用户是:" + name);
    }
%>
</body>
</html>
