package board;

import java.sql.Timestamp;

public class Board {
	private String postno, clientId, title, content;
	private Timestamp modDate,date;
	
	public Board(String postno, String clientId, String title, String content, Timestamp modDate, Timestamp date) {
		this.postno = postno;
		this.clientId = clientId;
		this.title = title;
		this.content = content;
		this.modDate = modDate;
		this.date = date;
	}
	
	public Board(BoardRequestDto boardDto) {
		this.postno = boardDto.getPostno();
		this.clientId = boardDto.getClientId();
		this.title = boardDto.getTitle();
		this.content = boardDto.getContent();
		this.modDate = boardDto.getModDate();
		this.date = boardDto.getDate();
	}

	public String getPostno() {
		return postno;
	}

	public String getClientId() {
		return clientId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getModDate() {
		return modDate;
	}

	public Timestamp getDate() {
		return date;
	}
	
	
}
