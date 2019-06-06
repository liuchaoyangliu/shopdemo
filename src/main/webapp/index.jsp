<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<%--<input type = "button" value = "前台系统" onclick = "window.location.href = 'frontDesk.jsp'"><br>--%>
<%--<input type = "button" value = "后台系统" onclick = "window.location.href = 'loginServlet'">--%>

<a href="http://www.baidu.com">百度</a><br>

功能1： 转义<br>
<c:out value="<a href='http://www.baidu.com'>百度</a>" escapeXml="false"></c:out><br>
<%--<c:out value="直接显示一个String内容"></c:out><br>--%>

功能1： 设置默认值<br>
<c:out value="${null }" default="该值为空或者不存在" escapeXml="true"></c:out>


</body>
</html>

