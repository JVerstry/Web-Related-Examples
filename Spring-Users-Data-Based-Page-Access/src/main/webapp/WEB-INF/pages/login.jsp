<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/index.css'/>" media="screen">
</head>
<body>
    <h1>Login</h1>
    <br />
    <c:if test="${not empty param.login_error}">
        Invalid user name or password, try again. <br /><br />
    </c:if>
    <form name="login_form" action="<c:url value='j_spring_security_check'/>"
            method="POST">
        <input type='text' id='username' name='j_username' value='' /><br />
        <input type='password' name='j_password' value='' /><br /><br />
        <input type="submit" value="Submit" />
    </form>
    <br /><br />
    <a href="<c:url value='/'/>">Home</a>
</body>
</html>