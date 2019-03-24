<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/qna/qnaList.css'/>"/>

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
<section>
	<div>
	    <c:import url="../main/banner.jsp" />
	</div>
	<div class="img2">
	   <img src="./images/office.jpg" alt="cm">
	   <div class="img_text_center"><p id="font1">커뮤니티</p>
	   </div>
	 </div>
<div id="noticeList">
			<div id="listHeader">
				<h1>Q&A</h1>
				<p>고객의 질문에 성실히 답해드리겠습니다.</p>
				<span><img alt="" src="./images/search.jpg">
				<input type="text" placeholder="검색" name="boardTitle"></span>
			</div>
				<table class="tbl_nt">
					<tr id="tbl_nt_head">
						<th class="tbl_col1">번호</th>
						<th class="tbl_col2">제목</th>
						<th class="tbl_col3">작성자</th>
						<th class="tbl_col4">작성일</th>
					</tr>
					
				<c:forEach items="${list}" var="contents">
					<tr id="tbl_nt_col">
						<td>${contents.boardNum}</td>
						<td>${contents.boardTitle}</td>
						<td>${contents.boardWriter}</td>
						<td>날자</td>
					</tr>
				</c:forEach>
				</table>
				
					</div>
					<p>
       <div class="list_n_menu"> 
        	<c:if test="${page.prev}">
        	<a href="#"> ◀ 이전  </a>
        	</c:if>
        	
	       <c:forEach begin="${page.firstIndex}" end="${page.lastIndex}" var="text" step="1">
	        <a href="#">${text}</a>
	        </c:forEach> 
	        
	        <c:if test="${page.next}">
        	<a href="#"> 다음 ▶ </a>
        	</c:if>
	       
	        
	        <div class="writeButton">글쓰기</div>
</div>





</section>
</body>
</html>


