<%@page import="java.sql.Timestamp"%>
<%@page import="client.controller.ClientDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/header" />
</head>
<body>
	<%
	ClientDao clientDao = ClientDao.getInstance();
	String clientId = request.getParameter("clientId");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	Timestamp date = new Timestamp(System.currentTimeMillis());
	%>
	<section>
		<h2>회원가입</h2>
		<form method="POST" action="../service">
		<input type="hidden" name="command" value="join">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input type="text" id="clientId" name="clientId"
						value="<%=clientId != null ? clientId : ""%>"
						<%=clientId == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" id="password" name="password"
						value="<%=password != null ? password : ""%>"
						<%=password == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" id="name" name="name"
						value="<%=name != null ? name : ""%>"
						<%=name == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>가입날짜</th>
					<td><input type="text" value="<%=date.toString().split(" ")[0] %>" readonly></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="button" value="제출하기" onclick="checkValues(form)">
					</td>
				</tr>
			</table>
		</form>
	</section>
	<script type="text/javascript" src="../resources/join.js"></script>
</body>
<jsp:include page="/footer" />
</html>