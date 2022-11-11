<%--
  Created by IntelliJ IDEA.
  User: GentMaker
  Date: 11/11/2022
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel="stylesheet" href="CSS/ProductCSS.css">
    <title>List Product</title>
</head>
<body>
<h2>List Product In Store</h2>
<table>
    <tr>
        <td><a id="a1" href="view/addProduct.jsp">Create Product</a>
            <form id="t3" action="<%=request.getContextPath()%>/ProductServlet" method="POST">
            <input type="submit" value="Sort By Price" name="action">
            </form>
        </td>
    </tr>
</table>

<table border="1px">

    <thead>
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Date</th>
        <th>Descriptions</th>
        <th>Product Status</th>
        <th colspan="2">EDIT</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${listProduct}" var="p">
        <tr>
            <td>${p.productId}</td>
            <td>${p.productName}</td>
            <td>${p.price}</td>
            <td><fmt:formatDate value="${p.created}" pattern="dd-MM-yyyy"/></td>
            <td>${p.descriptions}</td>
            <td>
                <c:choose>
                    <c:when test="${p.productStatus}">Hoat Dong</c:when>
                    <c:otherwise>KO Hoat Dong</c:otherwise>
                </c:choose>

            </td>
            <td>
                <a id="update" href="<%=request.getContextPath()%>/ProductServlet?productId=${p.productId}&&action=update"> Update </a>
            </td>
            <td>
                <a id="delete" href="<%=request.getContextPath()%>/ProductServlet?productId=${p.productId}&&action=delete"> Delete </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<table>
    <tr>
        <td>
            <form id="t1" action="<%=request.getContextPath()%>/ProductServlet" method="POST">
                <table>
                    <tr>
                        <td>Nhập tên sản phẩm muốn tìm :
                            <input type="text" name="productName">
                        </td>
                        <td>
                            <input type="submit" value="Search" name="action">
                        </td>
                    </tr>
                </table>
            </form>
            <form id="t2" action="<%=request.getContextPath()%>/ProductServlet" method="POST">
                <table>
                    <tr>Nhập giá sản phẩm muốn tìm:
                        <td> Từ
                            <input type="text" name="num1">
                        </td>
                        <td> Đến
                            <input type="text" name="num2">
                        </td>

                        <td>
                            <input type="submit" value="SearchPrice" name="action">
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>

</body>
</html>
