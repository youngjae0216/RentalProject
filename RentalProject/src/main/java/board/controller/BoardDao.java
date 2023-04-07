package board.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import board.Board;
import board.BoardRequestDto;
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
	public void createBoard(BoardRequestDto boardDto) {
		Board board = new Board(boardDto);
		
		this.conn = DBManager.getConnection();
		if(conn != null) {
			String sql = "INSERT INTO board VALUES(?,?,?,?,?,?)";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, board.getPostno());
				this.pstmt.setString(2, board.getClientId());
				this.pstmt.setString(3, board.getTitle());
				this.pstmt.setString(4, board.getContent());
				this.pstmt.setTimestamp(5, board.getModDate());
				this.pstmt.setTimestamp(6, board.getDate());
				
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
	
	public String getPostnoMax() {
		int postno = 1;

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT MAX(postno) FROM board";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				this.rs.next();
				postno = this.rs.getInt(1);

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return postno+1+"";
	}
	
	public Board getBoardByPostno(String postno) {
		Board board = null;
		this.conn = DBManager.getConnection();
		if(conn != null) {
			String sql = "SELECT * FROM board WHERE postno=?";
			
			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setString(1, postno);
				this.rs = pstmt.executeQuery();
				
				while(this.rs.next()) {
					String clientId = this.rs.getString(2);
					String title = this.rs.getString(3);
					String content = this.rs.getString(4);
					Timestamp modDate = this.rs.getTimestamp(5);
					Timestamp date = this.rs.getTimestamp(6);
					
					board = new Board(postno, clientId, title, content, modDate,date);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return board;
	}
	
	
	
	//U
	
	
	
	//D
	
	
	
}
