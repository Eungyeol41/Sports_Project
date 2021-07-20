<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link href="${rootPath}/static/css/layout.css?ver=2021-07-19-001" rel="stylesheet" />
<style>
	section {
		border: 1px solid;
		width: 70%;
		text-align: center;
		margin: 0 auto;
	}
	
	section, div#qnaList {
		margin-top: 3rem;
	}
	
	form#user {
		width: 80%;
		height: 50%;
		text-align: center;
		margin: 50px auto;
	}
	
	form#user h2 {
		text-align: center;
		margin: 30px auto;
		padding-top: 20px;
		color: #6a60a9;
	}
	
	form#user label {
		display: inline-block;
		margin: 20px auto;
		/* padding : 0px 10px 0px 10px; */
		width: 8%;
	}
	
	form#user input {
		outline: 0;
		/* display: block; */
		width: 200px;
		margin: 15px auto;
		padding: 14px 10px;
		border: none;
		border-bottom: 2px solid black;
		background: none;
		/* text-align: center; */
	}
	
	form#user input:focus {
		outline: none;
	}
	
	div.list {
		padding: 10px;
	}
	
	label {
		width: 10%;
	    display: inline-block;
	    margin-left: auto;
	}
	
	input {
		border: none;
	}
	
	input:focus {
		outline: none;
	}

	button#update {
	    margin-left: 65%;
    	margin-bottom: 8px;
    	width: 15%;
	}
	
	h3 {
		text-align: center;
    	padding-top: 3rem;
	}
	
	table.list {
		width: 70%;
	}
	
	table.list th {
		text-overflow: ellipsis;
		white-space: nowrap;
		overflow: hidden;
	}
	
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	
	<!-- ID는 고정, 비밀번호 수정 가능, 전화번호 수정 가능 -->
	<h3>회원 정보</h3>
	<section>
		<form id="user" method="POST">
			<div class="list">
				<label>ID </label>
				<input id="user_id" name="user_id" value="${USER.user_id}"/>
			</div>
			<div class="list">
				<label>비밀번호 </label>
				<input id="user_pw" name="user_pw" type="password" value="${USER.user_pw}"/>
			</div>
			<div class="list">
				<label>이름</label>
				<input id="user_name" name="user_name" value="${USER.user_name}"/>
			</div>
			<div class="list">
				<label>전화번호</label>
				<input id="user_tel" name="user_tel" value="${USER.user_tel}"/>
			</div>
			<div class="list">
				<label>E_mail</label>
				<input id="user_email" name="user_email" value="${USER.user_email}"/>
			</div>
			<div>
				<button id="update" type="button">회원 정보 수정</button>
				<button id="expire" type="button">회원 탈퇴</button>
			</div>
		</form>
	</section>
	
	<!-- 내 ID에서 질의한 QNA 확인하기 -->
	<h3>내가 쓴 글 확인하기</h3>
	<div id="qnaList">
		<table class="list">
			<tr class="first">
				<th>글 번호</th>
				<th>제목</th>
				<th>글 내용</th>
			</tr>
			<c:choose>
			<c:when test="${empty QNALIST}">
				<tr>
					<td colspan="3">데이터가 없음</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${QNALIST}" var="qList" varStatus="i">
					<tr data-seq="${qList.qna_seq}">
						<th>${i.count}</th>
						<th>${qList.qna_title}</th>
						<th style="width:70%">${qList.qna_text}</th>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</table>
	</div>
</body>
<script>
	let update = document.querySelector("form#user")
	
	document.querySelector("button#update").addEventListener("click", (e)=> {
		if(confirm("회원정보를 수정하겠습니까?")) {
			update.action = "${rootPath}/user/updateInfo"
			update.submit()
		}
	})
	
	

	let expire = document.querySelector("form#user")
	let u_pw = document.getElementById("u_pw")
	
	document.querySelector("button#expire").addEventListener("click", (e)=> {
		if(confirm("정말로 탈퇴하시겠습니까?")) {
			
			if(u_pw.value == null || u_pw.value == "" || u_pw.value != "${USER.user_pw}"){
				alert("비밀번호를 확인해주세요.")
				u_pw.focus()
				return false
			}else {
				/*
					acform.action = "${rootPath}/member/expire"
					url_now.value = location.pathname;
					acform.submit()
				*/
				expire.action = "${rootPath}/user/expire"
				expire.submit();
			}
		}
	})

	document.querySelector("table.list").addEventListener("click", (e) => {
		let tagName = e.target.tagName;
		
		if(tagName == "TH") {
			let seq = e.target.closest("TR").dataset.seq;
			console.log(seq);
			alert(seq + "조회합니다.");
			
			location.href="${rootPath}/qna/detail?seq=" +seq;	
		}
	
	})
</script>
</html>