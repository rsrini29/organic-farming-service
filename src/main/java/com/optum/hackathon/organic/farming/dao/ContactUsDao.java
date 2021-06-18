package com.optum.hackathon.organic.farming.dao;

import java.util.List;

import com.optum.hackathon.organic.farming.data.ContactUsData;

public interface ContactUsDao {

	List<ContactUsData> getUserByContact(String contact);

	List<ContactUsData> getAllUsers();

	boolean createUser(ContactUsData userData);
}
