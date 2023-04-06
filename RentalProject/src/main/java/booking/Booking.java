package booking;

import java.sql.Timestamp;

public class Booking {
	private String vehicleId,clientId,venueId,revNum;
	private Timestamp opDate,regDate;
	private int hour, pay;
	
	public Booking(String vehicleId, String clientId, String venueId, Timestamp opDate, int hour, int pay, Timestamp regDate, String revNum) {
		this.vehicleId = vehicleId;
		this.clientId = clientId;
		this.venueId = venueId;
		this.opDate = opDate;
		this.hour = hour;
		this.pay = pay;
		this.regDate = regDate;
		this.revNum = revNum;
	}
	
	public Booking(BookingRequestDto bookingDto) {
		this.vehicleId = bookingDto.getVehicleId();
		this.clientId = bookingDto.getClientId();
		this.venueId = bookingDto.getVenueId();
		this.opDate = bookingDto.getOpDate();
		this.hour = bookingDto.getHour();
		this.pay = bookingDto.getPay();
		this.regDate = bookingDto.getRegDate();
		this.revNum = bookingDto.getRevNum();
		
	}
	
	
	
	public String getVehicleId() {
		return vehicleId;
	}
	public String getClientId() {
		return clientId;
	}
	public String getVenueId() {
		return venueId;
	}
	public String getRevNum() {
		return revNum;
	}
	public Timestamp getOpDate() {
		return opDate;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public int getHour() {
		return hour;
	}
	public int getPay() {
		return pay;
	}
	
	
}
