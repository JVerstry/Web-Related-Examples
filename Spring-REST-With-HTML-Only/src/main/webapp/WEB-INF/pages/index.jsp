<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;" charset=UTF-8">
  <title>Welcome To REST With HTML Only !!!</title>
</head>
<body>
    <h1>REST With HTML Only !!!</h1>
    <form action="<c:url value='/MyData/123466/'/>"
		  method="post" >
        <input type="hidden" name="_method" value="GET">	  
        <input type="submit" value="GET">
    </form>  
    <form action="<c:url value='/MyData'/>"
		  method="post" >
		<input type="hidden" name="time" value="555555">
		<input type="hidden" name="message" value="User PUT call !!!">
        <input type="hidden" name="_method" value="PUT">	  
        <input type="submit" value="PUT">
    </form>  
    <form action="<c:url value='/MyData'/>"
		  method="post" >
        <input type="submit" value="POST">
    </form>  
    <form action="<c:url value='/MyData/654321'/>"
		  method="post" >
        <input type="hidden" name="_method" value="DELETE">	  
        <input type="submit" value="DELETE">
    </form>  
</body>
</html>
