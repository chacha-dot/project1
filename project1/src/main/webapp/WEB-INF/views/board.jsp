<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<link rel="stylesheet" href="./css/board.css">
</head>
<body>
<%@ include file="menu.jsp" %>
	<h1>보드</h1>
	<%-- 길이검사 : ${fn:length(list) } --%>
	<c:choose>
		<c:when test="${fn:length(list) gt 0}">
			<table>
				<tr class="head1">
					<td>번호</td>
					<td>제목</td>
					<td>글쓴이</td>
					<td>날짜</td>
					<td>좋아요</td>
				</tr>
				<c:forEach items="${list }" var="row">
				<!-- onclick 자바스크립트 페이지 이동, URL?파라미터=값 -->
				<tr onclick="location.href='./detail?bno=${row.bno }'">
					<td class="td1">${row.bno }</td>
					<td class="title">${row.btitle }</td>
					<td class="td1">${row.m_name }</td>
					<td class="td2">${row.bdate }</td>
					<td class="td1">${row.blike }</td>
				</tr>			
						
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>출력할 데이터가 없습니다.</c:otherwise>
	</c:choose>
	<a href="./index">
	<img class="img1" alt="" src="./img/images.jpeg" height="100px">
	</a>
	
	<!-- 로그인하면 글쓰기 버튼이 보여요 -->
	
	<c:if test="${sessionScope.mname ne null}">	
		<button onclick="location.href='./write'">글쓰기</button>
	</c:if>
</body>
</html>