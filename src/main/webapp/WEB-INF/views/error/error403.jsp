<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<meta charset="utf-8">
		<title><spring:message code="error.title"/></title>
	</head> 
	<body>
		<h3><spring:message code="error403.label"/></h3>
		<h4><spring:message code="app.name"/></h4>
		 
		 <c:url value="/home" var="url" />
		<a href="${url}">Home page</a>
	</body>
</html>