<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<a href="<c:url value="?lang=vi"/>">
		<spring:message code="app.lang.vi" />
	</a> |
	<a href="<c:url value="?lang=en"/>">
		<spring:message code="app.lang.en" />
	</a>
	
	<h1>
		<spring:message code="app.welcome" /> !
	</h1>

	<P>
		<spring:message code="app.time" /> ${serverTime}.
	</P>
</body>
</html>
