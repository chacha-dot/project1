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
.login4{
	background-color: white;
	box-sizing: border-box;
	border: 0.5px solid gray;
	width: 250px;
	height: 40px;
	font-size: small;
}
</style>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="login1">
	<img class="img1" alt="" src="./img/images.jpeg" height="100px">
	<h1>Login</h1><br>
	<form action="./login" method="post"> 
		<input name="id" maxlength="20" required="required" type="text" placeholder="ID를 입력하세요.">
		<br>
		<input name="pw" required="required" type="password" placeholder="PW를 입력하세요.">
		<br>
		<button class="login4" type="submit" >로그인</button>
	</form>
	<button class="login3">아이디찾기</button>
	<button class="login3">비밀번호찾기</button>
	<button class="login3">회원가입</button>
	
	<br>
</div>
</body>
</html>