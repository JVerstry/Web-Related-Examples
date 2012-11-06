<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;" charset=UTF-8">
  <title>Welcome To Exception I !!!</title>
</head>
<body>
    <h1>Welcome To Exception I !!!</h1>
	Exception special message:<br/><br/>
	${exception.specialMsg}<br /><br/>
    <a href="<c:url value='/'/>">Home</a>
</body>
</html>
