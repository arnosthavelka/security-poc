<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<meta charset="utf-8">
		<title><spring:message code="user.title"/></title>
	</head> 
	<body>
		<h3><spring:message code="user.label"/></h3>
		<h4><spring:message code="app.name"/></h4>
		 
		<c:url value="/logout" var="logoutUrl" />
		<form id="logout" action="${logoutUrl}" method="post" >
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		    <a href="javascript:document.getElementById('logout').submit()">Logout</a>
		</c:if>
	</body>
</html>