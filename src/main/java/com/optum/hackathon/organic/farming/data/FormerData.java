package com.optum.hackathon.organic.farming.data;

import lombok.Data;

@Data
public class FormerData {

	private String formerName;
	private String address;
	private String formingType;
	
	public String getFormerName() {
		return formerName;
	}
	public void setFormerName(String formerName) {
		this.formerName = formerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFormingType() {
		return formingType;
	}
	public void setFormingType(String formingType) {
		this.formingType = formingType;
	}

}
