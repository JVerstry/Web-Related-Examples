<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;" charset=UTF-8">
  <script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
  </script>
  <script type="text/javascript"
	src="<c:url value='/resources/js/SpringMVCErrorHandling.js'/>">
  </script>
  <title>Spring MVC Error Handling !!!</title>
</head>
<body>
    <h1>Spring MVC Error Handling !!!</h1>
    <a href="<c:url value='/throwCustomizedException1'/>">Exception 1</a>
	<br /><br />
    <a href="<c:url value='/throwCustomizedException2'/>">Exception 2</a>
	<br /><br />
	<button type="button" onclick="ExceptionHandler()">
		Exception Handler
	</button>
</body>
</html>
