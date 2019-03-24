<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/qna/qnaContents.css'/>" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
			var num=${contents.boardNum}
		$("#update").click(function() {
			location.href="./communityUpdate.do?boardNum="+num;
		});
		$("#delete").click(function(){
			location.href="./communityDelete.do?boardNum="+num;			
		});
	});
</script>
</head>
<body>
	<section>
		<div id="Contents">
			<div id="contentsHeader">
				<p>Q&A</p>
				<div class="writeButton" id="update">수정</div>
				<div class="writeButton" id="delete">삭제</div>
			</div>
			<ul id="ulContents">
				<li><div id="comContents">
						<div id="contentTitle">
							<b>제목</b>
							<p>${contents.boardTitle}</p>
						</div>
						<div>
							<span>${contents.boardDate}</span> <span id="count">${contents.boardHits}</span>
							<div id="contentForm">${contents.boardContents}</div>
						</div>
					</div></li>
			</ul>
		</div>
		<div id="nextPage">답변 달기 </div>
	</section>

</body>
</html>


