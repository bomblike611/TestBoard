<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
ul {

  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: right;
    padding-right: 70px;
    padding-left: 10px;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 34px 16px;
  text-decoration: none;
}



li.dropdown {
  display: inline-block;
}
.drop{
 list-style:none;
 display: inline-block;
 width : 100%;
}

.dropdown-content {
  display: none;

  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<body>

<ul>
  <li style="float:left"><a href="#about"><img class="bannerLogo" src="./images/cm_logo_han.png"></a></li>
  <li class="dropdown"><a href="#news">커뮤니티</a>
  <div class="dropdown-content">
      <a href="#">자유게시판</a>
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

</body>
</html>


