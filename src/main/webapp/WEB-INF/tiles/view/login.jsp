<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h3><spring:message code="login.label"/></h3>
<h4><spring:message code="app.name"/></h4>

<c:if test="${not empty loginMessage}">
	<div>${loginMessage}</div>
</c:if>

<form name='loginForm' action="<c:url value='/login' />" method='POST'>
	<table>
		<tr>
			<td><spring:message code="login.username"/></td>
			<td><input type='text' name='username' value=''></td>
		</tr>
		<tr>
			<td><spring:message code="login.password"/></td>
			<td><input type='password' name='password' /></td>
		</tr>
		<tr>
			<td><spring:message code="login.rememberMe"/></td>
			<td><input id="remember_me" name="remember-me" type="checkbox"/></td>
		</tr>
		<tr>
			<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
		</tr>
	</table>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<script type="text/javascript">
addEvent(window, 'load', function(){ init() });

function addEvent(element, eventName, fn) {
    if (element.addEventListener)
        element.addEventListener(eventName, fn, false);
    else if (element.attachEvent)
        element.attachEvent('on' + eventName, fn);
}

function init() {
	document.loginForm.username.focus();
};
</script>