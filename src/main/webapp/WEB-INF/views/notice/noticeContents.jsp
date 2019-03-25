<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/notice/noticeContents.css'/>" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var boardNum=${contents.boardNum};
		$("#update").click(function(){
			location.href="./Update.do?boardNum="+boardNum;
		});
		$("#delete").click(function(){
			location.href="./Delete.do?boardNum="+boardNum;			
		});
	});
	
	</script>
</head>
<body>
	<c:import url="../main/miniMenu.jsp" />
	<section>
		<div class="noticeContainer">
			<div class="noticeHeader">
				<ul id="contentsHeader">
					<li id="notice"><h1>공지사항</h1></li>
					<li class="prev"><span>&lt; 이전</span><span>다음 ></span></li>
				</ul>
			</div>
			<div class="noticeContents">
				<ul id="titles">
					<li id="title"><b>공지</b></li>
					<li id="boardTitle">${contents.boardTitle}</li>
					<li class="writeButton" id="update">수정</li>
					<li class="writeButton" id="delete">삭제</li>
				</ul>
				<span>관리자</span> <span class="date"><b>${contents.boardDate}</b></span>
				<div id="contentForm">${contents.boardContents }</div>
			</div>
			<div id="replyContainer">
				<ul id="replyContent">
					<li><input type="text" placeholder="닉네임"
						style="float: left; display: inline;"><input
						type="password" placeholder="비밀번호"
						style="float: left; display: inline;"></li>

					<li id="textArea"><textarea></textarea></li>
					<li><div>삭제</div></li>
				</ul>
				<div id="replyList">
					<div>
						<b>작성자</b>내용<span class="date">날짜 <span style="color: red;">X</span></span>
					</div>

				</div>
			</div>
		</div>
	</section>
	<div id="myModal" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<span id="close">&times;</span>
			<p>▶ 비밀번호</p>
			<p>
				<input type="password" id="boardPw" name="boardPw"
					placeholder="비밀번호를 입력해주세요">
			</p>
			<div class="writeButton updated" id="deleted">삭제</div>
		</div>
	</div>
</body>
</html>