<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <title>Retrieve URL Get Parameters !!!</title>
</head>
<body>
  <h1>Welcome To Retrieve URL Get Parameters !!!</h1>
  <form action="<c:url value='/retrieveUrlGetParameters'/>" method="get"
         accept-charset="ISO-8859-1">
  First name: <input type="text" name="firstName"><br /><br />
  Last name: <input type="text" name="lastName"><br /><br />
  <input type="submit" value="Submit">
  </form>
</body>
</html>