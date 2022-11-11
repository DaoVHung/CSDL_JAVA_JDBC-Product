<%--
  Created by IntelliJ IDEA.
  User: GentMaker
  Date: 11/11/2022
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="../CSS/ProductCSS.css">
    <title>ADD</title>
</head>
<body>
<form id="t1" action="<%=request.getContextPath()%>/ProductServlet" method="POST">
    <h1>Creat Product</h1>
    <table border="1px">
<%--        <tr>--%>
<%--            <td>Book ID</td>--%>
<%--            <td><input type="text" name="null"></td>--%>
<%--        </tr>--%>
        <tr>
            <td>Product Name</td>
            <td><input type="text" name="productName"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>Created</td>
            <td><input type="date" name="created"></td>
        </tr>
        <tr>
            <td>Descreptions</td>
            <td><input type="text" name="descriptions"></td>
        </tr>
        <tr>
            <td>Status</td>
            <td><select name="productStatus" id="productStatus">
                <option value="true">Hoat Dong</option>
                <option value="false">Ko Hoat Dong</option>
            </select></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Create" name="action"></td>
        </tr>
        <tr>
            <td colspan="2">
                <a href="product.jsp"> Return Menu </a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
