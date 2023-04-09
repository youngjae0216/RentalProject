<%@page import="java.util.Random"%>
<%@page import="booking.controller.BookingDao"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="header"/>
<body>
<%
DBManager.getConnection();
%>
	<section>
		<h2>렌트카 서비스 프로젝트</h2>
	</section>
</body>
<jsp:include page="footer"/>
</html>