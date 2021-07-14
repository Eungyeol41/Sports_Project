<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link href="${rootPath}/static/css/layout_css.css?ver=2021-07-10-001"
	rel="stylesheet" />
<style>
	* {
		box-sizing: border-box;
		margin: 0;
		padding: 0%;
	}
	
	div.mypage {
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
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/user/info_update.jsp"%>
	<!-- 내 ID에서 질의한 QNA 확인하기 -->
	<div class="mypage">
		<table>
			<tr>
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
						<tr>
							<th>${i.count}</th>
							<th>${qList.qna_title}</th>
							<th>${qList.qna_text}</th>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>