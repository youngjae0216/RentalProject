<%@page import="board.Board"%>
<%@page import="board.controller.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header" />
</head>
<%
String postno = request.getParameter("postno");
BoardDao boardDao = BoardDao.getInstance();
Board board = boardDao.getBoardByPostno(postno);

%>

<body>
	<section>
	<div>
	<h3>제목 : <%=board.getTitle() %> / 작성자 : <%=board.getClientId() %></h3>
	<p><%=board.getContent() %></p>
	<p>게시일 : <%=board.getDate() %> / 수정일 : <%=board.getModDate() %></p>
	<button onclick="location.href='community'">뒤로가기</button>
	</div>
	</section>
</body>
<jsp:include page="footer" />
</html>