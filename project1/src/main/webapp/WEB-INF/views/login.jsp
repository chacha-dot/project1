<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style type="text/css">
body{
	background-color: white;
}
h1{
	margin: 0 auto;
	display: block;
}
.login1{
	text-align: center;
}
.img1{
	margin: 0 auto;
	display: block;
}
input{
	margin: 5px 0px;
	border-radius: 5px;
	box-sizing: border-box;
	border: 0.5px solid gray ;
	padding: 5px 8px 5px;
	width: 250px;
	height: 40px;
	font-size: small;
}
.login3{
	margin: 10px 0px;
	box-sizing: border-box;
	border: 0px;
	padding: 5px 8px;
	font-size: xx-small;
	background-color: white;
	color: gray;
}
.login{
	background-color: white;
	box-sizing: border-box;
	border: 0.5px solid gray;
	width: 250px;
	height: 40px;
	font-size: small;
}
</style>
<script type="text/javascript">
//스크립트 영역
let text = "<P>올바른 아이디를 입력하세요.</P>";//전역변수
//호이스팅이 뭐에요 ? let vs var 차이가 뭐에요??

		
function checkID() {
	//alert("!");
	let msg = document.getElementById("msg");//지역변수
	msg.innerHTML = "<P>" + document.getElementById("id").value + "아이디를 변경했습니다.</P>";
}

function check() {
	let msg = document.getElementById("msg");
	let id = document.getElementById("id");
	//alert(id.value);
	//alert(id.value.length);
	if (id.value.length < 4) {
		alert("아이디는 4글자 이상이어야 합니다.");
		msg.innerHTML = text;
		id.focus();
		return false;
	}
	let pw = document.getElementById("pw");
	if (pw.value.length < 4) {
		alert("암호는 4글자 이상이어야 합니다.");
		msg.innerHTML = text;
		pw.focus();
		return false;
	}
	
}
</script>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="login1">
	<img class="img1" alt="" src="./img/images.jpeg" height="100px">
	<h1>Login</h1><br>
	<form action="./login" method="post" onsubmit="return check()"> 
		<input name="id" id="id" maxlength="20" type="text" placeholder="ID를 입력하세요." onchange="checkID()">
		<br>
		<input name="pw" id="pw" type="password" placeholder="PW를 입력하세요.">
		<br>
		<button class="login" type="submit">로그인</button>
		<span id="msg"></span>
	</form>
	<button class="login3">아이디찾기</button>
	<button class="login3">비밀번호찾기</button>
	<button class="login3">회원가입</button>
	
	<br>
</div>
</body>
</html>