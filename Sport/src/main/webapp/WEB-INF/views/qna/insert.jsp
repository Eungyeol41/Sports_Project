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
<link href="../css/menu_nav.css" rel="stylesheet" />
<script src="../js/navscript.js"></script>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0%;
}

div {
	margin: 20px auto;
	padding: 10px 0 30px 0;
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
	width: 20%;
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
<script>
        document.addEventListener("DOMContentLoaded", () => {
            document.querySelector("button#insert").addEventListener("click", () => {
                alert("등록합니다.");
                location.href="${rootPath}/qna"; 	
            });
            document.querySelector("button#reset").addEventListener("click", () => {
                alert("내용이 전체 삭제됩니다.");
                location.href="${rootPath}/qna/detail?seq=" +seq;	
            });
            document.querySelector("button#back").addEventListener("click", () => {
                alert("목록으로 이동합니다.");
                location.href="${rootPath}/qna/detail?seq=" +seq;	
            });
        });
    </script>
</head>

<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	<div>
		<div class="h2">
			<h2>문의사항</h2>
		</div>
		<form method="POST">
			<div class="table">

				<table>
					<tr>
						<th class="sec1">제목</th>
						<th><input name="qna_title" id="qna_title" type="text" value="${QNA.qna_title}"></th>
					</tr>
					<tr>
						<th class="sec1">ID</th>
						<th><input name="qna_id" id="qna_id" type="text" value="${QNA.qna_id}"></th>
					</tr>
					<tr>
						<th class="sec1">email</th>
						<th><input name="qna_email" id="qna_email" type="email" value="${QNA.qna_email}"></th>
					</tr>
					<tr>
						<th class="sec1">시설 이름</th>
						<th><input name="qna_name" id="qna_name" type="text" value="${QNA.qna_name}"></th>
					</tr>
					<tr>
						<th class="sec1">문의 내용</th>
						<th><textarea rows="5" name="qna_text" id="qna_text" >${QNA.qna_text}</textarea></th>
					</tr>
				</table>

			</div>
		</form>
		<div class="button">
			<button id="insert" type="submit">등록</button>
			<button id="reset" type="reset">다시 쓰기</button>
			<button id="back" type="button">뒤로 가기</button>
		</div>
	</div>
</body>

</html>