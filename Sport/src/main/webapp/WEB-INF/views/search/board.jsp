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
button {
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

  table {
    width: 80%;
    margin: 0px auto;
    border-top: 1px solid #6a60a9;
    border-collapse: collapse;
  }

  th {
    padding: 15px 10px;
    border-top: 1px solid #6a60a9;
    text-align: center;
  }

  tr.first {
    background-color: #dedcee;
  }

  tr:not(.first) {
    background-color: whitesmoke;
  }


  th:nth-child(1) {
    border-right: 1px dashed lavender;
  }


  h1 {
    padding: 30px;
    text-align: center;
    font-size: 30px;
    font-weight: bold;
  }
</style>


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
			<th>유/무료</th>
		</tr>
		
		<c:forEach items="${RESULT}" var="RE" >
    	<tr data-seq="${RE.v_seq}">
    		<th>${RE.v_seq}</th>
    		<th>${RE.v_name}</th>
    		<th>${RE.v_tel}</th>
    		<th>${RE.v_sport}</th>
    		<th>${RE.v_addr}</th>
    		<th>${RE.v_free}</th>
    	</tr>
    </c:forEach>
  </table>
</body>
<script>
   var rootPath = "${rootPath}"
</script>
<script>
document.querySelector("table.list").addEventListener("click", (e) => {
	let tagName = e.target.tagName;
	
	if(tagName == "TH") {
		let seq = e.target.closest("TR").dataset.seq;
		console.log(seq);
		location.href="${rootPath}/search/detail2?v_seq=" + seq;	
	}

})
   </script>
</head>