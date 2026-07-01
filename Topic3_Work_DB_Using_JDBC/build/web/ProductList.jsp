<%@include file="./template/header.jsp" %>
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
<%@include file="./template/footer.jsp" %>