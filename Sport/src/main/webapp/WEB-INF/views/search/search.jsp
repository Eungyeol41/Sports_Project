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
	<table class="search">
		<!-- <caption>광주광역시 체육시설 찾아보기</caption> 표 제목 붙이기 -->
		<tr class="search">
			<th class="search">이용료</th>
			<td><input id="ra" type="radio" name="ra" value="무료" checked />
				무료 <input id="ra" type="radio" name="ra" value="유료" /> 유료 <input
				id="ra" type="radio" name="ra" value="유/무료" /> 유/무료</td>
		</tr>
		<tr class="search">
			<th class="search">지역(구)</th>
			<td><input id="ch" type="checkbox" name="ch" value="동구" /> 동구 <input
				id="ch" type="checkbox" name="ch" value="서구" /> 서구 <input id="ch"
				type="checkbox" name="ch" value="남구" /> 남구 <input id="ch"
				type="checkbox" name="ch" value="북구" /> 북구 <input id="ch"
				type="checkbox" name="ch" value="광산구" /> 광산구 <input id="all"
				type="checkbox" name="ch_all" value="전체" onclick="selectAll" /> 전체
			</td>
		</tr>
		<tr class="search">
			<th class="search">지역(동)</th>
			<td id="t3"><input id="distric_box" type="text" size="20"
				style="padding: 10px; border: 1px solid #ddd" name="dong" /></td>
		</tr>
		<tr class="search">
			<th class="search">시설이름</th>
			<td id="t4"><input id="search_box" type="text" size="20"
				style="padding: 10px; border: 1px solid #ddd" name="search" /></td>
		</tr>
		<tr class="search">
			<!-- 드롭다운 사용하기 -->
			<th class="search">종목</th>
			<td><select id="sports" class="sports" name="input" size="1"
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
			</select></td>
		</tr>
		<tr class="search">
			<td colspan="2" class="btn_src" style="text-align: right">
				<button id="btn_search" type="button">검색</button>
			</td>
		</tr>
	</table>

	<table class="list">
		<tr class="list first">
			<th>번호</th>
			<th>시설 이름</th>
			<th>전화번호</th>
			<th>종목</th>
			<th>위치</th>
			<th>이용료</th>
		</tr>
			<c:forEach items="${DTLIST}" var="DT" varStatus="index">
				<tr class="list_sec" data-seq="${DT.v_seq}">
					<th>${DT.v_seq}</th>
					<th>${DT.v_name}</th>
					<th>${DT.v_tel}</th>
					<th>${DT.v_sport}</th>
					<th>${DT.v_addr}</th>
					<th>${DT.v_free}</th>
				</tr>
			</c:forEach>
			<c:forEach items="${RESULT}" var="RE" varStatus="index">
				<tr>
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
document.querySelector("table.list").addEventListener("click", (e) => {
	let tagName = e.target.tagName;
	
	if(tagName == "TH") {
		let seq = e.target.closest("TR").dataset.seq;
		console.log(seq);
		location.href="${rootPath}/search/detail2?v_seq=" + seq;
	}
})

 document.querySelector("button#btn_search").addEventListener("click", () => {
        alert("검색 결과로 이동!");
    	location.href = "${rootPath}/search/board";
          });
  
    function checkSelectAll() {
        const checkbox = document.querySelectorAll('input[name="ch"]');
    	const checked = document.querySelectorAll('input[name="ch"]:checked');
    	const selectAll = document.querySelector('input[name="ch_a-ll"]');

    if (checkbox.length === checked.length) {
        selectAll.checked = true;
        } else {
        selectAll.checked = false;
        }
    }

      document.addEventListener("DOMContentLoaded", () => {

    document
    .querySelector('input[name="ch_all"]')
    .addEventListener("change", function (e) {
        e.preventDefault();
    let list = document.querySelectorAll('input[name="ch"]');
    for (let i = 0; i < list.length; i++) {
        list[i].checked = this.checked;
            }
          });

    let objs = document.querySelectorAll("input#ch");
    for (let i = 0; i < objs.length; i++) {
        objs[i].addEventListener("click",() => {
                let selectAll = document.querySelector("input#all");
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