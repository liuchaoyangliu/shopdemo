<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="java.util.*"
         pageEncoding="UTF-8"%>
<%@ page import="com.lcy.web.entity.Student" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    Student stu = (Student) session.getAttribute("stu");
%>

欢迎:<%= stu.getName()%><br>

个人中心<br>
姓名：<%= stu.getName()%><br>
<a href="updateMsg.jsp">完善个人信息</a>
</body>
</html>