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
	src="<c:url value='/resources/js/SpringRESTWithAjax.js'/>">
  </script>  
  <title>Welcome To REST With Ajax !!!</title>
</head>
<body>
  <h1>Welcome To REST With Ajax !!!</h1>
  <button type="button" onclick="RestGet()">GET</button>
  <button type="button" onclick="RestPut()">PUT</button>
  <button type="button" onclick="RestPost()">POST</button>
  <button type="button" onclick="RestDelete()">DELETE</button>
</body>
</html>
