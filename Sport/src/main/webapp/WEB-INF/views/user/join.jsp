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
                <input name="id" type="text" id="id" placeholder="ID를 입력하세요" required="required">
                <button type="button" id="over">중복확인</button>
            </div>
            <div>
                <label>Password</label>
                <input name="password" type="password" id="password" placeholder="Password를 입력하세요" required="required" />
            </div>
            <div>
                <label>확인</label>
                <input name="password_ch" type="password" id="password_ch" placeholder="Password를 한번 더 입력하세요" required="required" />
            </div>
            <div>
                <label>E_mail</label>
                <input name="email" type="email" id="email" placeholder="E_mail를 입력하세요" required="required" />
            </div>
            <div>
                <label>Tel</label>
                <input name="tel" type="tel" id="tel" placeholder="전화번호를 입력하세요" required="required" />
            </div>
            <button type="button" id="join">등록</button>
    </form>
</body>
<script>
	document.querySelector("button#join").addEventListener("click", ()=> {
		
		let id = document.getElementById("id").value
		let password = document.getElementById("password").value
		let password_ch = document.getElementById("password_ch").value
		
		if(id.length < 3 || id.length > 15) {
			alert("ID는 3 ~ 15글자 내에서 입력해야합니다.");
			id.focus();
			return false;
		}
		
		if(password < 3 || password > 20) {
			alert("비밀번호는 3 ~ 20글자 내에서 입력해야합니다.")
			password.focus();
			return false;
		}
		
		if(password != password_ch) {
			alert("비밀번호가 일치하지 않습니다!!!")
			password_ch.focus();
			return false;
		}
	
		document.querySelector("form#join_form").submit();
		
	})
	
</script>
</html>