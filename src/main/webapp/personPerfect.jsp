<%@ page import="com.lcy.web.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>完善个人信息</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>
<from action="userUpdateServlet" method="post">
    最高学历：<input type="text" name="education" value="<%= user.getEducation()%>"><br>
    毕业院校：<input type="text" name="school" value="<%= user.getSchool()%>"><br>
    所学专业：<input type="text" name="profession" value="<%= user.getProfession()%>"><br>
    <input type="hidden" name="target" value="2">
    <input type="hidden" name="uuid" value="<%= user.getUuid()%>">
    <input type="submit" value="保存">
</from>

</body>
</html>
