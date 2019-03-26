<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/banner/miniMenu.css'/>" />
<c:import url="../main/banner.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$("#home").click(function(){
		location.href="./main.do";
	});
});
function notice(){
	location.href="./List.do";
}
function community(){
	location.href="./communityList.do"
}
function qna(){
	location.href="./qnaList.do";
}
function history(){
	location.href="./History.do";
}
function profile(){
	location.href="./Profile.do";
}

</script>
<div id="miniMenu">

	<c:choose>
		<c:when test="${param.main == '1'}">
			<div id="imgDiv">
				<img src="./images/bannerImg.png" id="bannerImg">
				<p id="imgDivText">회사소개</p>
			</div>
			<ul id="miniMenubar">
				<li id="home"><img alt="home" src="./images/homes.png"></li>
				<li class="menus" onclick="profile()">▶ 소개</li>
				<li class="menus" onclick="history()">▶ 연혁</li>
			</ul>
		</c:when>
		<c:when test="${param.main == '2'}">
			<div id="imgDiv">
				<img src="./images/bannerImg.png" id="bannerImg">
				<p id="imgDivText">알림마당</p>
			</div>
			<ul id="miniMenubar">
				<li id="home"><img alt="home" src="./images/homes.png"></li>
				<li class="menus" onclick="notice()">▶ 공지사항</li>	
			</ul>
		</c:when>
		<c:otherwise>
			<div id="imgDiv">
				<img src="./images/bannerImg.png" id="bannerImg">
				<p id="imgDivText">커뮤니티</p>
			</div>
			<ul id="miniMenubar">
				<li id="home"><img alt="home" src="./images/homes.png"></li>
				<li class="menus" onclick="community()">▶ 자유게시판</li>
				<li class="menus" onclick="qna()">▶ Q&A</li>
			</ul>
		</c:otherwise>
		
	</c:choose>
	
</div>
