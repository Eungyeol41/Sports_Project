<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link href="${rootPath}/static/css/layout.css?ver=2021-07-19-001" rel="stylesheet" />
<style>
	fieldset {
		width: 70%;
		text-align: center;
		margin: 10px auto;
	}
	
	legend {
		border-spacing: 2px;
	}
	
	div.list {
		padding: 10px;
	}
	
	label {
		width: 10%;
	    display: inline-block;
	    margin-left: auto;
	}
	
	input {
		border: none;
	}
	
	input:focus {
		outline: none;
	}

	div#qnaList {
		margin-top: 2rem;
	}
	
	table.list th {
		text-overflow: ellipsis;
		white-space: nowrap;
		overflow: hidden;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	
	<!-- ID는 고정, 비밀번호 수정 가능, 전화번호 수정 가능 -->
	<fieldset>
		<legend>내 정보 확인하기</legend>
			<div class="list">
				<label>ID </label>
				<input value="${USER.user_id}" readonly="readonly"></input>
			</div>
			<div class="list">
				<label>이름</label>
				<input value="${USER.user_name}" readonly="readonly"></input>
			</div>
			<div class="list">
				<label>전화번호</label>
				<input name="tel" value="${USER.user_tel}" readonly="readonly"></input>
			</div>
			<div class="list">
				<label>E_mail</label>
				<input name="email" value="${USER.user_email}" readonly="readonly"></input>
			</div>
	</fieldset>
	
	<!-- 내 ID에서 질의한 QNA 확인하기 -->
	<div id="qnaList">
		<table class="list">
			<tr class="first">
				<th>글 번호</th>
				<th>제목</th>
				<th>글 내용</th>
			</tr>
			<c:choose>
			<c:when test="${empty QNALIST}">
				<tr>
					<td colspan="3">데이터가 없음</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${QNALIST}" var="qList" varStatus="i">
					<tr data-seq="${qList.qna_seq}">
						<th>${i.count}</th>
						<th>${qList.qna_title}</th>
						<th>${qList.qna_text}</th>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</table>
	</div>
</body>
<script>
	document.querySelector("input").addEventListener("click", (e)=> {
		if(confirm("전화번호를 수정하겠습니까?"))
	})

	document.querySelector("table.list").addEventListener("click", (e) => {
		let tagName = e.target.tagName;
		
		if(tagName == "TH") {
			let seq = e.target.closest("TR").dataset.seq;
			console.log(seq);
			alert(seq + "조회합니다.");
			
			location.href="${rootPath}/qna/detail?seq=" +seq;	
		}
	
	})
</script>
</html>