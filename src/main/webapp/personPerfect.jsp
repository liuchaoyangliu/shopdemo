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
            <%@include file="left.jsp" %>
        </td>
        <td align="center" valign="middle" height="50%">

            <%
                User user = (User) request.getAttribute("user");
            %>
            <form action="userUpdateServlet" method="post">
                最高学历：<input type="text" name="education" value="<%= user.getEducation()%>"><br>
                毕业院校：<input type="text" name="school" value="<%= user.getSchool()%>"><br>
                所学专业：<input type="text" name="profession" value="<%= user.getProfession()%>"><br>
                <input type="hidden" name="target" value="2">
                <input type="hidden" name="uuid" value="<%= user.getUuid()%>">
                <input type="submit" value="保存">
            </form>

        </td>
    <tr>
</table>

</body>
</html>