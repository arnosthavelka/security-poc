<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title><s:message code="app.name"/> - Login</title>
	</head>
	<body>
		<%@include  file="./common/header.jsp" %>
		<div>
			<h3><s:message code="login.label"/></h3>
			
			<c:if test="${not empty loginMessage}">
				<div>${loginMessage}</div>
			</c:if>
			
			<form name='loginForm' action="<c:url value='/login' />" method='POST'>
				<table>
					<caption><s:message code="login.form.title"/></caption>
					<tr>
						<th scope="row"><s:message code="login.username"/></th>
						<td><input type='text' name='username' value=''></td>
					</tr>
					<tr>
						<th scope="row"><s:message code="login.password"/></th>
						<td><input type='password' name='password' /></td>
					</tr>
					<tr>
						<td><s:message code="login.rememberMe"/></td>
						<td><input id="remember_me" name="remember-me" type="checkbox"/></td>
					</tr>
					<tr>
						<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
		<%@include  file="./common/footer.jsp" %>
	</body>
</html>

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