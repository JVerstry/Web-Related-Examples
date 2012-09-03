<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Roundtrip !!!</title>
    </head>
    <body>
		<c:forEach items="${Messages}" var="element"> 
			${element}<br />
		</c:forEach><br />
		<a href="<c:url value='/'/>" />Home</a>
    </body>
</html>
