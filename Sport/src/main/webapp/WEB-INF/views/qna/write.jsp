<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>1 : 1 문의하기</title>
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/ce0a08be66.js"
	crossorigin="anonymous"></script>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0%;
}

form {
	width: 80%;
	margin: auto;
}

div {
	margin: 20px auto;
	padding: 10px 0 30px 0;
}

div.table {
	width: 80%;
}

div.h2, div.table, div.button {
	display: flex;
	justify-content: center;
}

table, tr, th {
	border: 1px solid #6a60a9;
	border-collapse: collapse;
	text-align: center;
	padding: 6px;
}

table, tr {
	width: 60%;
}

th.sec1 {
	background-color: #dedcee;
}

input, textarea {
	border: none;
	outline: none;
	width: 100%;
}

button {
	border: none;
	width: 10%;
	height: 40px;
	font-weight: bold;
	margin-left: 12px;
	margin-right: 12px;
}

button:hover {
	background-color: #dedcee;
	cursor: pointer;
}
</style>
<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	<div>
		<div class="h2">
			<h2>문의사항</h2>
		</div>
		<form id="insert" method="POST">
			<div class="table">
				<table>
					<tr>
						<th class="sec1">제목</th>
						<th><input name="qna_title" id="qna_title" type="text"></th>
					</tr>
					<tr>
						<th class="sec1">ID</th>
						<th><input name="qna_id" id="qna_id" type="text" value="${USER.user_id}" readonly></th>
					</tr>
					<tr>
						<th class="sec1">email</th>
						<th><input name="qna_email" id="qna_email" type="email" value="${USER.user_email}" readonly></th>
					</tr>
					<tr>
						<th class="sec1">시설 이름</th>
						<th><input name="qna_name" id="qna_name" type="text"></th>
					</tr>
					<tr>
						<th class="sec1">문의 내용</th>
						<th><textarea rows="5" name="qna_text" id="qna_text"></textarea></th>
					</tr>
				</table>
			</div>
		</form>
		<div class="button">
			<button class="enter" type="button">등록</button>
			<button id="reset" type="reset">다시 쓰기</button>
		</div>
	</div>

</body>
<script>

let doc = document
const qna_submit = () => {

	let qna_id = doc.querySelector("input#qna_id")
	let qna_title = doc.querySelector("input#qna_title")
	let qna_name = doc.querySelector("input#qna_name")
	let qna_text = doc.querySelector("input#qna_text")
	let qna_email = doc.querySelector("input#qna_email")
	
	doc.querySelector("form#insert").submit();
	
}
doc.querySelector("button.enter").addEventListener("click",()=> {
	qna_submit();
})
/*
doc.querySelector("form#insert").addEventListener("click", (e) => {
	let target = e.target
	
	if(target.tagName === "BUTTON") {
		if(target.className.includes("enter")){
			qna_submit();
		}
	}
	
})
*/
	
	
//document.querySelector("button#enter").addEventListener("click", (e) => {
//document.querySelector("form#insert").submit();

//})
</script>
</html>