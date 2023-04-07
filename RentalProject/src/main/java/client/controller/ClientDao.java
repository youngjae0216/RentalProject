package client.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import client.Client;
import client.ClientRequestDto;
import util.DBManager;


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
	public void createClient(ClientRequestDto clientDto) {
		Client client = new Client(clientDto);
		
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "INSERT INTO client VALUES(?,?,?,?)";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, client.getClientId());
				this.pstmt.setString(2, client.getPassword());
				this.pstmt.setString(3, client.getName());
				this.pstmt.setTimestamp(4, client.getDate());
				
				this.pstmt.execute();
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
	
	
	//R
	public Client getClientById(String clientId) {
		Client client = null;
		
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM client WHERE client_id=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, clientId);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					String password = this.rs.getString(2);
					String name = this.rs.getString(3);
					Timestamp date = this.rs.getTimestamp(4);
					
					client = new Client(clientId, password, name, date);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
		}
		return client;
	}
	
	
	//U
	
	
	
	//D
	
	
	
}
