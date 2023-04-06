package board;

import java.sql.Timestamp;

public class BoardRequestDto {
	private String postno, clientId, title, content;
	private Timestamp modDate,date;
	
	public BoardRequestDto(String postno, String clientId, String title, String content, Timestamp modDate, Timestamp date) {
		this.postno = postno;
		this.clientId = clientId;
		this.title = title;
		this.content = content;
		this.modDate = modDate;
		this.date = date;
	}

	public String getPostno() {
		return postno;
	}

	public void setPostno(String postno) {
		this.postno = postno;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getModDate() {
		return modDate;
	}

	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
