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
<title>천명시스템</title>
<script type="text/javascript">
$(function(){
	$("#formSubmit").click(function() {
		var boardTitle=$("#boardTitle").val()+"";
		var boardPw=$("#boardPw").val()+"";
		var boardContents=$("#boardContents").val()+"";
		
		if(boardTitle == "" || boardPw == "" || boardContents == ""){
			alert("빈 칸이 없도록 모두 입력해주세요.");
		}else{				
		$("#form").submit();
		}
		
	});
	$("#backList").click(function(){
		location.href="./qnaList.do";
	});
});
</script>
</head>
<body>
<div>
	    <c:import url="../main/miniMenu.jsp">
	    	<c:param name="main" value="3" />
	    </c:import>
	</div>
	<section>
		<div id="writeForm">
			<div id="listHeader">
				<h1>Q&A</h1>
			</div>
			<div id="formArea">
			<form id="form" action="qnaWrite.do" method="post">
				<p>
					<span class="titles">제목</span> <input type="text"
						placeholder="게시글 제목을 작성해 주세요." name="boardTitle" id="boardTitle">
				</p>
				<p>
					<span class="titles">PW</span> <input type="password"
						placeholder="비밀번호를 입력해주세요." name="boardPw" id="boardPw">
				</p>
				<div id="textarea">
					<textarea name="boardContents" id="boardContents"></textarea>
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