<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title><s:message code="app.name"/> - Unauthorized</title>
	</head>
	<body>
		<%@include file="../common/header.jsp" %>
		<div>
			<h3><s:message code="error403.label"/></h3>
		</div>
		<%@include file="../common/footer.jsp" %>
	</body>
</html>