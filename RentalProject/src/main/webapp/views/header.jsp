<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/grid.css">
<title>Rental Service Program</title>
</head>
<body>
<%
Client client = (Client)session.getAttribute("log");
%>
	<header>
		<h1>렌 트 카</h1>
	</header>
	<nav>
		<ul>
			<li><a href="/">홈으로</a></li>
			<li><a href="rental">예약하기</a></li>
			<li><a href="community">커뮤니티</a></li>
			<li><a href="mypage">마이페이지</a></li>

			<%
			if(session.getAttribute("log") != null){
			%>
			<li><a href="../service?command=logout">로그아웃</a></li>
			<%} else{ %>
			<li><a href="login">로그인</a></li>
			<li><a href="join">회원가입</a></li>
			<%} %>
			
			<%
			if(session.getAttribute("log") != null){
			%>
			<p><%=client.getName() %>님 환영합니다!</p>
			<%} %>
		</ul>
	</nav>
</body>
</html>