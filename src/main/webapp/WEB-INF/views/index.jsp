<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h3>Welcome to Security-POC</h3>
		<c:url value="/login" var="messageUrl" />
		<a href="${messageUrl}">Login</a>
	</body>
	
</html>
