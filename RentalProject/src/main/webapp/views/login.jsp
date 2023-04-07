<%@page import="client.controller.ClientDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header"/>
</head>
<body>
	<%
	ClientDao clientDao = ClientDao.getInstance();
	String clientId = request.getParameter("clientId");
	String password = request.getParameter("password");
	%>
	<section>
		<h2>로그인</h2>
		<form method="POST" action="../service">
		<input type="hidden" name="command" value="login">
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
					<td colspan="2">
					<input type="button" value="로그인" onclick="checkValues(form)">
					</td>
				</tr>
			</table>
		</form>
	</section>
	<script type="text/javascript" src="../resources/login.js"></script>
	
</body>
<jsp:include page="footer"/>
</html>