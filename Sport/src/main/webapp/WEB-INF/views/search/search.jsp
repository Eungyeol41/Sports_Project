<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>검색하기</title>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
  <script src="https://kit.fontawesome.com/ce0a08be66.js" crossorigin="anonymous"></script>
  <link href="/webapp/static/css/menu_nav.css" rel="stylesheet" />
  <link href="../css/layout_css.css" rel="stylesheet" />
  <style>
    @import url("https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap");
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

    table.search,
    td,
    th.search {
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


  h1 {
    padding: 30px;
    text-align: center;
    font-size: 30px;
    font-weight: bold;
  }
  </style>
</head>
<script>
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/search.js?ver=2021-07-05-001"></script>
<body>
<%@ include file="/WEB-INF/views/include/header.jspf" %>
  <h1>광주광역시 체육시설 찾아보기</h1>
  <table class="search">
    <!-- <caption>광주광역시 체육시설 찾아보기</caption> 표 제목 붙이기 -->
    <tr class="search">
      <th class="search">이용료</th>
      <td>
        <input id="ra" type="radio" name="ra" value="무료" checked /> 무료
        <input id="ra" type="radio" name="ra" value="유료" /> 유료
        <input id="ra" type="radio" name="ra" value="유/무료" /> 유/무료
      </td>
    </tr>
    <tr class="search">
      <th class="search">지역(구)</th>
      <td>
        <input id="ch" type="checkbox" name="ch" value="동구" /> 동구
        <input id="ch" type="checkbox" name="ch" value="서구" /> 서구
        <input id="ch" type="checkbox" name="ch" value="남구" /> 남구
        <input id="ch" type="checkbox" name="ch" value="북구" /> 북구
        <input id="ch" type="checkbox" name="ch" value="광산구" /> 광산구
        <input id="all" type="checkbox" name="ch_all" value="전체" onclick="selectAll" />
        전체
      </td>
    </tr>
    <tr class="search">
      <th class="search">지역(동)</th>
      <td id="t3">
        <input type="text" size="20" style="padding: 10px; border: 1px solid #ddd" name="dong" />
      </td>
    </tr>
    <tr class="search">
      <th class="search">검색어</th>
      <td id="t4">
        <input type="text" size="20" style="padding: 10px; border: 1px solid #ddd" name="search" />
      </td>
    </tr>
    <tr class="search">
      <!-- 드롭다운 사용하기 -->
      <th class="search">종목</th>
      <td>
        <select class="sports" name="input" size="1" style="width: 230px; border: 1px solid #ddd">
          <option value="1">--- 종목 ---</option>
          <option value="2">배드민턴</option>
          <option value="3">3</option>
          <option value="4">4</option>
        </select>
      </td>
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
    </tr>
    <tr>
      <th>1</th>
      <th>염주 종합체육관</th>
      <th>062) 604 - 1400</th>
      <th>핸드볼, 농구, 배드민턴, 탁구, 배구</th>
      <th>광주광역시 서구 금화로 278</th>
    </tr>
    <tr>
      <th>2</th>
      <th>수완 인라인롤러경기장</th>
      <th></th>
      <th>인라인스케이트</th>
      <th>광주광역시 광산구 장덕로96번길 15</th>
    </tr>
    <tr>
      <th>3</th>
      <th>광주여대시립유니버시아드체육관</th>
      <th></th>
      <th>배구, 농구, 핸드볼, 탁구, 배드민턴, 리듬체조</th>
      <th>광주광역시 광산구 광주여대길 45</th>
    </tr>
    <tr>
      <th>4</th>
      <th>첨단 인라인스케이트장</th>
      <th></th>
      <th>인라인스케이트</th>
      <th>광주 광산구 쌍암동</th>
    </tr>
    <tr>
      <th>5</th>
      <th>인공암벽장</th>
      <th></th>
      <th>인공 야외 암벽</th>
      <th>광주광역시 서구 상무시민공원 내 위치</th>
    </tr>
  </table>
	
</body>

</html>