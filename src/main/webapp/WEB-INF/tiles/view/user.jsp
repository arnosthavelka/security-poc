<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- spring:message code="user.title"/-->

<h3><spring:message code="user.label"/></h3>
<h4><spring:message code="app.name"/></h4>
 
<strong><spring:message code="user.name"/></strong>: ${userDetail.username}<br />
<c:catch var="exception">
	<c:if test="${not empty userDetail.dn}">
	   <strong><spring:message code="user.dn"/></strong>: ${userDetail.dn}<br />
	</c:if>
	<c:if test="${not empty userDetail.authorities}">
		<strong><spring:message code="user.roles"/></strong>:
		<ul>
			<c:forEach var="role" items="${userDetail.authorities}">
				<li>${role}</li>
			</c:forEach>
		</ul>
	</c:if>
</c:catch>