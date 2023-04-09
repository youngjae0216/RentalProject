<%@page import="vehicle.Vehicle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header" />
</head>
<%
VehicleDao vehicleDao = VehicleDao.getInstance();
ArrayList<Vehicle> list = vehicleDao.getVehicleNoneReservation();
%>
<body>
	<section>
		<h2>렌트카 예약 서비스</h2>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="rental">
			<table border=1>
				<tr>
					<th>차종</th>
					<td><select id="name" name="name">
							<%for(Vehicle vehicle : list){ %>
							<option value="<%=vehicle.getName() %>"><%=vehicle.getName() %></option>
							<%} %>
					</select></td>
				</tr>
				<tr>
					<th>시간</th>
					<td><input name="hour" type="text" required></td>
				</tr>
				<tr>
					<th>예약날짜</th>
					<td><input name="opDate" type="text"
						pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="####-##-##"
						placeholder="날짜 입력" required></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="예약하기"
						onclick="checkValues(form)"></td>
				</tr>
			</table>
		</form>
	</section>
	<script type="text/javascript" src="../resources/rental.js"></script>
</body>
<jsp:include page="footer" />
</html>