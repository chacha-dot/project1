<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/detail.css">
<!-- 폰트구현 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

</head>
<body>
<%@ include file="menu.jsp" %>

	<img class="img1" alt="" src="./img/images.jpg" height="300px">
	<br><br>
	<div class="btitle">${dto.btitle }</div> <br>
	<div class="no">글번호 : ${dto.bno }</div>
	<div class="write">&nbsp;&nbsp;글쓴이 : ${dto.bwrite }  </div>
	<div class="date">&nbsp;&nbsp;수정 : ${dto.bdate }  </div>
	<div class="like">&nbsp;&nbsp;조회수 : ${dto.blike }  </div><br>
	<hr>
	<div class="content">${dto.bcontent }</div>

	
</body>
</html>