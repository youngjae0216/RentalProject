package client;

import java.sql.Timestamp;

public class ClientRequestDto {
	private String clientId, password, name;
	private Timestamp date;

	public ClientRequestDto(String clientId, String password, String name, Timestamp date) {
		this.clientId = clientId;
		this.password = password;
		this.name = name;
		this.date = date;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
