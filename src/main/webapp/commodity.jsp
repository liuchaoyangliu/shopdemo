
<%@ page import="com.lcy.web.entity.User" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.lcy.web.entity.Commodity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
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

        </td>
    <tr>
</table>

</body>
</html>

