<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1{
                text-align: center
            }
            div{
                width: 50%;
                margin: 20px auto;
            }
            label{
                width: 90px;
                display: inline-block;
                margin-bottom: 8px;
            }
        </style>
    </head>
    <body>
        <h1>Login Form</h1>
        
        <!-- Kiểm tra sự tồn tại của attribute trong request. Nếu tồn tại thì mới hiển thị -->
        <%
            String msg = (String)request.getAttribute("message");
            if(msg != null){
        %>
            <h2 style="text-align: center"><%= msg %></h2>
        <%
            }
        %>
        <div>
            <form action="login" method="post">
                <label>Username</label>
                <input type="text" name="txtUser"/><br/>

                <label>Password</label>
                <input type="password" name="txtPass"/><br/>

                <label></label>
                <input type="submit" value="Login"/>
            </form>
        </div>
    </body>
</html>
