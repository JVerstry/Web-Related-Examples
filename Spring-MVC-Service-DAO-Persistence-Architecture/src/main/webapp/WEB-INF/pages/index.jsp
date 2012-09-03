<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Welcome !!!</title>
</head>
<body>
    <h1>
      Welcome To The Simple Spring JPA Web Application !!!
    </h1>
	The persistence status is: <c:out value="${PersistenceStatus}" /> !<br /><br />
	<a href="<c:url value='/roundtrip'/>">Roundtrip</a>
</body>
</html>
