<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Product List</h1>
        <% if((String)session.getAttribute("msgSuccess")!=null){%>
            <div style="color: green">
                ${sessionScope.msgSuccess}
            </div>
        <%}%>
        <table border="1">
            <tr>
                <th>ProductId</th>
                <th>ProductName</th>
                <th>ProductPrice</th>
                <th>Category</th>
                <th colspan="2">Actions</th>
            </tr>
            <c:forEach var="p" items="${products}">
                <tr>
                    <td>${p.productId}</td>
                    <td>${p.productName}</td>
                    <td>${p.productPrice}</td>
                    <td>${p.categoryName}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/products/edit?id=${p.productId}">Edit</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/products/delete?id=${p.productId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
