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
  <script src="https://kit.fontawesome.com/ce0a08be66.js" crossorigin="anonymous"></script>
  <title>시설 상세 정보</title>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet"/>
    <script src="https://kit.fontawesome.com/ce0a08be66.js" crossorigin="anonymous"></script>
    <style>
      @import url("https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&display=swap");
    </style>
  <style>
    * {
      margin: 0;
      padding: 0;
      border: 0;
    }

    @font-face {
      font-family: 'InfinitySans-RegularA1';
      src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/InfinitySans-RegularA1.woff') format('woff');
      font-weight: normal;
      font-style: normal;

    }
    div#map {
      margin: 0;
      text-align: right;
    }

    a {
      text-decoration: none;
      color: black;
    }

    button {
      border: none;
      width: 10%;
      height: 40px;
      margin-right: 25%;
      font-weight: bold;
      right: 20%;
      font-style: normal;
      color: black;
    }
    

    button:hover {
      background-color: #dedcee;
    }


    table.main {
      font-family: 'InfinitySans-RegularA1';
      margin: auto;
      padding: 40px 0 40px 80px;
      width: 50%;
      white-space: nowrap;

    }

    table.main th {
      /* border-top :hidden; */
      border-right: 1px solid black;
      background-color: #dedcee;
    }

    table.main td {
      padding-left: 20px 0 20px 20ps;
    }

    h2 {
      text-align: center;
      padding: 25px 0 25px 0;
      font-family: 'InfinitySans-RegularA1';
    }

    table.t1 tr td {
      font-family: 'InfinitySans-RegularA1';
      margin: auto;
      border: 1px solid black;
      /* border-collapse: collapse; */
      text-align: center;
      /* padding: 5px; */
      margin: 5px;
      padding: 20px 0 20px 20px;
    }

    table.t2 tr td {
      font-family: 'InfinitySans-RegularA1';
      margin: auto;
      border: 1px solid black;
      /* border-collapse: collapse; */
      text-align: center;
      padding: 5px;
      margin: 5px;
    }

    td.sec {
      padding: 20px 0 20px 20px;
    }
  </style>
  <script>
    document.querySelector("button.btn_search").addEventListener("click", () => {
      alert("시설 위치 지도로 이동합니다.");
    })
  </script>
</head>

<body>
<%@ include file="/WEB-INF/views/include/header.jspf"%>
  <div>
    <h2>첨단전천후배드민턴장</h2>
    <div id="map">
      <button>
        <a href="http://map.daum.net/link/to/%EA%B4%91%EC%A3%BC+%EA%B4%91%EC%82%B0%EA%B5%AC+%EC%82%B0%EC%9B%94%EB%8F%99+819-8,35.21325761566636,126.85281730352263"
          type="button" class="btn_search">시설 위치 찾기</a>
      </button>
    </div>
    <c:forEach items="${DTDTO}" var="DT">
    <table class=main>
      <tr>
        <th rowspan="2">이용료</th><td>${DT.v_free}</td>
        <td class="sec">
          <div style="font-weight: bold;">유료 - 대관료</div><br>
          <table class="t1" style="border-collapse: collapse;">
            <tr>
              <td rowspan="6">
                <div>실내 배드민턴장</div>
              </td>
              <td colspan="2" rowspan="2">
                <div>체육행사</div>
              </td>
              <td>
                <div>주간</div>
              </td>
              <td>
                <div>45,000</div>
              </td>
              <td>
                <div>30,000</div>
              </td>
            </tr>
            <tr>
              <td>
                <div>야간</div>
              </td>
              <td>
                <div>90,000</div>
              </td>
              <td>
                <div>60,000</div>
              </td>

            <tr>
              <td colspan="1" rowspan="4">
                <div>체육 행사 이외</div>
              </td>
              <td rowspan="2">
                <div>영리</div>
              </td>
              <td>
                <div>주간</div>
              </td>
              <td>
                <div>150,000</div>
              </td>
              <td>
                <div>100,000</div>
              </td>
            </tr>
            <tr>
              <td>
                <div>야간</div>
              </td>
              <td>
                <div>225,000</div>
              </td>
              <td>
                <div>150,000</div>
              </td>
            </tr>
            <tr>
              <td rowspan="2">
                <div>비영리</div>
              </td>
              <td>
                <div>주간</div>
              </td>
              <td>
                <div>90,000</div>
              </td>
              <td>
                <div>60,000</div>
              </td>
            </tr>
            <tr>
              <td>
                <div>야간</div>
              </td>
              <td>
                <div>135,000</div>
              </td>
              <td>
                <div>90,000</div>
              </td>
            </tr>
          </table>
        </td>
      </tr>
      <tr>
        <td class="sec">
          <div style="font-weight: bold;" >이용료</div><br>
          <table class="t2" style="border-collapse: collapse;">
            <tr>
              <td rowspan="6" >
                <div>실내 배드민턴장</div>
              </td>
              <td rowspan="3">
                <div>개인</div>
              </td>
              <td>
                <div>일반</div>
              </td>
              <td>
                <div>1회 2시간</div>
              </td>
              <td>
                <div>2,000</div>
              </td>
            </tr>
            <tr>
              <td>
                <div>군경, 청소년</div>
              </td>
              <td>
                <div>1회 2시간</div>
              </td>
              <td>
                <div>1,300</div>
              </td>
            </tr>
            <tr>
              <td>
                <div>어린이</div>
              </td>
              <td>
                <div>1회 2시간</div>
              </td>
              <td>
                <div>1,000</div>
              </td>
            </tr>
            <tr>
              <td rowspan="3">
                <div>회원</div>
              </td>
              <td>
                <div>일반</div>
              </td>
              <td>
                <div>1회 2시간</div>
              </td>
              <td>
                <div>40,000</div>
              </td>
            </tr>
            <tr>
              <td>
                <div>군경, 청소년</div>
              </td>
              <td>
                <div>1회 2시간</div>
              </td>
              <td>
                <div>30,000</div>
              </td>
            </tr>
            <tr>
              <td>
                <div>어린이</div>
              </td>
              <td>
                <div>1회 2시간</div>
              </td>
              <td>
                <div>20,000</div>
  </div>
  </td>
  </tr>
  </table>
  </td>
  </tr>
  <tr>
    <th>이용가능시간</th>
    <td class="sec">
      <div>※ 준비 및 마무리 시간 포함됨<br>
        ※ 시설 운영 및 기타 사정으로 인해서 변경 가능함.<br>
        주중(월 ~ 금) 09:00 ~ 18:00 <br>
        주말(토, 일) 09:00 ~ 18:00
      </div>
    </td>
  </tr>
  <tr>
    <th>종목 (종류)</th>
    <td class="sec">배드민턴 (실내)</td>
  </tr>
  <tr>
    <th>전화번호</th>
    <td class="sec">062) 960 - 9923</td>
  </tr>
  <tr>
    <th>이용</th>
    <td class="sec">누구나 가능</td>
  </tr>
  <tr>
    <th>위치</th>
    <td class="sec">광주 광산구 산월동 819-8</td>
  </tr>
  <tr>
    <th>문의</th>
    <td class="sec">광주광역시 광산구 시설관리공단 <br>
      062) 960 - 9923
    </td>
  </tr>
  </table>
  </c:forEach>
  <div class="map">


  </div>
  </div>
</body>

</html>