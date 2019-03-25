<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/qna/qnaList.css'/>"/>

<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#search").click(function(){
		$("#form").submit();
	});
	
	$(".writeButton").click(function(){
		location.href="./qnaWrite.do";
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
<!-- ******* ************** 관리자 삭제시 , 검색 ********************* -->
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
			<form id="form" action="qnaList.do" method="post">
				<h1>Q&A44</h1>
				<p>고객의 질문에 성실히 답해드리겠습니다.</p>
				<span><img alt="" src="./images/search.jpg" id="search">
				<input type="text" placeholder="검색" name="searchKeyword"></span>
			</form>	
			</div>
				<table class="tbl_nt">
					<tr id="tbl_nt_head">
						<th class="tbl_col1">번호</th>
						<th class="tbl_col2">제목</th>
						<th class="tbl_col3">작성자</th>
						<th class="tbl_col4">작성일</th>
					</tr>
					
				<c:forEach items="${list}" var="contents" varStatus="num">
					<tr id="tbl_nt_col">
						 <td>${page.totalrecord - num.index -((page.pageIndex-1)*10)}</td> 
						<td><a href="qnaContents.do?boardNum=${contents.boardNum}" id="ahref">${contents.boardTitle}</a></td>
						<td>사용자</td>
						<td>${contents.boardDate}</td>
					</tr>
				</c:forEach>
				</table>
					</div>
					<p>
       <div class="list_n_menu"> 
        	<c:if test="${page.prev}">
        	<a href="qnaList.do?pageIndex=${page.firstIndex -1}"> ◀ 이전  </a>
        	</c:if>
        	
	       <c:forEach begin="${page.firstIndex}" end="${page.lastIndex2}" var="text" step="1">
		        <c:choose>
			        <c:when test="${page.pageIndex == text }">
			        	${text}
			        </c:when>
			        <c:otherwise>
			        	<a href="qnaList.do?pageIndex=${text}">${text}</a>
			        </c:otherwise>
		        </c:choose>
	        </c:forEach> 
	        
	        <c:if test="${page.next}">
        	 <a href="qnaList.do?pageIndex=${page.lastIndex2 +1}"> 다음 ▶ </a>
        	</c:if>
	        <div class="writeButton">글쓰기</div>
	        
</div>

</section>
</body>
</html>


