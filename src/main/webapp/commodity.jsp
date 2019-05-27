<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="java.util.*"
         pageEncoding="UTF-8"%>
<%@ page import="com.lcy.web.entity.User" %>
<%@ page import="com.lcy.web.entity.Commodity" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>

<%
    LinkedList<Commodity> listCommodity = (LinkedList<Commodity>) request.getAttribute("listCommodity");
%>

<div>
    <table border= 0 >

        <tr>
            <th>标识</th>
            <th>商品名</th>
            <th>类目1</th>
            <th>类目2</th>
            <th>价格</th>
            <th>库存</th>
            <th>描述</th>
            <th>删除</th>
        </tr>

        <%
            for(int i=0; i<listCommodity.size(); i++){
                Commodity  commodity = listCommodity.get(i);
        %>
        <tr>
            <td> <input type="text" value="<%= commodity.getUuid()%>" readonly></td>
            <td> <input type="text" value="<%= commodity.getName()%>" readonly></td>
            <td> <input type="text" value="<%= commodity.getClass1()%>" readonly></td>
            <td> <input type="text" value="<%= commodity.getClass2()%>" readonly></td>
            <td> <input type="text" value="<%= commodity.getPrice()%>" readonly></td>
            <td> <input type="text" value="<%= commodity.getTotalAmount()%>" readonly></td>
            <td> <input type="text" value="<%= commodity.getDescription()%>" readonly></td>
            <td> <a href="deleteCommodityServlet?id=<%= commodity.getUuid() %>">删除</a></td>
        </tr>
        <%
            }
        %>

    </table>
</div>
<div>
    <input type = "button" value = "添加商品" onclick = "window.location.href = 'addCommodity.jsp'">

</div>
<script>

</script>

</body>
</html>
