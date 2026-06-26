<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <% if((String)session.getAttribute("msgError")!=null){%>
            <div style="color: red">
                ${sessionScope.msgError}
            </div>
        <%}%>
        <form method="post" action="${pageContext.request.contextPath}/users/login">
            Email <input type="text" name="txtEmail"/><br/>
            Password <input type="password" name="txtPass"/><br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
