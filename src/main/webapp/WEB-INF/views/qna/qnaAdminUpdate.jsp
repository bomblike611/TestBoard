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
	$("#formSubmit").click(function() {
		var boardContents=$("#boardContents").val()+"";
		if(boardContents==""){
			alert("빈 칸이 없도록 모두 입력해주세요.");
		}else{				
		$("#form").submit();
		
		}
	});
	
	$("#backList").click(function(){
		var num=${contents.boardNum}
		location.href="./qnaContents.do?boardNum="+num;
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
			<form id="form" action="qnaAdminUpdate.do" method="post">
			<input type="hidden" name="boardNum" value="${contents.boardNum}">
			<input type="hidden" name="code" value="${contents.code}">
			<input type="hidden" name="boardRef" value="${contents.boardRef}">
			<input type="hidden" name="boardPw" value="">
			<input type="hidden" name="boardTitle" value="${contents.boardTitle}">
				<p>
					 <span class="titles">제목</span>${contents.boardTitle} 
					
				</p>
		
				<div id="textarea">
					<textarea name="boardContents" id="boardContents">${contents.boardContents}</textarea></div>
			</form></div>
			<ul id="buttons">
			<li id="formSubmit">등록</li>
			<li id="backList">취소</li>
			
			</ul>
		</div>
	</section>
</body>
</html>