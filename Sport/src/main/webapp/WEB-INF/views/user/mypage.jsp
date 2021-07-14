<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link href="${rootPath}/static/css/layout.css?ver=2021-07-15-002" rel="stylesheet" />
<style>
	* {
		box-sizing: border-box;
		margin: 0;
		padding: 0%;
	}

	fieldset {
		width: 70%;
		height: 35vh;
		text-align: center;
		margin: 10px auto;
		margin-top: 5%;
	}
	
	div.info {
		margin: 3%;
	}
	
	legend {
		border-spacing: 2px;
		padding: 0 5px;
	}
	
	label {
		padding: 0 5%;
	    width: 20%;
	    display: inline-block;
	}
	
	input {
		border: none;
		text-align: center;
    	width: 20%;
	}
	
	button {
		width: 7%;
    	height: 30px;
	}

	div.mypage {
		margin: 20px auto;
		padding: 10px 0 30px 0;
	}
	
	div.h2, div.table, div.button {
		display: flex;
		justify-content: center;
	}
	
	table, tr {
		width: 70%;
	}

</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	
	<!-- ID는 고정, 비밀번호 수정 가능, 전화번호 수정 가능 -->
	<fieldset>
		<legend>내 정보 확인하기</legend>
		<div class="info">
			<label>ID </label>
			<input value="${USER.user_id}" readonly="readonly"></input>
		</div>
		<div class="info">
			<label>이름</label>
			<input value="${USER.user_name}" readonly="readonly"></input>
			
		</div>
		<div class="info">
			<label>전화번호</label>
			<input value="${USER.user_tel}" readonly="readonly"></input>
			<button>정보 수정</button>
		</div>
		<div class="info">
			<label>E_mail</label>
			<input value="${USER.user_email}" readonly="readonly"></input>
			<button>정보 수정</button>
		</div>
	</fieldset>
	
	<!-- 내 ID에서 질의한 QNA 확인하기 -->
	<div>
		<table class="mypage">
			<tr class="first">
				<th>글 번호</th>
				<th>제목</th>
				<th>글 내용</th>
				<th>작성 시각</th>
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
							<th>${qList.qna_date}</th>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>

<script>
	document.querySelector("table.mypage").addEventListener("click", (e) => {
		let tagName = e.target.tagName;
		
		if(tagName == "TH") {
			let seq = e.target.closest("TR").dataset.seq;
			alert(seq + "번 문의사항을 조회합니다.");
			location.href="${rootPath}/qna/detail?seq=" +seq;	
		}
	
	})
</script>

</html>