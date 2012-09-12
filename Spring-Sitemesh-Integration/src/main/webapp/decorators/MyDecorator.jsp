<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html>
<head>
    <title><decorator:title default="SiteMesh Integration"/></title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <decorator:head/>
</head>
<body>

    <div id="header">
        <h1>Header Added By Sitemesh</h1>
    </div>

    <div id="content">
		<decorator:body/>
    </div>

    <div id="Footer">
        <h2>Some Copyright Added By Sitemesh</h2>
    </div>
	
</body>
</html>


