<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome!</h1>
	<div>
		<a
			href="${pageContext.request.contextPath}/fileUploadController/fileupload">Click
			to open File Upload Page</a>
	</div>
	<div>&nbsp;</div>
	<div>
		<a
			href="${pageContext.request.contextPath}/shortestRouteFindController/shortestroute">Click
			to find Shortest Routes of All the Planets from Earth</a>
	</div>
</body>
</html>