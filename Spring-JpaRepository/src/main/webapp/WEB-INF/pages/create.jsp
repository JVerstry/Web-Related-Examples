<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Spring Customized User Creation</title>
  <link rel="stylesheet" type="text/css"
        href="<c:url value='/resources/index.css'/>" media="screen">
</head>
<body>
    <h1>Creating User '${username}'</h1>
    <br />
    <c:choose>
        <c:when test="${empty errorMsg}">
            Creation successful
        </c:when>
        <c:otherwise>
            ${errorMsg}
        </c:otherwise>
    </c:choose>
    <br /><br />
    <a href="<c:url value='/'/>">Home</a>
</body>
</html>
