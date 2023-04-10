<%@page import="client.Client"%>
<%@page import="board.Board"%>
<%@page import="board.controller.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header" />
<link rel="stylesheet" href="../resources/write.css">
</head>
<%
String postno = request.getParameter("postno");
BoardDao boardDao = BoardDao.getInstance();
Board board = boardDao.getBoardByPostno(postno);
Client client = (Client)session.getAttribute("log");
%>
<body>
	<section>
		<div class="container">
			<form method="POST" action="../service">
				<input type="hidden" name="command" value="modify">
				<input type="hidden" name="postno" value=<%=postno %>>
				<div>
					<textarea name="title" rows="1" cols="40" required ><%=board.getTitle() %></textarea>
				</div>
				<div class="content">
					<textarea name="content" rows="23" cols="130" required><%=board.getContent() %></textarea>
				</div>
				<div>
					<input type="submit" value="수정하기">
				</div>
			</form>
		</div>
	</section>
</body>
<jsp:include page="footer" />
</html>