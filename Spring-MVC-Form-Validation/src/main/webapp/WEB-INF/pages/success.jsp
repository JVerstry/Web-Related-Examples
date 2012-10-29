<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Form Processed Successfully!</title>
</head>
  <body>
    Form processed for <c:out value="${myUser.name}" /> ! <br />
	<a href="<c:url value='/'/>">Home</a>
  </body>
</html>