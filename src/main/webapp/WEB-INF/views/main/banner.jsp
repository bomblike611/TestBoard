<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link type="text/css" rel="stylesheet" href="<c:url value='/css/banner/banner.css'/>"/>

<ul>
  <li style="float:left"><a href="#about"><img src="./images/cm_logo_han.png"></a></li>
  <li class="dropdown"><a href="./communityList.do">커뮤니티</a>
  <div class="dropdown-content">
      <a href="./communityList.do">자유게시판</a>
      <a href="#">Q&A</a>
    </div>
    </li>
   <li><a href="#news">알림마당</a></li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">회사 소개</a>
    <div class="dropdown-content">
      <a href="#">소개</a>
      <a href="#">연혁</a>
    </div>
  </li>
</ul>



