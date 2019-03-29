<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/community/communityForm.css'/>" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value='/js/lengthCheck.js'/>"></script>
			<!-- <script src="//cdn.ckeditor.com/4.11.3/basic/ckeditor.js"></script> -->
			
	<script type="text/javascript" src="<c:url value='/test/validator.do'/>"></script>
    <validator:javascript formName="boardDTO" staticJavascript="false" xhtml="true" cdata="false"/>
	
	
<title>천명시스템</title>
<script type="text/javascript">
$(function(){
	
	/* CKEDITOR.replace('content'); */
	$("#formSubmit").click(function(){
		var boardTitle=$("#boardTitle").val()+"";
		var boardContents=$("#content").val()+"";
		if(boardTitle==""||boardContents==""){
			alert("빈 칸이 없도록 모두 입력해주세요.");
		}else{				
		$("#form").submit();
		}
		
	});
	$("#backList").click(function(){
		location.href="./List.do";
	});
});

function next(){
	var form=document.boardDTO;
	if(!validateBoardDTO(form)){
		alert("글자수를 확인해주세요.");
	}else{
		form.submit();
	}
}
</script>
</head>
<body>
<c:import url="../main/miniMenu.jsp" >
<c:param name="main" value="2" />
</c:import>
	<section>
		<div id="writeForm">
			<div id="listHeader">
				<h1>공지사항</h1>
			</div>
			<div id="formArea">
			<form:form id="boardDTO" action="Write.do" method="post" name="boardDTO" commandName="boardDTO">
			<input type="hidden" name="boardWriter" value="관리자">
				<p>
					<span class="titles">제목</span> <!-- <input type="text"
						placeholder="게시글 제목을 작성해 주세요." name="boardTitle" id="boardTitle" onkeyup="lengthCheck(this,100)"> -->
				<form:input path="boardTitle" maxlength="50"/>
				&nbsp;<form:errors path="boardTitle" />
				</p>
				<div id="textarea">
					<textarea name="boardContents" id="content" onkeyup="lengthCheck(this,2000)"></textarea>
				</div>
				<br><ul id="buttons">
			<li id="formSubmi" onclick="next()">등록</li>
			<li id="backList">취소</li>
			</ul>
			</form:form></div>
		</div>
	</section>
</body>
</html>