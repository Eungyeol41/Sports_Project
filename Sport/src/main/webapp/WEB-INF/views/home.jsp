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
<title>Main Page</title>

<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
<script src="https://kit.fontawesome.com/ce0a08be66.js" crossorigin="anonymous"></script>

<link href="${rootPath}/static/css/main_home.css?ver=2021-06-25-001" rel="stylesheet" />
<style>
@import url("https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap") ;
</style>

<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	font-family: "Noto Sans KR", sans-serif;
	font-family: "Roboto Condensed", sans-serif;
}
</style>
</head>

<body>
	<%@ include file="/WEB-INF/views/include/header.jspf" %>
	
	<div id="s_left"></div>
	<div id="s_right"></div>
	<section class="contents">
		<h2>FIRST PROJECT GPC</h2>
		<div class="sq_box"></div>

		<div class="main_box">
			<div id="box1">
				<i class="fas fa-search fa-7x"></i>
				<h1>Search</h1>
			</div>
			<div id="box2">
				<i class="fas fa-map-marked-alt fa-7x"></i>
				<h1>Map</h1>
			</div>
			<div id="box3">
				<i class="fas fa-edit fa-7x"></i>
				<h1>Q&A</h1>
			</div>
		</div>

		<p class="text1">
			우리 주변에 체육시설을 검색과 위치, 지도를 사용해<br /> 빠르고 정확하게 찾을 수 있게 도와드립니다
		</p>

		<footer>CopyRight&copy;GPC2021@gmail.com</footer>
	</section>
</body>
<script>
        // 1번 Box 클릭
        document.querySelector("div#box1").addEventListener("click", () => {
          location.href = "${rootPath}/search";
        });

        // 2번 Box 클릭
        document.querySelector("div#box2").addEventListener("click", () => {
          location.href = "${rootPath}/map";
        });

        // 3번 Box 클릭
        document.querySelector("div#box3").addEventListener("click", () => {
          location.href = "${rootPath}/qna";
        });
    </script>
</html>
