<%@page import="board.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.controller.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header" />
</head>
<body>
<%
BoardDao boardDao = BoardDao.getInstance();
ArrayList<Board> list = boardDao.getBoardAll();
%>
<section>
<input type="hidden" name="command" value="mypage">
	<h2>자유게시판</h2>
	<table border=1>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>게시날짜</th>
				<th>수정날짜</th>
			</tr>
		</thead>
		<tbody>
		<% 
		for(Board board : list){
		%>
			<tr>
				<td><%=board.getPostno() %></td>
				<td><%=board.getTitle() %></td>
				<td><%=board.getClientId() %></td>
				<td><%=board.getDate() %></td>
				<td><%=board.getModDate() %></td>
			</tr>
			<%} %>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="5">
			<a href="write">글쓰기</a>
			</td>
		</tr>
		</tfoot>
	</table>
</section>
</body>
<jsp:include page="footer" />
</html>