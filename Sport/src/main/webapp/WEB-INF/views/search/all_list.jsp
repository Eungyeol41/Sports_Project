<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 리스트</title>
<link href="${rootPath}/static/css/layout.css?ver=2021-07-18-001" rel="stylesheet" />

<style>
	h2 {
		text-align: center;
	    margin-top: 1rem;
	}
	
	table {
	    margin-top: 2rem;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	
	<h2>공공 체육시설 전체 리스트</h2>
	<table id="allList">
		<tr class="first">
			<th>번호</th>
			<th>시설 이름</th>
			<th>전화번호</th>
			<th>종목</th>
			<th>위치</th>
			<th>이용료</th>
		</tr>
		<c:choose>
			<c:when test="${empty PLIST}">
				<tr>
					<th colspan="6">데이터가 없음</th>
				</tr>
			</c:when>

			<c:otherwise>
				<c:forEach items="${PLIST}" var="pList">
					<tr data-seq="${pList.al_seq}">
						<th>${pList.al_seq}</th>
						<th>${pList.al_name}</th>
						<th>${pList.al_tel}</th>
						<th>${pList.al_sport}</th>
						<th>${pList.al_addr}</th>
						<th>${pList.al_free}</th>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>

	<%@ include file="/WEB-INF/views/include/page.jspf"%>
</body>
<script>
	document.querySelector("table#allList").addEventListener("click", (e)=> {
		let tagName = e.target.tagName;
		
		if(tagName == "TH") {
			let seq = e.target.closest("TR").dataset.seq
			location.href = "${rootPath}/search/detail2?seq=" + seq;
		}
		
	})
</script>
</html>