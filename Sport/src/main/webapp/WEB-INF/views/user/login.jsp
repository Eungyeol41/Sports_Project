<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
				<input type="text" name="user_id" id="username" maxlength="15"
					placeholder="사용자 ID" required="required" />
			</div>
			<div>
				<input type="password" name="user_pw" id="password"
					placeholder="비밀번호" required="required" />
			</div>
			<div>
				<input type="checkbox">ID 저장 <input type="checkbox">자동
				로그인
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
	
	document.querySelector("button#btn_login").addEventListener("click", ()=> {
		let user_id = document.querySelector("input#username")
		let user_pw = document.querySelector("input#password")
		
		if(user_id.length < 3 || user_id.length > 15) {
			alert("ID는 3 ~ 15글자 내에서 입력해야합니다.");
			user_id.focus();
			return false;
		}
		
		if(user_pw < 3 || user_pw > 20) {
			alert("비밀번호는 3 ~ 20글자 내에서 입력해야합니다.")
			user_pw.focus();
			return false;
		}
			
		document.querySelector("form#login_form").submit();
	})
	
	document.querySelector("button#btn_join").addEventListener("click", ()=> {
		location.href = "${rootPath}/user/join"
	})
	
	/*
		document.querySelector("span.close-button").addEventListener("click", ()=> {
			modal.classList.toggle("show-modal");
		})
		
		window.addEventListener("click", (e)=> {
			if(e.target === modal) {
				modal.classList.toggle("show-modal");
			}
		}) 
	*/
	
</script>
</html>