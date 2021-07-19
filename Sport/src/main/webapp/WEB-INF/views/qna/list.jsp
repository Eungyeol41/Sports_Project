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
	
	div#search {
		margin: 10px 0px 10px 0px;
		display: flex;
	}
	
	select#search {
		margin-left: 10%;
		padding: 0px 10px 0px 10px;
		margin-right: 20px;
		border: 1px solid black;
		text-align: center;
	}
	
	tr:hover:not(.first) {
		background-color: #dedcee;
		cursor: pointer;
		color: darkblue;
	}
	
	button#btn_search {
		margin: 0px 0px 0px 20px;
	}
	
	button#write {
		margin-left: auto;
		margin-right: 10%;
	}
	
	table.list {
		table-layout: fixed;
	}
	
	table.list th:first-child {
		width: 5%;
	}
	
	table.list td, th {
		text-overflow: ellipsis;
		white-space: nowrap;
		overflow: hidden;
	}

</style>
</head>

<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	<h1>1 대 1 문의 게시판</h1>

	<div class="se_Type">
		<div id="sc"></div>
	</div>
	<div id="search">
		<select name="search" id="search">
			<option value="title" selected="selected">제목</option>
			<option value="text">내용</option>
			<option value="id">ID</option>
		</select>
		<input id="in_search" name="keyword" type="search" placeholder="검색하세요">
		<button id="btn_search" type="button">검색</button>
		<button id="write" type="button">글쓰기</button>
	</div>
	<div class="table_list">
		<table class="list">
			<tr class="first">
				<th>번호</th>
				<th>제목</th>
				<th>시설이름</th>
				<th>아이디</th>
				<th class="text">문의내용</th>
				<th>작성시간</th>
				<th>조회수</th>
			</tr>
			<c:choose>
				<c:when test="${empty RESULT}">
					<%-- 		<tr>
					<td colspan="6">데이터가 없음</td>
				</tr> --%>
					<c:forEach items="${QNA}" var="qna" varStatus="index">
						<tr id="list_sec" data-seq="${qna.qna_seq}">
							<th>${index.count}</th>
							<th>${qna.qna_title}</th>
							<th>${qna.qna_name}</th>
							<th>${qna.qna_id}</th>
							<th style="width: 20%" class="text">${qna.qna_text}</th>
							<th>${qna.qna_date}</th>
							<th>${qna.qna_count}</th>
						</tr>
					</c:forEach>
				</c:when>
				<c:when test="${not empty RESULT}">
					<c:forEach items="${RESULT}" var="RE" varStatus="index">
						<tr data-seq="${RE.qna_seq}">
							<th>${index.count}</th>
							<th>${RE.qna_title}</th>
							<th>${RE.qna_name}</th>
							<th>${RE.qna_id}</th>
							<th class="text">${RE.qna_text}</th>
							<th>${qna.qna_date}</th>
							<th>${qna.qna_count}</th>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>

				</c:otherwise>
			</c:choose>
		</table>
	</div>
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
	location.href="${rootPath}/qna/write"
})

document.querySelector("button#btn_search").addEventListener("click", (e) => {
	
	let search = document.querySelector("select#search").value
	let keyword = document.querySelector("input#in_search").value
	
	if(search == "title") {
		
		alert(search + "title")
		location.href="${rootPath}/qna/search/title?keyword=" +keyword;
	}
	if(search == "text") {
		
		alert(search + "text")
		location.href="${rootPath}/qna/search/text?keyword=" +keyword;
	}
	if(search == "id") {
		
		alert(search + "id")
		location.href="${rootPath}/qna/search/user?keyword=" +keyword;
	}	
})
	
</script>
</html>