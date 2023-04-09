package booking;

import java.sql.Timestamp;

public class BookingRequestDto {
	private String vehicleId, clientId, venueId, revNum;
	private Timestamp opDate, regDate;
	private int hour, pay;

	public BookingRequestDto(String vehicleId, String clientId, String venueId, Timestamp opDate, int hour, int pay, Timestamp regDate, String revNum) {
			this.vehicleId = vehicleId;
			this.clientId = clientId;
			this.venueId = venueId;
			this.opDate = opDate;
			this.hour = hour;
			this.pay = pay;
			this.regDate = new Timestamp(System.currentTimeMillis());
			this.revNum = revNum;
		}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getVenueId() {
		return venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public String getRevNum() {
		return revNum;
	}

	public void setRevNum(String revNum) {
		this.revNum = revNum;
	}

	public Timestamp getOpDate() {
		return opDate;
	}

	public void setOpDate(Timestamp opDate) {
		this.opDate = opDate;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
	
	
}
