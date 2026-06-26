<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="Models.Category" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create a new Product</h1>
        <form method="post" action="${pageContext.request.contextPath}/products/add">
            Product name <input type="text" name="txtPName"/> <br/>
            Price <input type="number" name="txtPrice"/> <br/>
            UnitsInStock <input type="number" name="txtInStock"/> <br/>
            Category 
            <select name="ddlCategory">
                <%
                    List<Category> categories = (List<Category>) request.getAttribute("categories");
                    for(Category c: categories){
                %>
                        <option value="<%=c.getId()%>"><%=c.getName()%></option>
                <%
                    }
                %>
            </select><br/>
            <input type="submit" value="Add"/>
        </form>
    </body>
</html>
 