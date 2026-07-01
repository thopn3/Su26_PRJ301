<%@include file="./template/header.jsp" %>

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

<%@include file="./template/footer.jsp" %>