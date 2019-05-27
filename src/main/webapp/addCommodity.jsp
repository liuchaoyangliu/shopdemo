<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
<form action="addCommodityServlet" method="post">
    商品名:<input type="text" name="name"/><br>
    类目1:<input type="text" name="class1"/><br>
    类目2:<input type="text" name="class2"/><br>
    价格:<input type="text" name="price"/><br>
    库存:<input type="text" name="totalAmount"/><br>
    描述:<input type="text" name="Description"/><br>
    <input type="submit" value="保存入库"/>
</form>
</body>
</html>
