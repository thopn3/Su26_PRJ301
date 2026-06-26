<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Form</h1>
        <form method="post" action="${pageContext.request.contextPath}/users/register">
            Email: <input type="text" name="txtEmail"/><br/>
            
            Password: <input type="password" name="txtPassword"/><br/>
            
            Fullname: <input type="text" name="txtFullname"/><br/>
            
            Gender: 
            <input type="radio" name="rbGender" value="male" checked="true"/>
            <input type="radio" name="rbGender" value="female"/><br/>
            
            Date of birth <input type="date" name="txtDob"/><br/>
            
            Phone: <input type="text" name="txtPhone"/><br/>
            
            <input type="submit" value="Register"/>
        </form>
    </body>
</html>
