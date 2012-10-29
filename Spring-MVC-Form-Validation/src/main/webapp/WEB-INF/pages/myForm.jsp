<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>My User Form!</title>
</head>
<body>
  <form:form method="post" action="myForm" commandName="myUser">
  <table>
      <tr>
        <td>Name: <font color="red"><form:errors path="name" /></font></td>
      </tr>
      <tr>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td>Age: <font color="red"><form:errors path="age" /></font></td>
      </tr>
      <tr>
        <td><form:input path="age" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Submit" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>