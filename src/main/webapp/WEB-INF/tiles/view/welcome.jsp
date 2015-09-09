<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h3><spring:message code="welcome.label"/></h3>
<h4><spring:message code="app.name"/></h4>
<c:url value="/login" var="messageUrl" />
<a href="${messageUrl}">Login</a>