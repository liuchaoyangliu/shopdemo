<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="java.util.*"
         pageEncoding="UTF-8"%>
<%@ page import="com.lcy.web.entity.Student" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<%
//    Student stu = (Student) session.getAttribute("stu");
    ServletContext servletContext = request.getServletContext();
    Student stu = (Student)servletContext.getAttribute("stu");
%>


欢迎<%= stu.getName()%><br>
<a href="index.jsp">首页</a><br>
<a href="msg.jsp">个人中心</a>
</body>
</html>
