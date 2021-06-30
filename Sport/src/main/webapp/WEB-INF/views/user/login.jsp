<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
	* {
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}
	form#login_form {
		width: 350px;
		height: 350px;
		text-align: center;
		margin: 50px auto;
		/* background-color: #fffcf0; */
		animation-name: aniTopDown;
		animation-duration: 0.8s;
	}
	
	form#login_form h2 {
		text-align: center;
		margin: 30px auto;
		padding-top: 20px;
		color: #6a60a9;
	}
	
	form#login_form input {
		outline: 0;
		/* display: block; */
		width: 200px;
		margin: 20px auto;
		padding: 14px 10px;
		border: none;
		border-bottom: 2px solid black;
		background: none;
		/* text-align: center; */
		transition: 0.3s;
	}
	
	form#login_form input:focus {
		outline: none;
	}
	
	form#login_form button {
		outline: none;
		display: block;
		background: none;
		/* padding: 14px 10px; */
		/* text-align: center; */
		cursor: pointer;
	}
	
	form#login_form button#btn_login {
		padding: 10px 100px 10px 100px;
		margin: 20px auto;
		background-color: #dedcee;
		font-weight: bold;
		border: none;
	}
	
	form#login_form div.btn {
		display: flex;
		justify-content: space-around;
	}
	
	form#login_form button#btn_id_pw {
		border: none;
	}
	
	form#login_form button#btn_join {
		border: none;
	}
	
	@keyframes aniTopDown {
		from { 
			top:-300px;
			opacity: 0;
		}
		
		to {
			top: 50%;
			opacity: 1;
		}
	}
</style>
</head>
<body>
	<form id="login_form">
		<h2>Login</h2>
		<div>
			<input type="search" name="username" id="username"
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
</html>