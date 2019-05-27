<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="java.util.*"
         pageEncoding="UTF-8"%>
<%@ page import="com.lcy.web.entity.User" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    LinkedList<User> linkUser = (LinkedList<User>) request.getAttribute("linkUser");
%>

<table border= 0 >

    <tr>
        <th>uuid</th>
        <th>用户名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>性别</th>
        <th>地址</th>
        <th>电话</th>
        <th>email</th>
        <th>最高学历</th>
        <th>毕业学校</th>
        <th>专业</th>
        <th>删除</th>
    </tr>

    <%
        for(int i=0; i<linkUser.size(); i++){
            User user = linkUser.get(i);
    %>
        <tr>
            <td> <input type="text" value="<%= user.getUuid()%>" size="25" readonly></td>
            <td> <input type="text" value="<%= user.getUsername()%>" size="10" readonly></td>
            <td> <input type="text" value="<%= user.getPassword()%>" size="7" readonly></td>
            <td> <input type="text" value="<%= user.getAge()%>" size="7" readonly></td>
            <td> <input type="text" value="<%= user.getSex()%>" size="7" readonly></td>
            <td> <input type="text" value="<%= user.getAddress()%>" size="7" readonly></td>
            <td> <input type="text" value="<%= user.getPhone()%>" size="7" readonly></td>
            <td> <input type="text" value="<%= user.getEmail()%>" size="7" readonly></td>
            <td> <input type="text" value="<%= user.getEducation()%>" size="7" readonly></td>
            <td> <input type="text" value="<%= user.getSchool()%>" size="7" readonly></td>
            <td> <input type="text" value="<%= user.getProfession()%>" size="7" readonly></td>
            <td> <a href="deleteUserServlet?id=<%= user.getUuid() %>">删除</a></td>
        </tr>
    <%
        }
    %>

</table>
<div>
    <input type = "button" value = "增加用户" onclick = "window.location.href = 'addUser.jsp'">

</div>
<script>

</script>

</body>
</html>
