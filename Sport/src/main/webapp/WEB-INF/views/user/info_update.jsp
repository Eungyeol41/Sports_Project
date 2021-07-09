<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<!-- ID는 고정, 비밀번호 수정 가능, 전화번호 수정 가능 -->
<div>
	<ul>
		<li>ID </li>
		<li>${USER.user_id}</li>
	</ul>
	<ul>
		<li>이름</li>
		<li>${USER.user_name}</li>
	</ul>
	<ul>
		<li>전화번호</li>
		<li>${USER.user_tel}</li>
	</ul>
	<ul>
		<li>주소</li>
		<li>${USER.user_addr}</li>
	</ul>
</div>

</body>
</html>