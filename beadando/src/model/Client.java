package model;

import javax.persistence.*;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Client.getAll", query = "Select e from Client e") })
public class Client {
	@Id
	@Column
	private String clientID;
	@Column
	private String name;
	@Column
	private String phonenumber;
	@Column
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phonenumber;
	}

	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public Client(String clientID, String name, String phonenumber, String address) {
		this.clientID = clientID;
		this.name = name;
		this.phonenumber = phonenumber;
		this.address = address;
	}

	public Client() {
	}
}