<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<!-- 기본 JS, CSS 파일 -->
	<tiles:insertAttribute name="defaultResources"/>
</head>
<body>
	<div class="layer">
		<tiles:insertAttribute name="header"/>
		<tiles:insertAttribute name="nav"/>
		<tiles:insertAttribute name="body"/>
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>