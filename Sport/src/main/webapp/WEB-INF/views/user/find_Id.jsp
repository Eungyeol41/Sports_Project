<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 찾기</title>
<style>
	form {
		width: 350px;
		height: 350px;
		text-align: center;
		margin: 50px auto;
		animation-name: aniTopDown;
		animation-duration: 0.8s;
	}
	
	form input {
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
	
	form input:focus {
		outline: none;
	}
	
	form label.findId {
		display: inline-block;
	    width: 20%;
	    margin-right: 10px;
	}
	
	form button {
		outline: none;
		display: block;
		background: none;
		/* padding: 14px 10px; */
		/* text-align: center; */
		cursor: pointer;
	}
	
	form button#btn_login {
		padding: 10px 100px 10px 100px;
		margin: 20px auto;
		background-color: #dedcee;
		font-weight: bold;
		border: none;
	}
	
	form div.btn {
		display: flex;
		justify-content: space-around;
	}
	
	form button {
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
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	
	<form method="POST">
		<div class="findId">
			<div>
				<label class="findId">이름</label>
				<input type="text" id="user_name" name="user_name">
			</div>

			<div>
				<label class="findId">전화번호</label>
				<input type="tel" id="user_tel" name="user_tel">
			</div>

			<div>
				<button type="submit">확인</button>
			</div>
		</div>

		<c:if test="${USERVO eq 'NONE'}">
			<label>회원님의 정보가 일치하지 않습니다.</label>
		</c:if>

		<c:if test="${USERVO eq 'CHECK'}">
			<label>찾으시는 ID는 ${ID}입니다</label>
			<div>
				<button type="button" id="close">OK</button>
				<button type="button" id="btn_findPw">비밀번호 찾기</button>
			</div>
		</c:if>
	</form>
</body>

<script>
	document.querySelector("button#close").addEventListener("click", ()=> {
		location.href="${rootPath}/user/login"
	})

	document.querySelector("button#btn_findPw").addEventListener("click", ()=> {
		location.href="${rootPath}/user/findPw"
	})
</script>

</html>