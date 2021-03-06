<%@ page import="com.lcy.web.entity.Commodity" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>全部商品</title>
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
                LinkedList<Commodity> listCommodity = (LinkedList<Commodity>) request.getAttribute("listCommodity");
            %>

            <table border= 0 >

                <tr>
                    <th>标识</th>
                    <th>商品名</th>
                    <th>类目</th>
                    <th>价格</th>
                    <th>库存</th>
                    <th>描述</th>
                    <th>操作</th>
                </tr>

                <%
                    for(int i=0; i<listCommodity.size(); i++){
                        Commodity  commodity = listCommodity.get(i);
                %>
                <tr>
                    <td> <input type="text" value="<%= commodity.getUuid()%>" readonly></td>
                    <td> <input type="text" value="<%= commodity.getName()%>" readonly></td>
                    <td> <input type="text" value="<%= commodity.getClass1() + ", " + commodity.getClass2()%>" readonly></td>
                    <td> <input type="text" value="<%= commodity.getPrice()%>" readonly></td>
                    <td> <input type="text" value="<%= commodity.getTotalAmount()%>" readonly></td>
                    <td> <input type="text" value="<%= commodity.getDescription()%>" readonly></td>
                    <td> <a href="shopCartServlet?uuid=<%= commodity.getUuid() %>">添加到购物车</a></td>
                </tr>
                <%
                    }
                %>

            </table>

        </td>
    <tr>
</table>


</body>
</html>