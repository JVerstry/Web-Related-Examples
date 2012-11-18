<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!doctype html>
<html lang="en">
<head>
  <title>Welcome To Spring MVC Internationalization !!!</title>
</head>
<body>
  <h1>Spring MVC Internationalization !!!</h1>
  
  <p>Choose:
      <a href="<c:url value='?lang=en'/>">English</a>
      | <a href="<c:url value='?lang=fr'/>">French</a>
	  | <a href="<c:url value='?lang=de'/>">German</a>
  </p>
  
  <p>Greetings: <spring:message code="greetings" text="missing" /></p>
  <p>Text 2: <spring:message code="text2" text="missing" /></p> 
  
  <p>Current: <c:out value="${pageContext.response.locale}" /></p>
</body>
</html>
