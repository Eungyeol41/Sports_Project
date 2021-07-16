<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
	<h1>GeoCode를 위한 페이지</h1>

	<form method="POST" action="${rootPath}/map/geocoding">
		<input name="address" placeholder="주소를 입력하세요">
		<button>확인</button>
	</form>
	<form method="POST" action="${rootPath}/map/regeocoding">
		<input name="coords" placeholder="좌표를 입력하세요(위,경)"
			value="${GEOS[0].lat},${GEOS[0].lgt}">
		<button>확인</button>
	</form>
	<div id="map" style="width: 500px; height: 350px;"></div>
</body>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1c2e3e961baaeb48821a76e1d69d87b8"></script>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(35.1366150, 126.8791680), // 지도의 중심좌표
		level : 3
	// 지도의 확대 레벨
	};

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

	// 마커가 표시될 위치입니다 
	var markerPosition = new kakao.maps.LatLng(35.1366150, 126.8791680);

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		position : markerPosition
	});

	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);

	// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
	// marker.setMap(null);
</script>
</html>