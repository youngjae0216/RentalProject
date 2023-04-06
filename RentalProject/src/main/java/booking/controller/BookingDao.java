package booking.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import booking.Booking;
import util.DBManager;


public class BookingDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BookingDao() {}
	private static BookingDao instance = new BookingDao();
	public static BookingDao getInstance() {
		return instance;
	}
	
	//C
	
	
	
	//R
	public ArrayList<Booking> getBookingById(String clientId) {
		ArrayList<Booking> list = new ArrayList<>();
		
		this.conn = DBManager.getConnection();
		if(conn != null) {
			String sql = "SELECT * FROM booking WHERE client_id=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, clientId);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					String vehicleId = this.rs.getString(1);
					String venueId =  this.rs.getString(3);
					Timestamp opDate =  this.rs.getTimestamp(4);
					int hour =  this.rs.getInt(5);
					int pay =  this.rs.getInt(6);
					Timestamp regDate =  this.rs.getTimestamp(7);
					String revNum =  this.rs.getString(8);
					
					Booking booking = new Booking(vehicleId,clientId,venueId,opDate,hour,pay,regDate,revNum);
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
	
	
	//U
	
	
	
	//D
	
	
	
}

