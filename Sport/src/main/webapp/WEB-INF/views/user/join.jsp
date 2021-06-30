<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form id="join_form">
		<h2>회원가입</h2>
			<div>
				<label>ID</label> <input name="id" type="search" id="id"
					placeholder="ID를 입력하세요">
				<button type="button" id="over">중복확인</button>
				</input>
			</div>
			<div>
				<label>Password</label> <input name="password" type="password"
					placeholder="Password를 입력하세요" />
			</div>
			<div>
				<label>확인</label> <input name="password" type="password"
					placeholder="Password를 한번 더 입력하세요" />
			</div>
			<div>
				<label>E_mail</label> <input name="e_mail" type="email"
					placeholder="E_mail를 입력하세요" />
			</div>
			<div>
				<label>Tel</label> <input name="tel" type="tel"
					placeholder="전화번호를 입력하세요" />
			</div>
			<button type="button" id="join">회원가입 완료</button>
	</form>
</body>
</html>