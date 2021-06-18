package com.optum.hackathon.organic.farming.data;

import lombok.Data;

@Data
public class ActivityRegistrationUsersData {

	private String location;
	private String date;
	private String[] activites;
	private String mobileNum;
	private String activitesStr;
	
	public ActivityRegistrationUsersData(String location, String date, String activitesStr, String mobileNum) {
		super();
		this.location = location;
		this.date = date;
		this.activitesStr = activitesStr;
		this.mobileNum = mobileNum;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String[] getActivites() {
		return activites;
	}
	public void setActivites(String[] activites) {
		this.activites = activites;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	
	public String getActivitesStr() {
		return activitesStr;
	}

	public void setActivitesStr(String activitesStr) {
		this.activitesStr = activitesStr;
	}
	
	

}
