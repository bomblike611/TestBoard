<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/banner/miniMenu.css'/>" />
<c:import url="../main/banner.jsp" />
<div id="miniMenu">
	<div id="imgDiv">
		<img src="./images/bannerImg.png" id="bannerImg">
		<p id="imgDivText">알림마당</p>
	</div>
	<ul id="miniMenubar">
		<li id="home"><img alt="home" src="./images/homes.png"></li>
		<li class="menus">▶ 소개</li>
		<li class="menus">▶ 연혁</li>
	</ul>
</div>
