<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/community/communityContents.css'/>" />
<title>Insert title here</title>
</head>
<body>
	<section>
		<div id="Contents">
			<div id="contentsHeader">
				<p>자유게시판</p>
				<div class="writeButton">수정</div>
				<div class="writeButton" id="delete">삭제</div>
			</div>
			<ul id="ulContents">
				<li><img alt="" src="./images/cat.jpg"></li>
				<li><div id="comContents">
						<div id="contentTitle">
							<b>제목</b>
							<p>노트북 추천 부탁드립니다</p>
						</div>
						<div>
							<span>2019-03-10 </span> <span id="count">조회수 1 </span>
							<div id="contentForm">알바하면서 살고있는 대학생입니다. 40만원대의 사양 좋은 노트북을 구하고 있습니다. 간단한
								문서작업과 인터넷서핑정도만 하니 좋은 노트북있으면 추천 부탁드려요!!</div>
						</div>
					</div></li>
			</ul>
		</div>
	</section>
</body>
</html>