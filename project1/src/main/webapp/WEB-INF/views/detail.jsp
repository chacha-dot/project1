<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/detail.css">
<script type="text/javascript">
	function del(){
		let chk = confirm("삭제하시겠습니까?");
		if(chk){
			location.href="./delete?bno=${dto.bno }";
		} else {
			
		}
	}
</script>
</head>
<body>
<%@ include file="menu.jsp" %>

	<img class="img1" alt="" src="./img/images.jpeg" height="300px">
	<br><br>
	<div class="btitle1">${dto.btitle }</div>
	<br> <br>
	<div class="no1">글번호 : ${dto.bno }</div>
	<div class="write1">&nbsp;&nbsp;글쓴이 : ${dto.bwrite }  </div>
	<div class="date1">&nbsp;&nbsp;수정 : ${dto.bdate }  </div>
	<div class="like1">&nbsp;&nbsp;조회수 : ${dto.blike }  </div>
	<div class="ip1">&nbsp;&nbsp;ip : ${dto.bip }  </div>
	<hr>
	<div class="content1">${dto.bcontent }</div>
	<div class="img2"><img alt="수정" src="./img/update1.png" height="16px">&nbsp;</div>
	<div class="img3"><img alt="삭제" src="./img/delete1.png" height="16px" onclick="del()"></div>

	
</body>
</html>