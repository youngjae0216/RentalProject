package controller.Action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import booking.BookingRequestDto;
import booking.controller.BookingDao;
import client.Client;
import vehicle.Vehicle;
import vehicle.controller.VehicleDao;

public class RentalAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 이름을 파라미터로 받는 vehicle 찾는 메서드 vehicleDao에 구현

		VehicleDao vehicleDao = VehicleDao.getInstance();
		BookingDao bookingDao = BookingDao.getInstance();

		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("log");
		
		String name = request.getParameter("name");

		Vehicle vehicle = vehicleDao.getVehicleByName(name);

		String vehicleId = vehicle.getVehicleId();
		String clientId = client.getClientId();
		String venueId = vehicle.getVenueId();
		Timestamp opDate = Timestamp.valueOf(request.getParameter("opDate")+" 00:00:00.0");
		int hour = Integer.parseInt(request.getParameter("hour"));
		int pay = hour * 8000;
		Timestamp regDate = null;
		String revNum = bookingDao.getReservationNum();

		BookingRequestDto bookingDto = new BookingRequestDto(vehicleId, clientId, venueId, opDate, hour, pay, regDate,
				revNum);
		bookingDao.createBooking(bookingDto);

		vehicleDao.updateVehicleRev(vehicleId);
		
		
		if (vehicleDao.getVehicleByName(name).getCheckRev() == 0) {
			response.sendRedirect("rental");
		} else {
			response.sendRedirect("mypage");
		}
	}

}
