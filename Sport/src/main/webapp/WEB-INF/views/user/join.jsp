<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="${rootPath}/static/css/join.css?ver=2021-07-01-001" rel="stylesheet" />
</head>
<body>
	<form class="modal" id="join_form">
        <h2>Sign_Up</h2>
            <div>
                <label>ID</label>
                <input name="id" type="text" id="id" placeholder="ID를 입력하세요">
                <button type="button" id="over">중복확인</button>
            </div>
            <div>
                <label>Password</label>
                <input name="password" type="password" placeholder="Password를 입력하세요" />
            </div>
            <div>
                <label>확인</label>
                <input name="password" type="password" placeholder="Password를 한번 더 입력하세요" />
            </div>
            <div>
                <label>E_mail</label>
                <input name="e_mail" type="email" placeholder="E_mail를 입력하세요" />
            </div>
            <div>
                <label>Tel</label>
                <input name="tel" type="tel" placeholder="전화번호를 입력하세요" />
            </div>
            <button type="button" id="join">등록</button>
    </form>
</body>
</html>