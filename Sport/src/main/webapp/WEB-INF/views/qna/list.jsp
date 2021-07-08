<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<jsp:useBean id="date" class="java.util.Date" />
<c:set var="today" value="${date}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>문의사항 게시판</title>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/ce0a08be66.js"
	crossorigin="anonymous"></script>
<link href="${rootPath}/static/css/layout_css.css?ver=2021-07-04-005"
	rel="stylesheet" />
<style>
@import
	url("https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap")
	;
</style>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	background-color: white;
	font-family: "Noto Sans KR", sans-serif;
	font-family: "Roboto Condensed", sans-serif;
}

tr:hover:not(.first) {
	background-color: #dedcee;
	cursor: pointer;
	color: darkblue;
}

div.search {
	margin: 10px 40px 20px 40px;
	display: flex;
	/* justify-content: space-evenly; */
}

div.search input {
/* 
	margin-left: 10%;
	flex-shrink: 0; */
	
	padding: 5px;
}

button#search {
	/* width: 50px; */
	/* flex-grow: 1; */
	
}

button#write {
	/* justify-items: left; */
	margin-left: auto;
}

table th {
	
}

table th#text {
	max-width: 0%;
	text-overflow: ellipsis;
}
</style>
</head>

<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	<h1>1 대 1 문의 게시판</h1>

	<div class="se_Type">
		<div id="sc">

		</div>
	</div>
	<div id="search">
				<select name="search_option">
				<option value="title" selected="selected">제목</option>
				<option value="text">내용</option>
				<option value="id">ID</option>
			</select>
			<input name="keyword" type="search" value="${keyword}"
				placeholder="검색하세요">
		<button id="btn_search" type="submit">검색</button>
		<button id="write" type="button">글쓰기</button>
	</div>
	<table class="list">
		<tr class="first">
			<th>번호</th>
			<th>제목</th>
			<th>시설이름</th>
			<th>e_mail</th>
			<th>아이디</th>
			<th class="text">문의내용</th>
		</tr>
		<c:choose>
			<c:when test="${empty QNA}">
				<tr>
					<td colspan="6">데이터가 없음</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${QNA}" var="qna" varStatus="index">
					<tr data-seq="${qna.qna_seq}">
						<th>${index.count}</th>
						<th>${qna.qna_title}</th>
						<th>${qna.qna_name}</th>
						<th>${qna.qna_email}</th>
						<th>${qna.qna_id}</th>
						<th class="text">${qna.qna_text}</th>
						<%-- 
						<th><fmt:formatDate value="${date}" type="both" dateStyle="long" timeStyle="long"/></th>
						--%>

					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
<script>
document.querySelector("table.list").addEventListener("click", (e) => {
	let tagName = e.target.tagName;
	
	if(tagName == "TH") {
		let seq = e.target.closest("TR").dataset.seq;
		console.log(seq);
		alert(seq + "조회합니다.");
		location.href="${rootPath}/qna/detail?seq=" +seq;	
	}

})
document.querySelector("button#write").addEventListener("click", (e) => {
	alert("글쓰기 화면으로 이동합니다.");
	location.href="${rootPath}/qna/write"
})

document.querySelector("div.se_Type").addEventListener("click", (e) => {
	
})
</script>
</html>