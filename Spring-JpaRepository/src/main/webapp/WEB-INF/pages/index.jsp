<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Spring JpaRepository Example</title>
  <link rel="stylesheet" type="text/css"
        href="<c:url value='/resources/index.css'/>" media="screen">
</head>
<body>
    <h1>Spring JpaRepository Example</h1>
    <br />
    <h2>Some Items</h2>
    <br />
    <table>
        <c:forEach items="${items}" var="item">
            <tr>
                <td>${item.someText}</td>
                <td><a href="<c:url value='/delete/${item.id}'/>">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br />
    <form method="get" action="<c:url value='/create'/>">
        <input type="submit" value="Create">
    </form>    
</body>
</html>
