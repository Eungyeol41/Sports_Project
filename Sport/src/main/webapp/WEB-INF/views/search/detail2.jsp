<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="../css/menu_nav.css" rel="stylesheet" />
<body>
<%@ include file="/WEB-INF/views/include/header.jspf"%>
<table class="list">
    <tr class="list first">
      <th>번호</th>
      <th>시설 이름</th>
      <th>전화번호</th>
      <th>종목</th>
      <th>위치</th>
      <th>이용료</th>
    </tr>
    
    	<tr>
    		<th>${DT.v_seq}</th>
    	</tr>
  </table>
</body>
</html>