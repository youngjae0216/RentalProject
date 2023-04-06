package vehicle;

import java.sql.Timestamp;

public class Vehicle {
	String vehicleId,name,venueId;
	Timestamp date;
	
	public Vehicle(String vehicleId, String name,String venueId, Timestamp date) {
		this.vehicleId = vehicleId;
		this.name = name;
		this.venueId = venueId;
		this.date = date;
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
