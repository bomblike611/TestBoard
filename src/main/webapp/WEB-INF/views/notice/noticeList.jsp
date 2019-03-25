<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/notice/notice.css'/>"/>

<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$(".writeButton").click(function(){
		location.href="./communityWrite.do";
	});
});
</script>
<style>
.img2{
	 width:100%;
	 hegiht:200px;
}
.img2 img{
	width:100%;
	height:200px;
}
.img_text_center {
	padding: 0px 0px;
	text-align: center;
	position: absolute;
	top: 25%;
	left: 3%;
	line-height: 40%;

}
#font1{
	font-size:40pt;
	color:white;
}
</style>
</head>
<body>
	    <c:import url="../main/miniMenu.jsp" />
<section>
<br>
<div id="noticeList">
			<div id="listHeader">
				<h1>공지사항</h1>
				<p>반드시 읽어 봐야 할 내용입니다.</p>
				<div class="writeButton">글쓰기</div>
			</div>
				<table class="tbl_nt">
					<tr id="tbl_nt_head">
						<th class="tbl_col1">번호</th>
						<th class="tbl_col2">제목</th>
						<th class="tbl_col3">작성자</th>
						<th class="tbl_col4">작성일</th>
					</tr>
				<c:forEach begin="1" end="10" var="text" step="1">
					<tr id="tbl_nt_col">
						<td>${text}</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
					</tr>
				</c:forEach>
				</table>
				
					</div>
					<p>
       <div class="list_n_menu"> 
        	<span> ◀  </span>
	        <c:forEach begin="1" end="5" var="text" step="1">
	        <a href="#?page='${text}'">${text}</a>
	        </c:forEach>
	        <a href="#?page=2"> ▶ </a>
</div>




</section>
</body>
</html>


