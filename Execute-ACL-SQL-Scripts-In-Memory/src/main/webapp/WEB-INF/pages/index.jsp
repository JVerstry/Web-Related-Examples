<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Spring Execute Scripts In-Memory</title>
</head>
<body>
    <h1>Spring Execute Scripts In-Memory</h1>
    List of tables:
    <ul>
    <c:forEach items="${tables}" var="item">
        <li>${item}
    </c:forEach>
    </ul>
</body>
</html>
