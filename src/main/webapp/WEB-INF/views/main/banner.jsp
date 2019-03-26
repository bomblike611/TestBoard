<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/banner/banner.css'/>"/>
	</head>

<ul class="bannerdg">
  <li class="bannermn" style="float:left"><a href="/TestBoard/main.do"><img src="./images/cm_logo_han.png"><span style="color: red;"> ${admin}</span></a></li>
  <li class="bannermn dropdown"><a href="communityList.do">커뮤니티</a>
  <div class="dropdown-content">
      <a href="./communityList.do">자유게시판</a>
      <a href="./qnaList.do">Q&A</a>
    </div>
    </li>
   <li class="bannermn"><a href="List.do">알림마당</a></li>
  <li class="bannermn dropdown">
    <a href="./Profile.do" class="dropbtn">회사 소개</a>
    <div class="dropdown-content">
      <a href="./Profile.do">소개</a>
      <a href="./History.do">연혁</a>
    </div>
  </li>
</ul>



