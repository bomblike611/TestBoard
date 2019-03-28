<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/community/communityForm.css'/>" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>천명시스템</title>
<script type="text/javascript" src="<c:url value='/js/lengthCheck.js'/>"></script>
<script type="text/javascript">
	$(function() {
		$("#formSubmit").click(function() {
			var boardTitle=$("#boardTitle").val()+"";
			var boardPw=$("#boardPw").val()+"";
			var boardContents=$("#boardContents").val()+"";
			if(!fileCheck()){
				
			}else{
			if(boardTitle==""||boardPw==""||boardContents==""){
				alert("빈 칸이 없도록 모두 입력해주세요.");
			}else{				
			$("#form").submit();
			}
			}
		});
		$("#backList").click(function() {
			location.href = "./communityList.do";
		});
	});
	function fileCheck() {
		var fileext = document.getElementById('file').value;
		if(fileext==""){
			return true;
		}else{
			fileext = fileext.slice(fileext.indexOf(".") + 1).toLowerCase();
			if (fileext != "jpg" && fileext != "png" && fileext != "gif"
					&& fileext != "bmp") { 
				alert('이미지 파일(jpg, png, gif, bmp)만 등록 가능합니다.');
				return false;
			}else{
				return true;
			}
		}
		
	}
</script>
</head>
<body>
	<c:import url="../main/miniMenu.jsp" />
	<section>
		<div id="writeForm">
			<div id="listHeader">
				<h1>자유게시판</h1>
			</div>
			<div id="formArea">
				<form id="form" action="communityWrite.do" method="post"
					enctype="multipart/form-data">
					<c:choose>
					<c:when test="${admin=='관리자'}">
						<input type="hidden" name="boardWriter" value="관리자">
					</c:when>
					<c:otherwise>
							<input type="hidden" name="boardWriter" value="사용자" >
					</c:otherwise>
					</c:choose> 
					<p>
						<span class="titles">제목</span> <input type="text"
							placeholder="게시글 제목을 작성해 주세요." name="boardTitle" id="boardTitle" onkeyup="lengthCheck(this,150)">
					</p>
					<p>
						<span class="titles">PW</span> <input type="password"
							placeholder="비밀번호를 입력해주세요." name="boardPw" id="boardPw" onkeyup="lengthCheck(this,15)">
					</p>
					<div id="textarea">
						<textarea name="boardContents" id="boardContents" onkeyup="lengthCheck(this,2000)"></textarea>
					</div>
					<ul id="fileContents">
						<li class="fileText" >파일 첨부</li>
						<li id="filesName">
							<div>
								<input type="file" name="file" id="file">
							</div>
						</li>
						<!-- <li class="fileText"><div id="fileButton" onclick="fileCheck()">파일 첨부하기</div></li> -->
					</ul>
				</form>
			</div>
			<ul id="buttons">
				<li id="formSubmit">등록</li>
				<li id="backList">취소</li>
			</ul>
		</div>
	</section>
</body>
</html>