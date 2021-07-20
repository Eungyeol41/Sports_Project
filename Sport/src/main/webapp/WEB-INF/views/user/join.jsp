<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="${rootPath}/static/css/join.css?ver=2021-07-20-002" rel="stylesheet" />
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	
	<form method="POST" id="join_form">
        <h2>Sign_Up</h2>
            <div>
                <label>ID</label>
                <input name="user_id" type="text" id="user_id" placeholder="ID를 입력하세요" required="required" style="width: 8%;">
                <button type="button" id="over">중복확인</button>
            </div>
            <div>
                <label>Password</label>
                <input name="user_pw" type="password" id="user_pw" placeholder="Password를 입력하세요" required="required" />
            </div>
            <div>
                <label>확인</label>
                <input name="password_ch" type="password" id="password_ch" placeholder="Password를 한번 더 입력하세요" required="required" />
            </div>
            <div>
            	<label>이름</label>
            	<input name="user_name" type="text" id="user_name" placeholder="이름을 입력하세요" required="required" />
            </div>
            <div>
                <label>E_mail</label>
                <input name="user_email" type="email" id="user_email" placeholder="E_mail를 입력하세요" required="required" />
            </div>
            <div>
                <label>Tel</label>
                <input name="user_tel" type="tel" id="user_tel" placeholder="전화번호를 입력하세요" required="required" />
            </div>
            <button type="button" id="join">등록</button>
    </form>
    
</body>

<script>
	let password = document.querySelector("input#user_pw")
	let password_ch = document.querySelector("input#password_ch")
	let name = document.querySelector("input#user_name")
	let email = document.querySelector("input#user_email")
	let tel = document.querySelector("input#user_tel")

	let input_id = document.querySelector("input#user_id")
	
	document.querySelector("button#over").addEventListener("click", ()=> {
		let user_id = input_id.value;
		
		if(user_id === "") {
			alert("먼저 ID 입력")
			input_id.focus();
			return false;
		}
		
		fetch("${rootPath}/user/id_check?user_id=" + user_id)
		.then(res=>res.text())
		.then(result=>{
		
			if(result === "USE_ID") {
				alert("이미 사용중인 아이디")
				input_id.focus()
				return false;
			} else {
				alert("사용가능한 아이디")
				password.focus()
				return false;
			}
		})
	})
	
	document.querySelector("button#join").addEventListener("click", ()=> {
		
		if(input_id.value === "") {
			alert("ID는 꼭 입력해주세요!")
			id.focus();
			return false;
		}
		
		if(input_id.value.length < 3 || input_id.value.length > 15) {
			alert("ID는 3 ~ 15글자 내에서 입력해야합니다.");
			id.focus();
			return false;
		}
		
		if(password.value === "") {
			alert("비밀번호는 꼭 입력해주세요!")
			password.focus();
			return false;
		}
		if(password.value.length < 3 || password.value.length > 20) {
			alert("비밀번호는 3 ~ 20글자 내에서 입력해야합니다.")
			password.focus();
			return false;
		}
		
		if(password.value != password_ch.value) {
			alert("비밀번호가 일치하지 않습니다!!!")
			password_ch.focus();
			return false;
		}
		
		if(name.value === "") {
			alert("이름은 꼭 써주세요!")
			name.focus();
			return false;
		}
	
		if(email.value === "") {
			alert("Email은 꼭 써주세요!")
			email.focus();
			return false;
		}
		
		if(tel.value === "") {
			alert("전화번호는 꼭 입력해주세요!")
			tel.focus();
			return false;
		}

		document.querySelector("form#join_form").submit();
	})
	
</script>
</html>