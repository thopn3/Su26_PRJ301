<%@page contentType="text/html" pageEncoding="UTF-8" import="jakarta.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <%
            String user = (String)session.getAttribute("account");
            if(user!=null){
        %>
            <h1>Welcome: <%=user%></h1>
        <%
            }
        %>
    </body>
</html>
