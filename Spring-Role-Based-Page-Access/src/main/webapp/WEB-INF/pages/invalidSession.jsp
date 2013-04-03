<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/index.css'/>" media="screen">
</head>
<body>
    <h1>Invalid Session</h1>
    Your session may have timed out or you may have tried to create too many
    sessions with multiple logins!
    <br /><br />
    <a href="<c:url value='/'/>">Home</a>
    <c:if test="${noUser}">
        &bull; <a href="<c:url value='/login'/>">Login</a> 
    </c:if>
</body>
</html>
