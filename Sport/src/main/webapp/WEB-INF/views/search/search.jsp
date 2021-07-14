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
<title>검색하기</title>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/ce0a08be66.js"
	crossorigin="anonymous"></script>
<link href="/webapp/static/css/menu_nav.css" rel="stylesheet" />
<link href="../css/layout_css.css" rel="stylesheet" />
<style>
@import
	url("https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap")
	;
</style>

<style>
* {
	margin: 0;
	padding: 0;
	border: 0;
	box-sizing: border-box;
	font-size: 100%;
	font: inherit;
	font-family: "Roboto Condensed", sans-serif;
	font-family: "Noto Sans KR", sans-serif;
}

body {
	padding: 0;
	margin: 0;
}

table.search {
	margin-left: auto;
	margin-right: auto;
	width: 70%;
}

table.search, td, th.search {
	border-collapse: separate;
	border-spacing: 1px;
	line-height: 1.5;
	border-top: 1px solid #6a60a9;
	padding: 15px;
}

th.search {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #6a60a9;
	background: #dedcee;
}

td {
	width: 350px;
	padding-right: 40px;
	vertical-align: top;
	border-bottom: 1px solid #6a60a9;
	letter-spacing: 5px;
}

tr.search:nth-child(6) {
	background: white;
}

select.sports {
	letter-spacing: 5px;
	text-align-last: center;
}

table.list {
	margin: 50px auto;
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

tr.list_sec th:hover {
	cursor: pointer;
}

h1 {
	padding: 30px;
	text-align: center;
	font-size: 30px;
	font-weight: bold;
}

select.sports {
	background-color: white;
}

select.sports option {
	
}
</style>
</head>

<script>
	var rootPath = "${rootPath}"
</script>

<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	<h1>광주광역시 체육시설 찾아보기</h1>
	<form id="search_se" method="POST" action="${rootPath}/search">
	<table class="search">
		<!-- <caption>광주광역시 체육s시설 찾아보기</caption> 표 제목 붙이기 -->
		<tr class="search">
			<th class="search">이용료</th>
			<td>
				<input id="ra" type="radio" name="free" value="무료" checked />	무료 
				<input id="ra" type="radio" name="free" value="유료" /> 유료 
				<input id="ra" type="radio" name="free" value="유/무료" /> 유/무료
			</td>
		</tr>
		<tr class="search">
			<th class="search">지역(구)</th>
			<td>
				<input class="ch_dist" id="ch" type="checkbox" name="dist1" value="동구" /> 동구 
				<input class="ch_dist" id="ch" type="checkbox" name="dist2" value="서구" /> 서구 
				<input class="ch_dist" id="ch" type="checkbox" name="dist3" value="남구" /> 남구 
				<input class="ch_dist" id="ch" type="checkbox" name="dist4" value="북구" /> 북구 
				<input class="ch_dist" id="ch" type="checkbox" name="dist5" value="광산구" /> 광산구 
				<input class="ch_distall" id="all" type="checkbox" name="dist_all" value="전체" onclick="selectAll" /> 전체
			</td>
		</tr>
		<tr class="search">
			<th class="search">지역(동)</th>
			<td id="t3">
				<input id="distric_box" name="town" type="text" size="20"
					style="padding: 10px; border: 1px solid #ddd" name="dong" />
			</td>
		</tr>
		<tr class="search">
			<th class="search">시설이름</th>
			<td id="t4">
				<input id="search_box" name="sname" type="text" size="20"
					style="padding: 10px; border: 1px solid #ddd" name="search" />
			</td>
		</tr>
		<tr class="search">
			<!-- 드롭다운 사용하기 -->
			<th class="search">종목</th>
			<td><select id="sports" class="sports" name="sports" size="1"
				style="width: 230px; border: 1px solid #ddd;">
					<option value="1">--- 종목 ---</option>
					<option value="검도">검도</option>
					<option value="게이트볼">게이트볼</option>
					<option value="골프">골프</option>
					<option value="구기체육관">구기체육관</option>
					<option value="국궁">국궁</option>
					<option value="농구">농구</option>
					<option value="배구">배구</option>
					<option value="배드민턴">배드민턴</option>
					<option value="생활체육관">생활체육관</option>
					<option value="소프트볼">소프트볼</option>
					<option value="수영">수영</option>
					<option value="스케이트">스케이트</option>
					<option value="승마">승마</option>
					<option value="야구">야구</option>
					<option value="양궁">양궁</option>
					<option value="육상">육상</option>
					<option value="인공암벽">인공암벽</option>
					<option value="인라인스케이트">인라인스케이트</option>
					<option value="전천후게이트볼">전천후게이트볼</option>
					<option value="정구">정구</option>
					<option value="족구">족구</option>
					<option value="축구">축구</option>
					<option value="테니스">테니스</option>
				</select>
			</td>
		</tr>
		<tr class="search">
			<td colspan="2" class="btn_src" style="text-align: right">
				<button id="btn_search" type="button">검색</button>
			</td>
		</tr>
	</table>
</form>
	<table class="list">
		<tr class="list first"> 
			<th>번호</th>
			<th>시설 이름</th>
			<th>전화번호</th>
			<th>종목</th>
			<th>위치</th>
			<th>이용료</th>
		</tr>
	
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
			
	</table>

</body>
<script>

document.querySelector("table.list").addEventListener("click", (e) => {
	let tagName = e.target.tagName;
	
	if(tagName == "TH") {
		let seq = e.target.closest("TR").dataset.seq;
		console.log(seq);
		location.href="${rootPath}/search/detail2?v_seq=" + seq;
	}
})

 document.querySelector("button#btn_search").addEventListener("click", () => {
	 
	 let 
	 document.querySelector("form#search_se").submit();
	 
     });
     
    function checkSelectAll() {
        const checkbox = document.querySelectorAll("input.dist");
    	const checked = document.querySelectorAll("input.dist:checked");
    	const selectAll = document.querySelector("input.dist_all");

    if (checkbox.length === checked.length) {
        selectAll.checked = true;
        } else {
        selectAll.checked = false;
        }
    }

      document.addEventListener("DOMContentLoaded", () => {

    document
    .querySelector("input.dist_all")
    .addEventListener("change", function (e) {
        e.preventDefault();
    let list = document.querySelectorAll("input.dist");
    for (let i = 0; i < list.length; i++) {
        list[i].checked = this.checked;
            }
          });

    let objs = document.querySelectorAll("input.dist");
    for (let i = 0; i < objs.length; i++) {
        objs[i].addEventListener("click",() => {
                let selectAll = document.querySelector("input.dist_all");
                for (let j = 0; j < objs.length; j++) {
                    if (objs[j].checked === false) {
                        selectAll.checked = false;
                        return;
                    }
                }
                selectAll.checked = true;
            },
            false
        );
        }
      });

</script>

</html>