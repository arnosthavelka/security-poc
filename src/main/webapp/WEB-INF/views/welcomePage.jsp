<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome to Security-POC</title>
	</head> 
	<body>
		<h3>Welcome page</h3>
		<h4>Security-POC</h4>
		<c:url value="/login" var="messageUrl" />
		<a href="${messageUrl}">Login</a>
	</body>
	
</html>
