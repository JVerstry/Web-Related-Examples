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
	src="<c:url value='/resources/js/FetchingJsonWithAjax.js'/>">
  </script>
  <title>Welcome To Fetching JSON With Ajax !!!</title>
</head>
<body>
    <h1>Fetching JSON With Ajax !!!</h1>
	<div id="theJson"></div>
	<button type="button" onclick="fetch_json()">
		Fetch JSON
	</button> 
</body>
</html>
