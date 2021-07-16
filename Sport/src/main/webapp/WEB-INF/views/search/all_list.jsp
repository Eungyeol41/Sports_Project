<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table class="list">
		<tr class="list first">
			<th>번호</th>
			<th>시설 이름</th>
			<th>전화번호</th>
			<th>종목</th>
			<th>위치</th>
			<th>이용료</th>
		</tr>
		<c:choose>
			<c:when test="${empty RESULT}">
				<c:forEach items="${ALLIST}" var="AL" varStatus="index">
					<tr class="list_sec" data-seq="${AL.al_seq}">
						<th>${AL.al_seq}</th>
						<th>${AL.al_name}</th>
						<th>${AL.al_tel}</th>
						<th>${AL.al_sport}</th>
						<th>${AL.al_addr}</th>
						<th>${AL.al_free}</th>
					</tr>
				</c:forEach>
			</c:when>

			<c:when test="${not empty RESULT}">
				<c:forEach items="${RESULT}" var="RE" varStatus="index">
					<tr class="list_sec" data-seq="${RE.al_seq}">
						<th>${RE.al_seq}</th>
						<th>${RE.al_name}</th>
						<th>${RE.al_tel}</th>
						<th>${RE.al_sport}</th>
						<th>${RE.al_addr}</th>
						<th>${RE.al_free}</th>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	
	<%@ include file="/WEB-INF/views/include/page.jspf" %>
</body>
</html>