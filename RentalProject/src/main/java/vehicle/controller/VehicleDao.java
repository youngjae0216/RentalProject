package vehicle.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.DBManager;
import vehicle.Vehicle;


public class VehicleDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private VehicleDao() {}
	private static VehicleDao instance = new VehicleDao();
	public static VehicleDao getInstance() {
		return instance;
	}
	
	//C
	
	
	
	//R
	public ArrayList<Vehicle> getVehicleAll(){
		ArrayList<Vehicle> list = new ArrayList<>();
		this.conn = DBManager.getConnection();
		if(conn != null) {
			String sql = "SELECT * FROM vehicle";
			
			try {
				this.pstmt = conn.prepareStatement(sql);
				this.rs = pstmt.executeQuery();
				
				while(this.rs.next()) {
					String vehicleId = this.rs.getString(1);
					String name = this.rs.getString(2);
					String venueId = this.rs.getString(3);
					Timestamp date = this.rs.getTimestamp(4);
					
					Vehicle vehicle = new Vehicle(vehicleId,name,venueId,date);
					list.add(vehicle);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		
		
		
		return list;
	}
	
	public ArrayList<Vehicle> getVehicleNameNoneReservation(){
		ArrayList<Vehicle> list = new ArrayList<>();
		
		
		
		return list;
	}
	
	
	
	//U
	
	
	
	//D
	
	
	
}
