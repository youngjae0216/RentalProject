package controller.Action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import booking.controller.BookingDao;
import client.Client;
import vehicle.controller.VehicleDao;

public class RentalAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 이름을 파라미터로 받는 vehicle 찾는 메서드 vehicleDao에 구현
		
		VehicleDao vehicleDao = VehicleDao.getInstance();
		BookingDao bookingDao = BookingDao.getInstance();
		
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("log");
		
//		String vehicleId = 
		String clientId = client.getClientId();
//		String venueId = 
//		Timestamp opDate = request.getParameter("date");  가져온 값을 timestamp로 어떻게 변환??
		int hour = Integer.parseInt(request.getParameter("hour"));
		int pay = hour * 8000;
		Timestamp regDate = null;
//		String revNum = 	// 랜덤값 부여하는 메서드 구현 bookingDao에 구현 
		
		// 나머지 구현 booking에 넣고 / vehicle check_rev 값 1로 바꾸고 (update메서드구현)
		
		response.sendRedirect("mypage");
	}

}
