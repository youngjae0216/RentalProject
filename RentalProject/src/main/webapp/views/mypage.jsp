<%@page import="client.Client"%>
<%@page import="booking.Booking"%>
<%@page import="java.util.ArrayList"%>
<%@page import="booking.controller.BookingDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header" />
</head>
<%

Client client = (Client)session.getAttribute("log");

if(client == null) {
	response.sendRedirect("login");
}
else {

BookingDao bookingDao = BookingDao.getInstance();
ArrayList<Booking> list = bookingDao.getBookingById(client.getClientId());

%>
<body>
<section>
	<h2>예약 내역</h2>
	<table border=1>
		<thead>
			<tr>
				<th>예약번호</th>
				<th>운행날짜</th>
				<th>대여시간</th>
				<th>총액</th>
				<th>자동차번호</th>
				<th>주차장넘버</th>
				<th>아이디</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Booking booking : list) {
			%>
			<tr>
				<td><%=booking.getRevNum()%></td>
				<td><%=booking.getOpDate()%></td>
				<td><%=booking.getHour()%></td>
				<td><%=booking.getPay()%></td>
				<td><%=booking.getVehicleId()%></td>
				<td><%=booking.getVenueId()%></td>
				<td><%=booking.getClientId()%></td>
				<td><%=booking.getRegDate()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
<%} %>
</section>
</body>
<jsp:include page="footer" />
</html>