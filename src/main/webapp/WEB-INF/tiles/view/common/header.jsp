<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="${pageContext.request.contextPath}/home"><spring:message code="home.label"/></a> |
		<a href="${pageContext.request.contextPath}/user"><spring:message code="user.label"/></a> | 
		<a href="${pageContext.request.contextPath}/admin"><spring:message code="admin.label"/></a> | 
	    <a href="javascript:document.getElementById('logout').submit()"><spring:message code="logout.label"/></a>

		<c:url value="/logout" var="logoutUrl" />
		<form id="logout" action="${logoutUrl}" method="post" >
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</c:if>
</div>