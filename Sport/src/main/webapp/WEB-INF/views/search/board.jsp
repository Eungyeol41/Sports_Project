<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>목록 게시판</title>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/ce0a08be66.js"
	crossorigin="anonymous"></script>
<link href="../css/menu_nav.css" rel="stylesheet" />
<link href="../css/layout_css.css" rel="stylesheet" />
<style>
@import
	url("https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap")
	;
</style>
<style>
tr:hover:not(.first) {
	background-color: #dedcee;
	cursor: pointer;
	color: darkblue;
}
/* h1 {
        margin: 30px auto;
        text-align: center;
      } */
* {
	box-sizing: border-box;
}

body {
	background-color: white;
	font-family: "Noto Sans KR", sans-serif;
	font-family: "Roboto Condensed", sans-serif;
}
</style>
<script>
      document.addEventListener("DOMContentLoaded", () => {
        document.querySelector("table").addEventListener("click", () => {
          alert("시설 상세 페이지로 이동!");
          location.href = "search_detail.html";
        });
      });
    </script>
</head>

<body>
<%@ include file="/WEB-INF/views/include/header.jspf"%>
	<h1>검색 결과</h1>
	<table class="list">
		<tr class="list first">
			<th>번호</th>
			<th>시설 이름</th>
			<th>전화번호</th>
			<th>종목</th>
			<th>위치</th>
		</tr>
	</table>
</body>