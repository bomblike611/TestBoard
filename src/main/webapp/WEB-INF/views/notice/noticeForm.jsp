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
		location.href="./communityList.do";
	});
});
</script>
</head>
<body>
<c:import url="../main/miniMenu.jsp" />
	<section>
		<div id="writeForm">
			<div id="listHeader">
				<h1>공지사항</h1>
			</div>
			<div id="formArea">
			<form id="form" action="communityWrite.do" method="post">
				<p>
					<span class="titles">제목</span> <input type="text"
						placeholder="게시글 제목을 작성해 주세요." name="boardTitle">
				</p>
				<div id="textarea">
					<textarea name="boardContents"></textarea>
				</div>
				<br><ul id="buttons">
			<li id="formSubmit">등록</li>
			<li id="backList">취소</li>
			</ul>
			</form></div>
			
		</div>
	</section>
</body>
</html>