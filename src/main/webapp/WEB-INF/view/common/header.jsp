<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sc" uri="http://www.springframework.org/security/tags" %>

<div>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="${pageContext.request.contextPath}/home"><s:message code="home.label"/></a> |
		<a href="${pageContext.request.contextPath}/user" <sc:authorize access="hasRole('ROLE_DEVELOPERS') or (principal.username == 'aha')">style="color:green"</sc:authorize>><s:message code="user.label"/></a> | 
		<a href="${pageContext.request.contextPath}/admin" <sc:authorize access="!hasRole('ROLE_ADMINS')">style="color:red"</sc:authorize>><s:message code="admin.label"/></a> |
	    <a href="javascript:document.getElementById('logout').submit()"><s:message code="logout.label"/></a>

		<c:url value="/logout" var="logoutUrl" />
		<form id="logout" action="${logoutUrl}" method="post" >
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</c:if>
</div>