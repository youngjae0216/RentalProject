package booking.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

import booking.Booking;
import booking.BookingRequestDto;
import util.DBManager;

public class BookingDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BookingDao() {
	}

	private static BookingDao instance = new BookingDao();

	public static BookingDao getInstance() {
		return instance;
	}

	public String getReservationNum() {
		Random ran = new Random();
		String result = "";
		int count = 0;
		while (count < 10) {
			if (count < 5) {
				// 65~90
				int rNum = ran.nextInt(24) + 65;
				char a = (char) rNum;
				result += a;
			} else {
				int rNum = ran.nextInt(10);
				result += rNum + "";
			}
			count++;
		}
		return result;
	}

	// C
	public void createBooking(BookingRequestDto bookingDto) {
		Booking booking = new Booking(bookingDto);
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "INSERT INTO booking VALUES(?,?,?,?,?,?,?,?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, booking.getVehicleId());
				this.pstmt.setString(2, booking.getClientId());
				this.pstmt.setString(3, booking.getVenueId());
				this.pstmt.setTimestamp(4, booking.getOpDate());
				this.pstmt.setInt(5, booking.getHour());
				this.pstmt.setInt(6, booking.getPay());
				this.pstmt.setTimestamp(7, booking.getRegDate());
				this.pstmt.setString(8, booking.getRevNum());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}

		}

	}

	// R
	public ArrayList<Booking> getBookingById(String clientId) {
		ArrayList<Booking> list = new ArrayList<>();

		this.conn = DBManager.getConnection();
		if (conn != null) {
			String sql = "SELECT * FROM booking WHERE client_id=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, clientId);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String vehicleId = this.rs.getString(1);
					String venueId = this.rs.getString(3);
					Timestamp opDate = this.rs.getTimestamp(4);
					int hour = this.rs.getInt(5);
					int pay = this.rs.getInt(6);
					Timestamp regDate = this.rs.getTimestamp(7);
					String revNum = this.rs.getString(8);

					Booking booking = new Booking(vehicleId, clientId, venueId, opDate, hour, pay, regDate, revNum);
					list.add(booking);
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	// U

	// D

}
