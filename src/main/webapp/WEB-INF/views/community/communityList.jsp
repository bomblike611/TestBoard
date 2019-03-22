<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/community/communityList.css'/>" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$(".writeButton").click(function() {
			location.href = "./communityWrite.do";
		});

		$(".detail").click(function() {
			var boardNum = $(this).attr("title");
			location.href = "communityContents.do?boardNum=" + boardNum;
		});

	});
</script>
</head>
<body>
	<section>
		<div id="communityList">
			<div id="listHeader">
				<h1>자유게시판</h1>
				<p>자유롭게 게시물을 작성할 수 있는 게시판입니다.</p>
				<div class="writeButton">글쓰기</div>
				<input type="hidden" name="firstIndex" value="${vo.firstIndex}">
				<input type="hidden" name="lastIndex" value="${vo.lastIndex}">
			</div>
			<ul id="listContents">
				<c:forEach items="${list}" var="contents">
					<li class="listContent">
					<c:if test="${not empty contents.fileSaveName}">
					<img alt="image"
						src="/upload/${contents.fileSaveName}" class="detail" title="${contents.boardNum}">						
					</c:if>
					<c:if test="${empty contents.fileSaveName}">
					<img alt="image"
						src="../images/그림1.png" class="detail" title="${contents.boardNum}">
					</c:if>
						<c:if test="${contents.adminDelete=='n'}">
					<p class="detail" title="${contents.boardNum}">${contents.boardTitle}</p>
					</c:if>
						<c:if test="${contents.adminDelete=='y'}">
						<p class="detail" title="${contents.boardNum}" style="color: red;">부적절한 콘텐츠입니다..</p>
						</c:if>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div id="nextPage">▼</div>
	</section>

</body>
</html>