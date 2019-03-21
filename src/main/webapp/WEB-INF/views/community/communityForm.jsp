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
});
</script>
</head>
<body>
	<section>
		<div id="writeForm">
			<div id="listHeader">
				<h1>자유게시판</h1>
			</div>
			<div id="formArea">
			<form id="form" action="communityWrite.do" method="post">
				<p>
					<span class="titles">제목</span> <input type="text"
						placeholder="게시글 제목을 작성해 주세요." name="boardTitle">
				</p>
				<p>
					<span class="titles">PW</span> <input type="text"
						placeholder="비밀번호를 입력해주세요." name="boardPw">
				</p>
				<div id="textarea">
					<textarea name="boardContents"></textarea>
				</div>
				<ul id="fileContents">
					<li class="fileText">파일 첨부</li>
					<li id="filesName">
						<div></div>
					</li>
					<li class="fileText"><div id="fileButton">파일 첨부하기</div></li>
				</ul>
			</form></div>
			<ul id="buttons">
			<li id="formSubmit">등록</li>
			<li id="backList">취소</li>
			</ul>
		</div>
	</section>
</body>
</html>