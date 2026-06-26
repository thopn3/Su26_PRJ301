<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="Models.User" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Users</h1>
        
        <a href="${pageContext.request.contextPath}/users/register">Create a new User</a>
        
        <% if((String)session.getAttribute("msgSuccess")!=null){%>
            <div style="color: green">
                ${sessionScope.msgSuccess}
            </div>
        <%}%>
        
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Email</th>
                <th>Fullname</th>
                <th>Gender</th>
                <th>Dob</th>
                <th>Phone</th>
                <th>Role</th>
            </tr>
            <%
                List<User> users = (List<User>) request.getAttribute("list");
                for(User u: users){
            %>
            
            <tr>
                <td><%=u.getId()%></td>
                <td><%=u.getEmail()%></td>
                <td><%=u.getFullname()%></td>
                <td><%=u.getGender()%></td>
                <td></td>
                <td><%=u.getPhone()%></td>
                <td><%=u.getRole()%></td>
            </tr>
            
            <%
                }
            %>
        </table>
    </body>
</html>
