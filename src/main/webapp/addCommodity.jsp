
<%@ page import="com.lcy.web.entity.User" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.lcy.web.entity.Commodity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
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

            <form action="addCommodityServlet" method="post">
                商品名:<input type="text" name="name"/><br>
                类目1:<input type="text" name="class1"/><br>
                类目2:<input type="text" name="class2"/><br>
                价格:<input type="text" name="price"/><br>
                库存:<input type="text" name="totalAmount"/><br>
                描述:<input type="text" name="Description"/><br>
                <input type="submit" value="保存入库"/>
            </form>

        </td>
    <tr>
</table>

</body>
</html>

