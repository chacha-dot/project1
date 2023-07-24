<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="./css/menu.css">

<!-- 폰트구현 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Nanum+Gothic&family=Noto+Serif+KR&display=swap" rel="stylesheet">

	<nav>
		<ul>
			<li onclick="link('index')">MAIN</li>
			<li onclick="link('board')">BOARD</li>
			<li onclick="link('board2')">BOARD-2</li>
			<li onclick="link('mooni')">REQUEST</li>
			<li onclick="link('notice')">NOTICE</li>
			<c:choose>
				<c:when test="${sessionScope.mname eq null}">
					<li class="login2" onclick="link('login')">LOGIN</li>
				</c:when>
				<c:otherwise>
					<li class="login2" onclick="link('logout')">LOGOUT</li>
					<li class="login5" onclick="link('myinfo')" >${sessionScope.mname}(${sessionScope.mid}) 님 반갑습니다.</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
	<div style="height: 50px; width: 100%"></div>
	<script>
	function link(url){
		location.href="./"+url;
	}
	</script>
