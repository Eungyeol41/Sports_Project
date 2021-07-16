<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>detail marker 찍기</title>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=kmbrbdmlz9"></script>
</head>
<body>
	<div id="map" style="width:100%;height:400px;"></div>
</body>
<script>
	var mapOptions = {
	    center: new naver.maps.LatLng("${MAP.m_lat}", "${MAP.m_lgt}"),
	    zoom: 10
	};

	var map = new naver.maps.Map('map', mapOptions);
/*
	var map = new naver.maps.Map('map', {
	    center: new naver.maps.LatLng(${GEOS[0].lat},${GEOS[0].lgt}),
	    zoom: 15
	});
	
	var marker = new naver.maps.Marker({
	    position: new naver.maps.LatLng(${GEOS[0].lat},${GEOS[0].lgt}),
	    map: map
	});
*/	
</script>
</html>

