package com.optum.hackathon.organic.farming.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.optum.hackathon.organic.farming.dao.ActivityRegistrationUsersDao;
import com.optum.hackathon.organic.farming.dao.ContactUsDao;
import com.optum.hackathon.organic.farming.dao.RegisterUsersDao;
import com.optum.hackathon.organic.farming.data.ActivityRegistrationUsersData;
import com.optum.hackathon.organic.farming.data.ContactUsData;
import com.optum.hackathon.organic.farming.data.FormerData;
import com.optum.hackathon.organic.farming.data.RegisterUsersData;

@RestController
public class OrganicFarmingServiceController {

	Logger logger = LoggerFactory.getLogger(OrganicFarmingServiceController.class);
	
	@Autowired
	private RegisterUsersDao registerUserDao;
	
	@Autowired
	private ContactUsDao contactUsDao;
	
	@Autowired
	private ActivityRegistrationUsersDao activityDao;

	@PostMapping(path = "/api/insertRegisterUser")
	public ResponseEntity<Boolean> insertRegisterUser(RegisterUsersData userData) {
		boolean response = registerUserDao.createUser(userData);
		logger.info("Registration data has been inerted for :{}", userData);
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/api/insertContactUs")
	public ResponseEntity<Boolean> insertContactUs(ContactUsData userData) {
		boolean response = contactUsDao.createUser(userData);
		logger.info("ContactUs data has been inerted for :{}", userData);
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/api/insertUserActivity")
	public ResponseEntity<Boolean> insertUserActivity(ActivityRegistrationUsersData actData) {
		boolean response = activityDao.createUserActivity(actData);
		logger.info("User Activity data has been inerted for :{}", actData);
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/api/getRegisterUser",method = RequestMethod.GET)
	public ResponseEntity<List<RegisterUsersData>> getRegisterUser(@RequestParam String contact) {
		List<RegisterUsersData> response = registerUserDao.getUserByContact(contact);
		logger.info("Fetching Register User Data->", contact);
		return new ResponseEntity<List<RegisterUsersData>>(response, HttpStatus.OK);
	}
	
		
	@RequestMapping(value="/api/getContactUs",method = RequestMethod.GET)
	public ResponseEntity<List<ContactUsData>> getContactUs(@RequestParam String contact) {
		List<ContactUsData> response = contactUsDao.getUserByContact(contact);
		logger.info("Fetching ContactUs Data->", contact);
		return new ResponseEntity<List<ContactUsData>>(response, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/api/getUserActivity",method = RequestMethod.GET)
	public ResponseEntity<List<ActivityRegistrationUsersData>> getUserActivity(@RequestParam String contact) {
		List<ActivityRegistrationUsersData> response = activityDao.getUserActivityByContact(contact);
		logger.info("Fetching Activity Data->", contact);
		return new ResponseEntity<List<ActivityRegistrationUsersData>>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/getAllRegisterUsers",method = RequestMethod.GET)
	public ResponseEntity<List<RegisterUsersData>> getAllRegisterUsers() {
		List<RegisterUsersData> response = registerUserDao.getAllUsers();
		logger.info("Fetching All Register Users Data-");
		return new ResponseEntity<List<RegisterUsersData>>(response, HttpStatus.OK);
	}
	
		
	@RequestMapping(value="/api/getAllContactUs",method = RequestMethod.GET)
	public ResponseEntity<List<ContactUsData>> getAllContactUs() {
		List<ContactUsData> response = contactUsDao.getAllUsers();
		logger.info("Fetching All ContactUs Data");
		return new ResponseEntity<List<ContactUsData>>(response, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/api/getAllUserActivities",method = RequestMethod.GET)
	public ResponseEntity<List<ActivityRegistrationUsersData>> getAllUserActivities() {
		List<ActivityRegistrationUsersData> response = activityDao.getAllUsersActivities();
		logger.info("Fetching All Activities Data");
		return new ResponseEntity<List<ActivityRegistrationUsersData>>(response, HttpStatus.OK);
	}
}
