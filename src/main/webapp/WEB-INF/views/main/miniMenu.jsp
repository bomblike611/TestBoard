<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/banner/miniMenu.css'/>" />
<c:import url="../main/banner.jsp" />
<div id="miniMenu">

	<c:choose>
		<c:when test="${param.main == '1'}">
			<div id="imgDiv">
				<img src="./images/bannerImg.png" id="bannerImg">
				<p id="imgDivText">회사소개</p>
			</div>
			<ul id="miniMenubar">
				<li id="home"><img alt="home" src="./images/homes.png"></li>
				<li class="menus">▶ 소개</li>
				<li class="menus">▶ 연혁</li>
			</ul>
		</c:when>
		<c:when test="${param.main == '2'}">
			<div id="imgDiv">
				<img src="./images/bannerImg.png" id="bannerImg">
				<p id="imgDivText">알림마당</p>
			</div>
			<ul id="miniMenubar">
				<li id="home"><img alt="home" src="./images/homes.png"></li>
				<li class="menus">▶ 공지사항</li>	
			</ul>
		</c:when>
		<c:otherwise>
			<div id="imgDiv">
				<img src="./images/bannerImg.png" id="bannerImg">
				<p id="imgDivText">커뮤니티</p>
			</div>
			<ul id="miniMenubar">
				<li id="home"><img alt="home" src="./images/homes.png"></li>
				<li class="menus">▶ 자유게시판</li>
				<li class="menus">▶ Q&A</li>
			</ul>
		</c:otherwise>
		
	</c:choose>
	
</div>
