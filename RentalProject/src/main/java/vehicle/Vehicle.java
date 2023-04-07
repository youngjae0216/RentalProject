package vehicle;

import java.sql.Timestamp;

public class Vehicle {
	private String vehicleId,name,venueId;
	private Timestamp date;
	private int checkRev;
	
	public Vehicle(String vehicleId, String name,String venueId, Timestamp date, int checkRev) {
		this.vehicleId = vehicleId;
		this.name = name;
		this.venueId = venueId;
		this.date = date;
		this.checkRev = 0;
	}
	
	public int getCheckRev() {
		return checkRev;
	}

	public String getVehicleId() {
		return vehicleId;
	}
	public String getName() {
		return name;
	}
	public String getVenueId() {
		return venueId;
	}
	public Timestamp getDate() {
		return date;
	}
	
}
