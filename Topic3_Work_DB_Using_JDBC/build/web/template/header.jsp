<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Models.User" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            li{
                display: inline-block;
                margin-right: 20px;
            }
        </style>
    </head>
    <body>
        <div>
            <a href="${pageContext.request.contextPath}/"">Home</a>
            <%
                if((User)session.getAttribute("admin_info")!=null){
                User admin = (User)session.getAttribute("admin_info");
            %>
            Welcome: <%= admin.getFullname()%>
            <a href="${pageContext.request.contextPath}/users/logout">Logout</a>
            <%}else{%>
            <ul>
                <li><a href="${pageContext.request.contextPath}/users/login"">SignIn</a></li>
                <li><a href="${pageContext.request.contextPath}/users/register"">SignUp</a></li>
            </ul>
            <%}%>
        </div>