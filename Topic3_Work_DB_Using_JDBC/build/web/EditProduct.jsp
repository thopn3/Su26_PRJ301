<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Product</h1>
        <form method="post" action="${pageContext.request.contextPath}/products/edit">
            Product Id 
            <input type="text" name="txtPId" value="${product.id}" disabled="true"/> <br/>
            
            Product name 
            <input type="text" name="txtPName" value="${product.name}"/> <br/>
            
            Price 
            <input type="number" name="txtPrice" value="${product.price}"/> <br/>
            
            UnitsInStock 
            <input type="number" name="txtInStock" value="${product.unitsInStock}"/> <br/>
            
            Category 
            <select name="ddlCategory">
                <c:forEach var="c" items="${categories}">
                    <option value="${c.id}"
                            <c:if test="${c.id == product.categoryId}">selected</c:if>
                    >
                        ${c.name}
                    </option>
                </c:forEach>
            </select><br/>
            <input type="submit" value="Add"/>
        </form>
    </body>
</html>
