package com.optum.hackathon.organic.farming.data;

import lombok.Data;

@Data
public class ContactUsData {

	
	private String name;
	private String contact;
	private String email;
	private String description;
	
	public ContactUsData(String name, String contact, String email, String description) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
