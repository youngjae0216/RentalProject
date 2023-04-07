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
//로그
%>
<body>
	<section>
		<div class="container">
			<form method="POST" action="../service">
				<input type="hidden" name="command" value="write">
				<div>
					<textarea rows="1" cols="50" maxlength="50" placeholder="제목"
						required></textarea>
				</div>
				<div class="content">
					<textarea rows="23" cols="130" placeholder="내용" required></textarea>
				</div>
				<div>
					<button type="submit">작성하기</button>
				</div>
			</form>
		</div>
	</section>
</body>
<jsp:include page="footer" />
</html>