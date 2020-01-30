~<!DOCTYPE html>
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
<title>File Upload</title>
</head>
<body>
	<h1>File Upload</h1>
	<form:form id="uploadForm"
		action="${pageContext.request.contextPath}/fileUploadController/uploadfunctionality/fileUpload"
		enctype="multipart/form-data" modelAttribute="FileUploadVO" method="POST">
		<table>
			<tr>
				<td>Select the file :</td>
				<td align="center"><form:input path="fileData" type="file"/>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align ="center"><input type="submit"  value="Upload"/></td>
			</tr>

		</table>
	</form:form>
</body>
</html>