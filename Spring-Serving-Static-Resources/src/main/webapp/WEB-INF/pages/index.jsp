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
	src="<c:url value='/resources/js/SomeJavascript.js'/>">
  </script>
  <title>Welcome To Spring Serving Static Resources !!!</title>
</head>
<body>
    <h1>Spring - Serving Static Resources !!!</h1>
	<img border="0"
	  src="<c:url value='/resources/img/MyArt.png'/>" alt="My Art" />
</body>
</html>
