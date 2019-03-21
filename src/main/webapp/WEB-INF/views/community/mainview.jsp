<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.img_text_center {
	padding: 0px 0px;
	text-align: center;
	position: absolute;
	top: 60%;
	left: 40%;
	line-height: 40%;

}
#font1{
	font-size:26pt;
	color:white;
}
#font2{
	font-size:40pt;
	color:white;
}
.button1 {
    background-color: blue;
    border: none;
    color: white;
    padding: 10px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
}

</style>
</head>
<body>
<div>
	<div>
	    <c:import url="communityContents.jsp" />
	</div>
	<div>
	   <img src="./images/office.jpg" alt="cm" style="width:100%">
	   <div class="img_text_center"><p id="font1">항상 고객을 생각하는</p>
	  	 <p id="font2"><b>천명시스템</b>입니다</p>
	  	 <button class="button1" onclick="#"> > 회사 소개</button>
	   </div>
	 </div>
	 

</div>

</body>
</html>