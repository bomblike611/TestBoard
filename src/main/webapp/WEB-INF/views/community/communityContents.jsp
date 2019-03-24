<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/community/communityContents.css'/>" />
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
			/* location.href="./communityDelete.do?boardNum="+num;	 */	
			$("#myModal").css("display","block");
		});
		$("#close").click(function(){
			/* location.href="./communityDelete.do?boardNum="+num;	 */	
			$("#myModal").css("display","none");
		});
	});
</script>
</head>
<body>
<c:import url="../main/miniMenu.jsp" />
	<section>
		<div id="Contents">
			<div id="contentsHeader">
				<p>자유게시판</p>
				<div class="writeButton" id="update">수정</div>
				<div class="writeButton" id="delete">삭제</div>
			</div>
			<ul id="ulContents">
				<li>
				<c:if test="${not empty contents.fileSaveName}">
				<img alt="" src="/upload/${contents.fileSaveName}">
				</c:if>
				<c:if test="${empty contents.fileSaveName}">
				<img alt="" src="./images/office.jpg">
				</c:if>
				</li>

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
	</section>
<div id="myModal" class="modal">
  <!-- Modal content -->
  <div class="modal-content">
    <span id="close">&times;</span>
    <p> ▶ 비밀번호</p>
    <p><input type="text" name="boardPw" placeholder="비밀번호를 입력해주세요"></p>
    <div class="writeButton" id="deleted">삭제</div>
  </div>
</div>
</body>
</html>


