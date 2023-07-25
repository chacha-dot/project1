<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<link rel="stylesheet" href="./css/write.css">
<style type="text/css">
body{
	background-color: white;
}
#msg{
	color: red;
	font-weight: 900;
}
</style>

<script type="text/javascript">
function check() {
	let msg = document.getElementById("msg");
	let title = document.getElementById("title");
	let sn = document.getElementById("summernote");
	
	if (title.value.length < 5) {
		let text = "<P>타이틀은 5글자 이상이어야 합니다.</P>";
		msg.innerHTML = text;
		title.focus();
		return false;
	}
	if (sn.value.length < 15) {
		let text = "<P>내용은 4글자 이상이어야 합니다.</P>";
		msg.innerHTML = text;
		sn.focus();
		return false;
	}
}
</script>

</head>
<body>
<%@ include file="menu.jsp" %>
	
	<h1>글쓰기</h1>
	<img class="img1" alt="" src="./img/images.jpeg" height="100px">
	
	<div class="write-div">
		<form action="./write" method="post" onsubmit="return check()">
			<input id="title" type="text" name="title">
			<span id="msg"></span>
			<hr>
			<textarea id="summernote" name="content"></textarea>
			<button class="btn2" type="submit">글쓰기</button>
		</form>
	</div>
	
	<script type="text/javascript">
	$(document).ready(function() {
		  $('#summernote').summernote({
			  height: 400
		  });
		});
	</script>
	
</body>
</html>