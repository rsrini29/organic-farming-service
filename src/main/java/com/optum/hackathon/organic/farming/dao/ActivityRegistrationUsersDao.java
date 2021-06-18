package com.optum.hackathon.organic.farming.dao;

import java.util.List;

import com.optum.hackathon.organic.farming.data.ActivityRegistrationUsersData;

public interface ActivityRegistrationUsersDao {

	List<ActivityRegistrationUsersData> getUserActivityByContact(String contact);

	List<ActivityRegistrationUsersData> getAllUsersActivities();

	boolean createUserActivity(ActivityRegistrationUsersData userData);
}
