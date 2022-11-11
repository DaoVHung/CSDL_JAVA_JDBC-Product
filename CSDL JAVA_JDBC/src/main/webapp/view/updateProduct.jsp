<%--
  Created by IntelliJ IDEA.
  User: GentMaker
  Date: 11/11/2022
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="CSS/ProductCSS.css">
<html>
<head>
    <title>SEARCH</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ProductServlet" method="POST">
    <h1>Update Product</h1>

    <table border="1px">
        <tr>
            <td>Book ID</td>
            <td><input type="text" name="productId" value="${productUpdate.productId}" readonly></td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td><input type="text" name="productName" value="${productUpdate.productName}"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="${productUpdate.price}"></td>
        </tr>
        <tr>
            <td>Created</td>
            <td><input type="date" name="created" value="${productUpdate.created}"></td>
        </tr>
        <tr>
            <td>Descreptions</td>
            <td><input type="text" name="descriptions" value="${productUpdate.descriptions}"></td>
        </tr>
        <tr>
            <td>Status</td>
            <td><select name="productStatus" id="Status">
                <option value="true">Hoat Dong</option>
                <option value="false">Ko Hoat Dong</option>
            </select></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Update" name="action"></td>
        </tr>
    </table>
</form>
</body>
</html>
