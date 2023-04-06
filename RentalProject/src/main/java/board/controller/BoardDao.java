package board.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import board.Board;
import util.DBManager;


public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BoardDao() {}
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	
	//C
	
	
	
	//R
	public ArrayList<Board> getBoardAll() {
		ArrayList<Board> list = new ArrayList<>();
		this.conn = DBManager.getConnection();
		
		if(conn != null) {
			String sql = "SELECT * FROM board";
				
			try {	
				this.pstmt = conn.prepareStatement(sql);
				this.rs = pstmt.executeQuery();
				
				while(this.rs.next()) {
					String postno = this.rs.getString(1);
					String clientId = this.rs.getString(2);
					String title = this.rs.getString(3);
					String content = this.rs.getString(4);
					Timestamp modDate = this.rs.getTimestamp(5);
					Timestamp date = this.rs.getTimestamp(6);
					
					Board board = new Board(postno,clientId,title,content,modDate,date);
					list.add(board);
					
				}
				
				
			} catch (SQLException e) {
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
