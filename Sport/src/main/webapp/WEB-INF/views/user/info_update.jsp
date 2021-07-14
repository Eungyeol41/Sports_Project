<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style>
	fieldset {
		width: 70%;
		height: 35vh;
		text-align: center;
		margin: 10px auto;
		margin-top: 5%;
	}
	
	div.info {
		margin: 3%;
	}
	
	legend {
		border-spacing: 2px;
		padding: 0 5px;
	}
	
	label {
		padding: 0 5%;
	    width: 20%;
	    display: inline-block;
	}
	
	input {
		border: none;
		text-align: center;
    	width: 20%;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	<!-- ID는 고정, 비밀번호 수정 가능, 전화번호 수정 가능 -->
	<fieldset>
		<legend>내 정보 확인하기</legend>
		<div class="info">
			<label>ID </label>
			<input value="${USER.user_id}" readonly="readonly"></input>
		</div>
		<div class="info">
			<label>이름</label>
			<input value="${USER.user_name}" readonly="readonly"></input>
		</div>
		<div class="info">
			<label>전화번호</label>
			<input value="${USER.user_tel}" readonly="readonly"></input>
		</div>
		<div class="info">
			<label>E_mail</label>
			<input value="${USER.user_email}" readonly="readonly"></input>
		</div>
</fieldset>
</body>
</html>