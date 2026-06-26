<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.List"%>

<%
    List<String> errors = (List<String>) request.getAttribute("errors");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h3>Login Form</h3>
            <%
                if(errors != null && !errors.isEmpty()){
            %>
            
            <div style="color: red; border: 2px dotted blue">
                <ul>
                    <% for(String err : errors){ %>
                        <li><%=err%></li>
                    <% } %>
                </ul>
            </div>
            
            <%
                }
            %>
            <form action="login" method="post">
                <label>Email (*)</label>
                <input type="text" name="txtEmail"/><br/>
                <label>Password (*)</label>
                <input type="password" name="txtPassword"/><br/>
                <label></label>
                <input type="submit" value="Login"/>
            </form>
        </div>
    </body>
</html>
