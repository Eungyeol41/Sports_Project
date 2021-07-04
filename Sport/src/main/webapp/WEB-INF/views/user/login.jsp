<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="${rootPath}/static/css/login.css?ver=2021-07-01-003"
	rel="stylesheet" />
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	<div class="modal">
		<form class="modal-content" id="login_form">
			<span class="close-button">&times;</span>
			<div class="msg">${MSG}</div>
			<h2>Login</h2>
			<div>
				<input type="text" name="user_id" id="username" maxlength="15" placeholder="사용자 ID" required="required" />
			</div>
			<div>
				<input type="password" name="user_pw" id="password" placeholder="비밀번호" required="required" />
			</div>
			<button type="button" id="btn_login">Login</button>
			<div class="btn">
				<button type="button" id="btn_id_pw">ID/PW 찾기</button>
				<button id="btn_join" type="button">회원가입</button>
			</div>
		</form>
	</div>
</body>
<script>
	
	
	document.querySelector("span.close-button").addEventListener("click", ()=> {
		modal.classList.toggle("show-modal");
	})
	
	window.addEventListener("click", (e)=> {
		if(e.target === modal) {
			modal.classList.toggle("show-modal");
		}
	}) 
	
	
</script>
</html>