package venue.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class VenueDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private VenueDao() {}
	private static VenueDao instance = new VenueDao();
	public static VenueDao getInstance() {
		return instance;
	}
	
	//C
	
	
	
	//R
	
	
	
	//U
	
	
	
	//D
	
	
	
}
