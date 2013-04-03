<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Access Denied</title>
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/index.css'/>" media="screen">
</head>
<body>
    <h1>Access Denied</h1>
    You are not allowed to access this page!
    <br /><br />
    <a href="<c:url value='/'/>">Home</a>
</body>
</html>
