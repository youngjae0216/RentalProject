package client.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ClientDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private ClientDao() {}
	private static ClientDao instance = new ClientDao();
	public static ClientDao getInstance() {
		return instance;
	}
	
	//C
	
	
	
	//R
	
	
	
	//U
	
	
	
	//D
	
	
	
}
