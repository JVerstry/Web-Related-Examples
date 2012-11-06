<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;" charset=UTF-8">
  <title>Default Page For Exceptions !!!</title>
</head>
<body>
    <h1>Default Page For Exceptions !!!</h1>
	Exception message:<br/><br/>
	${exception.message}<br /><br/>
    <a href="<c:url value='/'/>">Home</a>
</body>
</html>
