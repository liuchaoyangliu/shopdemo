<%@ page import="com.lcy.web.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>

<form action="userUpdateServlet" method="post">
    用户名:<input type="text" name="username" value="<%= user.getUsername()%>"/><br>
    密码:<input type="text" name="password" value="<%= user.getPassword()%>"/><br>
    年龄:<input type="text" name="age" value="<%= user.getAge()%>"/><br>
    性别:<input type="text" name="sex" value="<%= user.getSex()%>"/><br>
    家庭住址:<input type="text" name="address" value="<%= user.getAddress()%>"/><br>
    联系方式:<input type="text" name="phone" value="<%= user.getPhone()%>"/><br>
    email:<input type="text" name="email" value="<%= user.getEmail()%>"/><br>
    <input type="hidden" name="target" value="1">
    <input type="hidden" name="uuid" value="<%= user.getUuid()%>">
    <input type="submit" value="保存">
</form>

</body>
</html>
