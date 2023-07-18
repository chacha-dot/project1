<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/detail.css">

</head>
<body>
<%@ include file="menu.jsp" %>

	<img class="img1" alt="" src="./img/images.jpg" height="300px">
	<br><br>
	<div class="btitle1">${dto.btitle }</div> <br>
	<div class="no1">글번호 : ${dto.bno }</div>
	<div class="write1">&nbsp;&nbsp;글쓴이 : ${dto.bwrite }  </div>
	<div class="date1">&nbsp;&nbsp;수정 : ${dto.bdate }  </div>
	<div class="like1">&nbsp;&nbsp;조회수 : ${dto.blike }  </div><br>
	<hr>
	<div class="content1">${dto.bcontent }</div>

	
</body>
</html>