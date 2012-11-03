<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Architecture Roundtrip !!!</title>
    </head>
    <body>
		Created MilliTimeItem's ID: <c:out value="${RoundTrip.ID}" /><br />
		Created MilliTimeItem's value: <c:out value="${RoundTrip.milliTime}" /><br /><br />
		<a href="<c:url value='/'/>" />Home</a>
    </body>
</html>
