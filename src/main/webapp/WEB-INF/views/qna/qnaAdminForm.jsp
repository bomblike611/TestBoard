<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/community/communityForm.css'/>" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$("#formSubmit").click(function(){
		$("#form").submit();
	});
	$("#backList").click(function(){
		var num=${contents.boardNum}
		location.href="./qnaContents.do?boardNum="+num;
	});
});
</script>
</head>
<body>
	<section>
		<div id="writeForm">
			<div id="listHeader">
				<h1>Q&A</h1>
			</div>
			<div id="formArea">
			<form id="form" action="qnaAdminForm.do" method="post">
			<input type="hidden" name="boardRef" value="${contents.boardRef}">
			<input type="hidden" name="boardPw" value="">
			<input type="hidden" name="boardTitle" value=" RE : ${contents.boardTitle}">
				<p>
					 <span class="titles">제목</span> RE : ${contents.boardTitle} 
					
				</p>
		
				<div id="textarea">
					<textarea name="boardContents">${contents.boardContents} &#10; ------------------------------------------------------------------------------------------------------------------------ &#10;</textarea>
				</div>
			</form></div>
			<ul id="buttons">
			<li id="formSubmit">등록</li>
			<li id="backList">취소</li>
			
			</ul>
		</div>
	</section>
</body>
</html>