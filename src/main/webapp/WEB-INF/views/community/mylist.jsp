<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$(".writeButton").click(function(){
		location.href="./communityWrite.do";
	});
});
</script>
</head>
<body>
<div id="communityList">
			<div id="listHeader">
				<h1>공지사항</h1>
				<p>반드시 읽어 봐야 할 내용입니다.</p>
				<div class="writeButton">글쓰기</div>
			</div>
</body>
</html>