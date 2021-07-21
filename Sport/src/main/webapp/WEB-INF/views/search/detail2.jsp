<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<link href="../css/menu_nav.css" rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/ce0a08be66.js"
	crossorigin="anonymous"></script>
<link href="../css/menu_nav.css" rel="stylesheet" />
<style>
	@import url("https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap");
</style>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0%;
}

div.iw_inner {
	padding-left: 25px;
	width: 300px;
}

form {
	width: 80%;
	margin: auto;
}

div {
	margin: 20px auto;
	padding: 10px 0 30px 0;
}

div.table {
	width: 80%;
	height: 100px;
}

div.h2, div.table, div.button {
	display: flex;
	justify-content: center;
}

table, tr, th {
	border-bottom: 1px solid white;
	border-collapse: collapse;
	text-align: center;
	padding: 6px;
}

table, tr {
	width: 60%;
	height: 100px;
}

th.sec1 {
	background-color: #dedcee;
}

input, textarea {
	border: none;
	outline: none;
	width: 100%;
	text-align: center;
}

div#map {
	margin: 0;
	text-align: right;
}

button {
	border: none;
	width: 10%;
	height: 40px;
	margin-right: 25%;
	font-weight: bold;
	right: 20%;
	display: inline-block;
	right: 10%;
}

button a {
	font-weight: bold;
	font-style: normal;
	color: black;
	text-decoration: none;
}

button:hover {
	background-color: #dedcee;
	cursor: pointer;
}
</style>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=kmbrbdmlz9"></script>
<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	<div class="h2">
		<h1>상세페이지</h1>
	</div>
	<div id="map_view" style="width: 80%; height: 500px;"></div>
	<form id="insert" method="POST">
		<div class="table">
			<table>
				<tr>
					<th class="sec1">시설이름</th>
					<th><input name="v_name" id="v_name" value="${DT.v_name}"></th>
				</tr>
				<tr>
					<th class="sec1">전화번호</th>
					<th><input name="v_tel" id="v_tel" value="${DT.v_tel}"
						type="text"></th>
				</tr>
				<tr>
					<th class="sec1">주소</th>
					<th><input name="v_addr" id="v_addr" value="${DT.v_addr}"
						type="text"></th>
				</tr>
				<tr>
					<th class="sec1">종목</th>
					<th><input name="v_sport" id="v_sport" value="${DT.v_sport}"
						type="text"></th>
				</tr>
				<tr>
					<th class="sec1">유/무료</th>
					<th><input name="v_free" id="v_free" value="${DT.v_free}"
						type="text"></th>
				</tr>
				<tr>
					<th class="sec1">이용가능 시간</th>
					<th><input name="v_time" id="v_time" value="${DT.v_time}"
						type="text"></th>
				</tr>
				<tr>
					<th class="sec1">사이트</th>
					<th><input name="v_site" id="v_site" value="${DT.v_site}"
						type="text"></th>
				</tr>
				<tr>
					<th class="sec1">상세이용료</th>
					<th><input name="v_money" id="v_money" value="${DT.v_money}"
						type="text"></th>
				</tr>
			</table>
		</div>
	</form>

</body>
<script>
	
	var map = new naver.maps.Map('map_view', {
	    center: new naver.maps.LatLng(${DT.v_lgt}, ${DT.v_lat}),
	    zoom: 18
	});

	var marker = new naver.maps.Marker({
	    position: new naver.maps.LatLng(${DT.v_lgt}, ${DT.v_lat}),
        map: map
	});
	
	let div = document.getElementById('map_view')
	if(div.textContent == '') {
		div.innerHTML += '<label>다음의 좌표는 API에서 지원하지 않습니다.</label>'
	}
	
	var HOME_PATH = window.HOME_PATH || '.';

	var cityhall = new naver.maps.LatLng(${DT.v_lgt}, ${DT.v_lat}),
	    map = new naver.maps.Map('map_view', {
	        center: cityhall.destinationPoint(180, 500),
	        zoom: 18
	    }),
	    marker = new naver.maps.Marker({
	        map: map,
	        position: cityhall
	    });

	var contentString = [
	        '<div class="iw_inner">',
	        '   <h3>${DT.v_name}</h3>',
	        '   <p>',
	        '       <a href="https://map.kakao.com/link/to/${DT.v_name},${DT.v_lgt},${DT.v_lat}" target="_blank">길찾기 바로가기</a>',
	        '   </p>',
	        '</div>'
	    ].join('');

	var infowindow = new naver.maps.InfoWindow({
	    content: contentString
	});

	naver.maps.Event.addListener(marker, "click", (e) => {
	    if (infowindow.getMap()) {
	        infowindow.close();
	    } else {
	        infowindow.open(map, marker);
	    }
	});

	infowindow.open(map, marker);
	
</script>

</html>