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
BoardDao boardDao = BoardDao.getInstance();
String title = request.getParameter("title");
String content = request.getParameter("content");

%>
<body>
	<section>
		<div class="container">
			<form method="POST" action="../service">
				<input type="hidden" name="command" value="write">
				<div>
					<textarea name="title" id="title" rows="1" cols="40" placeholder="제목" required <%=title == null ? "autofocus" : ""%>><%=title != null ? title : ""%></textarea>
				</div>
				<div class="content">
					<textarea name="content" id="content" rows="23" cols="130" placeholder="내용" <%=content == null ? "autofocus" : ""%> required><%=content != null ? content : ""%></textarea>
				</div>
				<div>
					<input type="button" value="작성하기" onclick="checkValues(form)">
				</div>
			</form>
		</div>
	</section>
	<script type="text/javascript" src="../resources/write.js"></script>
</body>
<jsp:include page="footer" />
</html>