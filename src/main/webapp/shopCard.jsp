<%@ page import="com.lcy.web.entity.User" %>
<%@ page import="com.lcy.web.entity.Commodity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
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
                List<Commodity> shopList = (List<Commodity>) request.getAttribute("shopList");
            %>

            <%
                double totolPrice = 0;
                for (int i = 0; i < shopList.size(); i++) {
                    totolPrice += shopList.get(i).getPrice();
                }
            %>

            <table border= 0 >

                <tr>
                    <th>商品名</th>
                    <th>类目</th>
                    <th>描述</th>
                    <th>删除</th>
                </tr>

                <%
                    for(int i=0; i<shopList.size(); i++){
                        Commodity  commodity = shopList.get(i);
                %>
                <tr>
                    <td> <input type="text" value="<%= commodity.getName()%>" readonly></td>
                    <td> <input type="text" value="<%= commodity.getClass1() + "," + commodity.getClass2()%>" readonly></td>
                    <td> <input type="text" value="<%= commodity.getDescription()%>" readonly></td>
                    <td> <input type="text" value="<%= commodity.getPrice()%>" readonly></td>
                    <td> <a href="shopCartServlet?deleteCommodity=<%= commodity.getUuid() %>">删除</a></td>
                </tr>
                <%
                    }
                %>

            </table>

            <h5>总价： <%= totolPrice%> </h5>

        </td>
    <tr>
</table>

</body>
</html>