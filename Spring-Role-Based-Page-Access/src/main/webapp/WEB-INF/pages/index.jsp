<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Spring In-Memory Security</title>
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/index.css'/>" media="screen">
</head>
<body>
    <h1>Spring In-Memory Security - CRUD Users</h1>
    <br />
    <h2>Registered Users</h2>
    <br />
    <table>
        <c:forEach items="${users}" var="item">
            <tr>
                <td>${item.username}</td>
                <td><a href="<c:url value='/delete/${item.id}'/>">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br />
    <h2>Create User</h2>
    <br />
    <form action="<c:url value='/create'/>" method="get"
            accept-charset="ISO-8859-1">
        Name <input type="text" name="name"><br />
        Password <input type="text" name="password"><br /><br />
        <input type="submit" value="Create User">
    </form>
</body>
</html>
