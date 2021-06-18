package com.optum.hackathon.organic.farming.dao;

import java.util.List;

import com.optum.hackathon.organic.farming.data.RegisterUsersData;

public interface RegisterUsersDao {

	List<RegisterUsersData> getUserByContact(String contact);

	List<RegisterUsersData> getAllUsers();

	boolean createUser(RegisterUsersData userData);
}
