
<%@ page import="com.lcy.web.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>

<table>
    <tr ><td colspan="2" align="right">
        <jsp:include page="top.jsp"/>

    </td></tr>
    <tr  valign="top">
        <td width="20%">
            <%@include file="leftFront.jsp" %>
        </td>
        <td align="center" valign="middle" height="50%">

        <%
            String name = null;
            User user = (User) session.getAttribute("user");
            if(user != null){
                name = user.getUsername();
            }
        %>

        <%
            if(name == null){
        %>

        <%= "当前用户未登录"%><br>
            <h1 style="align-content: center; color: red">后台管理系统（需要登录才可以做相关操作）</h1>

            <div align="center">
    <tr>
        <th>登录</th>
    </tr>
    <form action="loginServlet" Method="get">
        用户名:<Input type=text name="name" value="super_admin"><br>
        密码:<Input type=password name="password"><br>
        <Input type=submit  value="登录">
    </form>
    </div>

    <%
    }else {
    %>

    <%= "欢迎:" + name%>

    <%
        }
    %>
    <br>

    </td>
    <tr>
</table>

</body>
</html>

