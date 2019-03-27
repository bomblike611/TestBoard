<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/qna/qnaList.css'/>"/>

<title>천명시스템</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var admin="${admin}";
	$("#search").click(function(){
		$("#form").submit();
	});
	
	$(".writeButton").click(function(){
		location.href="./qnaWrite.do";
	});
	$("#ahreff").click(function(){
		if(admin=="관리자"){
			location.href = "qnaContents.do?boardNum=" + boardNum;
		}else{
			alert("접근이 제한된 게시물입니다.");
		}
	});
	
	
});
</script>
</head>
<body>
<!-- ******* **************  ********************* -->
<section>
	<div>
	    <c:import url="../main/miniMenu.jsp">
	    	<c:param name="main" value="3" />
	    </c:import>
	</div>
<div id="noticeList">
			<div id="listHeader">
			<form id="form" action="qnaList.do" method="post">
				<h1>Q&A</h1>
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
						
						<c:choose>
							<c:when test="${contents.adminDelete=='n'}">
								<td><a href="qnaContents.do?boardNum=${contents.boardNum}" id="ahref">${contents.boardTitle}</a></td>
							</c:when>
							<c:otherwise>
							
							<c:choose>
								<c:when test="${admin== '관리자' }">
									<td><a href="qnaContents.do?boardNum=${contents.boardNum}" id="ahref">삭제된 게시글 : ${contents.boardTitle}</a></td>
								</c:when>
								<c:otherwise>
									<td>삭제된 게시물입니다.</td>
								</c:otherwise>
							</c:choose>
							
							
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${contents.boardPw != null}">
								<td>사용자</td>
							</c:when>
							<c:otherwise>
								<td>관리자</td>
							</c:otherwise>
						</c:choose>
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


