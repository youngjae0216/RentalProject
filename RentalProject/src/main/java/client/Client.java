package client;

import java.sql.Timestamp;

public class Client {
	private String clientId, password, name;
	private Timestamp date;

	public Client(String clientId, String password, String name, Timestamp date) {
		this.clientId = clientId;
		this.password = password;
		this.name = name;
		this.date = date;
	}
	
	public Client(ClientRequestDto clientDto) {
		this.clientId = clientDto.getClientId();
		this.password = clientDto.getPassword();
		this.name = clientDto.getName();
		this.date = clientDto.getDate();
	}

	public String getClientId() {
		return clientId;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public Timestamp getDate() {
		return date;
	}
	
	
}
