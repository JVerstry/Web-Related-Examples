<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Welcome To MVC Customized Login Logout!!!</title>
</head>
  <body>
    <h1>Spring MVC Customized Login Logout !!!</h1>
	Who is currently logged in? <c:out value="${CurrPrincipal}" /> !<br />
	<a href="<c:url value='/spring_security_login'/>">Login</a>&nbsp;
	<a href="<c:url value='/j_spring_security_logout'/>">Logout</a>	
  </body>
</html>
