<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="java.util.*"
         pageEncoding="UTF-8"%>
<%@ page import="com.lcy.web.entity.Student" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>updateInfo</title>
</head>
<body>
<%
//    Student stu = (Student) session.getAttribute("stu");
    ServletContext servletContext = request.getServletContext();
    Student stu = (Student)servletContext.getAttribute("stu");
%>

欢迎:<%= stu.getName()%><br>
掌握技术<br>
<form action="techServlet" method="get">
    <input type="checkbox" name="category" value="android" />android
    <input type="checkbox" name="category" value="ios" />ios
    <input type="checkbox" name="category" value="java web" />java web
    <input type="checkbox" name="category" value="c#" />c#<br>
    <input type="submit" value="完成">
</form>

</body>
</html>