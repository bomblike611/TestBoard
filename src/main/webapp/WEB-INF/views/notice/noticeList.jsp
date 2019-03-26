<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/notice/noticeList.css'/>" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$(".writeButton").click(function(){
		location.href="./Write.do";
	});
});
</script>
<style>
.img2 {
	width: 100%;
	hegiht: 200px;
}

.img2 img {
	width: 100%;
	height: 200px;
}

.img_text_center {
	padding: 0px 0px;
	text-align: center;
	position: absolute;
	top: 25%;
	left: 3%;
	line-height: 40%;
}

#font1 {
	font-size: 40pt;
	color: white;
}
</style>
</head>
<body>
	<c:import url="../main/miniMenu.jsp" >
	<c:param name="main" value="2" />
	</c:import>
	
	<section>
		<br>
		<div id="noticeList">
			<div id="listHeader">
				<h1>공지사항</h1>
				<p>반드시 읽어 봐야 할 내용입니다.</p>
				<c:if test="${admin=='관리자'}">
				<div class="writeButton">글쓰기</div>
				</c:if>
			</div>
			<table class="tbl_nt">
				<tr id="tbl_nt_head">
					<th class="tbl_col1">번호</th>
					<th class="tbl_col2">제목</th>
					<th class="tbl_col3">작성자</th>
					<th class="tbl_col4">작성일</th>
				</tr>
				<c:forEach items="${list}" var="contents" varStatus="num">
					<tr class="tbl_nt_col">
						 <td>${page.totalrecord - num.index -((page.pageIndex-1)*10)}</td> 
						 <c:if test="${contents.adminDelete=='n'}">
						<td class="left"><a href="Contents.do?boardNum=${contents.boardNum}" id="ahref">${contents.boardTitle}</a></td>
						</c:if>
						<c:if test="${contents.adminDelete=='y'}">
						<td class="left"><a href="Contents.do?boardNum=${contents.boardNum}" id="ahref">삭제된 내용입니다.</a></td>
						</c:if>
						<td>사용자</td>
						<td>${contents.boardDate}</td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<p>
		<div class="list_n_menu">
			<c:if test="${page.prev}">
				<a href="List.do?pageIndex=${page.firstIndex -1}"> ◀ 이전 </a>
			</c:if>

			<c:forEach begin="${page.firstIndex}" end="${page.lastIndex2}"
				var="text" step="1">
				<c:choose>
					<c:when test="${page.pageIndex == text }">
			        	${text}
			        </c:when>
					<c:otherwise>
						<a href="List.do?pageIndex=${text}">${text}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${page.next}">
				<a href="List.do?pageIndex=${page.lastIndex2 +1}"> 다음 ▶ </a>
			</c:if>
		</div>
	</section>
</body>
</html>


