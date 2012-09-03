<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Roundtrip !!!</title>
    </head>
    <body>
		Is created item null? <c:out value="${IsNull}" /><br />
		Exceptions: <br />
		<c:forEach items="${Exceptions}" var="element"> 
			- ${element.message}<br />
		</c:forEach>

		Created MilliTimeItem's ID: <c:out value="${RoundTrip.ID}" /><br />
		Created MilliTimeItem's value: <c:out value="${RoundTrip.milliTime}" /><br /><br />
		<a href="<c:url value='/'/>" />Home</a>
    </body>
</html>
