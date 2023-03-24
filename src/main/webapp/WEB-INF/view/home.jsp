<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title><spring:message code="app.name"/> - Home</title>
	</head>
	<body>
		<%@include file="./common/header.jsp" %>
		<div>
			<h3><spring:message code="home.label"/></h3>
			
			<p>Some content ...</p>
		</div>
		<%@include file="./common/footer.jsp" %>
	</body>
</html>