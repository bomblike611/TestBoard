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
		var admin="${admin}";
		var num=${contents.boardNum};
		
		if(admin=="관리자"){
			$("#delete").click(function(){
				location.href="./communityDelete.do?boardNum="+num;
			});
		}else{
		$("#update").click(function() {
			$("#deleted").html("수정");
			$("#myModal").css("display","block");
		});
		$("#delete").click(function(){
			/* location.href="./communityDelete.do?boardNum="+num;	 */	
			$("#myModal").css("display","block");
			$("#deleted").html("삭제");
		});
		$("#close").click(function(){
			/* location.href="./communityDelete.do?boardNum="+num;	 */	
			$("#myModal").css("display","none");
		});
		
		$(".updated").click(function(){
			var pw= $("#boardPw").val()+"";
			var boardPw="${contents.boardPw}";
			var pageUrl=$("#deleted").text();
			if(pw == boardPw){
				if(pageUrl=="수정"){
					location.href="./communityUpdate.do?boardNum="+num;
				}else{
					location.href="./communityDelete.do?boardNum="+num;
				}
			}else{
				alert("비밀번호가 다릅니다.");
			}
		});
		}
		
		
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
    <p><input type="password" id="boardPw" name="boardPw" placeholder="비밀번호를 입력해주세요"></p>
    <div class="writeButton updated" id="deleted">삭제</div>
  </div>
</div>
</body>
</html>


