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
	$(function() {
		var boardNum =${contents.boardNum};
		var admin="${admin}";
		$("#update").click(function() {
			location.href = "./Update.do?boardNum=" + boardNum;
		});
		$("#delete").click(function() {
			location.href = "./Delete.do?boardNum=" + boardNum;
		});
		$("#submit").click(function(){
			$("#form").submit();
		});
		$("#replyDelete").click(function(){
			$("#myModal").css("display","block");
		});
		
		$("#deleted").click(function(){
			var replyNum=$("#replyDelete").attr("title");
			var pw=$("#pw").val()+"";
			var userPw=$("#boardPw").val()+"";
			if(pw==userPw||admin=='관리자'){
			location.href="./replyDelete.do?replyNum="+replyNum+"&boardNum="+boardNum;				
			}else{
				alert("비밀번호가 일치하지 않습니다.");
			}
		});
		
		$("#close").click(function(){
			$("#myModal").css("display","none");
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
					<c:if test="${admin=='관리자'}">
					<li class="writeButton" id="update">수정</li>
					<li class="writeButton" id="delete">삭제</li>
					</c:if>
				</ul>
				<span>관리자</span> <span class="date"><b>${contents.boardDate}</b></span>
				<div id="contentForm">${contents.boardContents }</div>
			</div>
			<div id="replyContainer">
			<form action="replyWrite.do" method="post" id="form">
			<input type="hidden" name="boardNum" value="${contents.boardNum}">
				<table id="replyContent">
					<tr>
						<td class="td"><input type="text" placeholder="닉네임"
							style="float: left; display: inline;" name="replyName"></td>
						<td rowspan="2" id="textArea"><textarea name="replyContents"></textarea></td>
						<td rowspan="2"><div id="submit">등록</div></td>
					</tr>
					<tr>
						<td class="td"><input type="password" placeholder="비밀번호"
							style="float: left; display: inline;" name="replyPw"></td>
					</tr>
				</table>
			</form>
				<table id="replyList">
				<c:forEach items="${replyList}" var="re">
					<tr>
						<th><input id="pw" type="hidden" value="${re.replyPw}">${re.replyName}</th><td id="contents">${re.replyContents}</td><td><span class="date">${re.replyDate}<span style="color: red;" id="replyDelete" title="${re.replyNum}">X</span></span></td>
					</tr>
				</c:forEach>

				</table>
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