<%@ page import="com.lcy.web.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>前台系统</title>
</head>
<body>

<table>
    <tr ><td colspan="2" align="right">
        <jsp:include page="top.jsp"/>

    </td></tr>
    <tr  valign="top">
        <td width="20%">
            <%@include file="left.jsp" %>
        </td>
        <td align="center" valign="middle" height="50%">
            欢迎使用本系统
            <%
                String name = null;
                User user = (User) session.getAttribute("user");
                if(user != null){
                    name = user.getUsername();
                }
                if(name == null){
            %>
            <form action="loginServlet" method="get">
                用户名:<input type="text" name="username"/><br>
                密码:<input type="password" name="password"/><br>
                <input type="hidden" name="type" value="front"/>
                <input type="submit" value="登录"/>
            </form>
            <%
                }
            %>
        </td>
    <tr>
</table>


</body>
</html>
