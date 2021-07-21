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
<form method="POST" action="${rootPath}/map/allList/update">
	<table>
		<tr>
			<th>코드</th>
			<th>위도</th>
			<th>경도</th>
			<th>주소</th>	
		</tr>
		<c:forEach items="${GEOS}" var="GEOS">
	<tr>
		<th>${GEOS.dt_code}</th>	
		<th>${GEOS.dt_lat}</th>
		<th>${GEOS.dt_lgt}</th>
		<th>${GEOS.dt_road}</th>
	</tr>
	</c:forEach>
	</table>
		<button>일괄 업데이트</button>
	</form>

</body>
</html>