<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
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
</style>
</head>
<body>
<%@ include file="menu.jsp" %>
	
	<h1>수정하기</h1>
	
	<img class="img1" alt="" src="./img/images.jpeg" height="100px">
	
	<div class="write-div">
		<form action="./edit" method="post">
			<input type="text" name="btitle" value="${dto.btitle }">
			<hr>
			<textarea id="summernote" name="bcontent">${dto.bcontent }</textarea>
			<button class="btn2" type="submit">수정하기</button>
			<input type="hidden" name="bno" value="${dto.bno }">
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