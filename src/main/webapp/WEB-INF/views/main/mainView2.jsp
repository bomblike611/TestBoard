<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
.img_text_center {
	padding: 0px 0px;
	text-align: center;
	position: absolute;
	top: 60%;
	left: 40%;
	line-height: 40%;
}

#font1 {
	font-size: 26pt;
	color: white;
}

#font2 {
	font-size: 40pt;
	color: white;
}

#button1 {
	background-color: blue;
	border: none;
	color: white;
	padding: 10px 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
}

.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 300px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
 /*  overflow: auto; Enable scroll if needed
  background-color: rgb(0,0,0); Fallback color
  background-color: rgba(0,0,0,0.4); Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 20%;
  height: 150px;
}

/* The Close Button */
#close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

#close:hover,
#close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

.modal-content p{
	color: #4A7EBB;
	font-weight: bold;
	font-size: 18px;
	margin: 3% 0;
}
.modal-content input{
	border: 1px solid #EAEAEA;
	width: 100%;
	margin: 0 auto;
}

#deleted{
	display: block;
	margin: 0 50%;
	width: 20%;
}
.writeButton{
	margin-top:5px;
	color: white;
	border: 1px solid #95B3D7;
	background-color: #95B3D7;
	margin-right: 1%;
	width: 7%;
	text-align: center;
	font-size: 14px;
	height: 25px;
	line-height: 25px;
	float: right;
	cursor: pointer;
	-webkit-transition: color 1s, background-color 1s; /* For Safari 3.1 to 6.0 */
	transition: color 1s, background-color 1s;
}

.writeButton:hover{
	border: 1px solid #95B3D7;
	color: blue;
	background-color: white;
}
</style>
<script type="text/javascript">
$(function(){
	var adminPw="${adminPw}";
	var admin="${admin}";
	$("#close").click(function(){
		$("#myModal").css("display","none");
	});
	$(".updated").click(function(){
		var pw= $("#adminPw").val()+"";
		if(pw == adminPw){
			alert("관리자모드가 10분간 유지됩니다.");
			$("#frm").submit();
			$("#myModal").css("display","none");
		}else{
			alert("비밀번호가 다릅니다.");
		}
	});
});
function modal(){
	$("#myModal").css("display","block");
}

</script>
</head>
<body>
	<div>
		<div>
			<c:import url="banner.jsp" />
		</div>
		<div>
			<img src="./images/office.jpg" alt="cm" style="width: 100%">
			<div class="img_text_center">
				<p id="font1">항상 고객을 생각하는</p>
				<p id="font2">
					<b>천명시스템</b>입니다
				</p>
				<c:if test="${not empty adminPw}">
				<button id="button1" onclick="modal()">> 관리자 모드</button>
				</c:if>
			</div>
		</div>
		
		<div id="myModal" class="modal">
			<!-- Modal content -->
			<div class="modal-content">
			 <form action="admin0327Main.do" method="post" id="frm">
				<span id="close">&times;</span>
				<p>▶ 비밀번호</p>
				<p>
					<input type="password" id="adminPw" name="adminPw"
						placeholder="비밀번호를 입력해주세요">
				</p>
				<div class="writeButton updated" id="deleted">삭제</div>
				  </form>
			</div>
		</div>

	</div>

</body>
</html>