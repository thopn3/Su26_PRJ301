<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.List"%>

<%
    List<String> errors = (List<String>) request.getAttribute("errors");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            label{
                width: 100px;
                display: inline-block;
                margin-bottom: 10px;
            }
            div#wrapper{
                width: 50%;
                margin: 0px auto;
            }
        </style>
    </head>
    <body>
        <div id="wrapper">
            <h3 style="text-align: center">Register Form</h3>
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
            <form method="post" action="register">
                <label>Email (*)</label>
                <input type="text" name="txtEmail"/><br/>
                <label>Password (*)</label>
                <input type="password" name="txtPassword"/><br/>
                <label>Dob (*)</label>
                <input type="date" name="txtDob"/><br/>
                <label>Gender</label>
                <input type="radio" name="rbGender" value="Male" checked/> Male
                <input type="radio" name="rbGender" value="Female"/> Female
                <input type="radio" name="rbGender" value="Other"/> Other<br/>
                <label>City</label>
                <select name="cbCity">
                    <option value="HaNoi">Hà Nội</option>
                    <option value="TPHCM">TP Hồ Chí Minh</option>
                    <option value="DaNang">Đà Nẵng</option>
                </select><br/>
                <label>Favorites</label>
                <input type="checkbox" name="chkFav" value="football"/> Football
                <input type="checkbox" name="chkFav" value="tenis"/> Tenis
                <input type="checkbox" name="chkFav" value="pickleBall"/> PickleBall<br/>
                
                <label></label>
                <input type="submit" value="Register"/>
            </form>
        </div>
    </body>
</html>
