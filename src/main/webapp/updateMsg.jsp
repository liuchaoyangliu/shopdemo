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
    Student stu = (Student) session.getAttribute("stu");
%>
欢迎: <%= stu.getName()%>
<form action="profSchoolServlet" method="get">
    学校名称：<input type="text" name="school" value="<%= stu.getSchool()%>"><br>
    专业方向：<select name="prof">
                <option value ="大数据">大数据</option>
                <option value ="移动互联网">移动互联网</option>
                <option value="金融">金融</option>
                <option value="互联网">互联网</option>
            </select><br>
    <input type="submit" value="下一步">
</form>

</body>
</html>