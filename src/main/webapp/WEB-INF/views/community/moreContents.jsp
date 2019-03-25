<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".writeButton").click(function() {
			location.href = "./communityWrite.do";
		});

		$(".detail").click(function() {
			var boardNum = $(this).attr("title");
			location.href = "communityContents.do?boardNum=" + boardNum;
		});
</script> -->
				<c:forEach items="${list}" var="contents">
					<li class="listContent"><c:if
							test="${not empty contents.fileSaveName}">
							<img alt="image" src="/upload/${contents.fileSaveName}"
								class="detail" title="${contents.boardNum}" name="${contents.adminDelete}">
						</c:if> <c:if test="${empty contents.fileSaveName}">
							<img alt="image" src="./images/office.jpg" class="detail"
								title="${contents.boardNum}" name="${contents.adminDelete}">
						</c:if> <c:if test="${contents.adminDelete=='n'}">
							<p class="detail" title="${contents.boardNum}" name="${contents.adminDelete}">${contents.boardTitle}</p>
						</c:if> <c:if test="${contents.adminDelete=='y'}">
							<p class="detail" title="${contents.boardNum}"
								style="color: red;" name="${contents.adminDelete}">삭제된 게시물입니다.</p>
						</c:if></li>
				</c:forEach>
