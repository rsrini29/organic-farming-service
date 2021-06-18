package com.optum.hackathon.organic.farming.data;

import lombok.Data;

@Data
public class RegisterUsersData {

	private String name;
	private String mobNum;
	private String address;
	private String pin;
	private String city;
	private String password;
	private String email;
	private String comName;
	
	
	public RegisterUsersData(String name, String mobNum, String address, String pin, String city, String password,
			String email, String comName) {
		super();
		this.name = name;
		this.mobNum = mobNum;
		this.address = address;
		this.pin = pin;
		this.city = city;
		this.password = password;
		this.email = email;
		this.comName = comName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobNum() {
		return mobNum;
	}
	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	
	

	

}
