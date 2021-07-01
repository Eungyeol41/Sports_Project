<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="${rootPath}/static/css/login.css?ver=2021-07-01-001" rel="stylesheet" />
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jspf" %>
	<form id="login_form">
		<h2>Login</h2>
		<div>
			<input type="text" name="username" id="username"
				placeholder="사용자 ID" />
		</div>
		<div>
			<input type="password" name="password" id="password"
				placeholder="비밀번호" />
		</div>
		<button type="button" id="btn_login">Login</button>
		<div class="btn">
			<button type="button" id="btn_id_pw">ID/PW 찾기</button>
			<button id="btn_join" type="button">회원가입</button>
		</div>
	</form>
</body>
<script>
	let modal = document.querySelector("form.modal");
	document.querySelector("button").addEventListener("click", ()=> {
		modal.classList.toggle("show-modal");
	})
</script>
</html>