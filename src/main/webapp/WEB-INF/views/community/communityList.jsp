<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/community/communityList.css'/>"/>
<title>Insert title here</title>
</head>
<body>
	<section>
		<div id="communityList">
			<div id="listHeader">
				<h1>자유게시판</h1>
				<p>자유롭게 게시물을 작성할 수 있는 게시판입니다.</p>
				<div class="writeButton">글쓰기</div>
			</div>
			<ul id="listContents">
			<c:forEach begin="1" end="10" var="text">
			<li class="listContent"><img alt="image" src="./images/cat.jpg"><p>${text}okok</p></li>
			</c:forEach>
			</ul>
		</div>
		<div id="nextPage">▼</div>
	</section>
</body>
</html>