<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link href="${rootPath}/static/css/layout.css?ver=2021-07-18-001" rel="stylesheet" />
<style>
	div {
		margin-top: 15px;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/user/info_update.jsp" %>
	<!-- 내 ID에서 질의한 QNA 확인하기 -->
	<div>
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