package com.optum.hackathon.organic.farming.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.optum.hackathon.organic.farming.data.ContactUsData;

@Component
public class ContactUsDaoImpl implements ContactUsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_USER     = "select * from ORGF_CONTACTUS where user_contact = ?";
	private final String SQL_GET_ALL       = "select * from ORGF_CONTACTUS";
	private final String SQL_INSERT_USER   = "insert into ORGF_CONTACTUS(user_name, user_contact,user_email,user_description ) values(?,?,?,?)";

	@Override
	public List<ContactUsData> getUserByContact(String mobNum) {
		 return jdbcTemplate.query(
				 SQL_FIND_USER,
	                new Object[]{"%" + mobNum + "%"},
	                (rs, rowNum) ->
	                        new ContactUsData(
	                        		 rs.getString("name"),
	                                 rs.getString("contact"),
	                                 rs.getString("email"),
	                                 rs.getString("description")
	                               )
	        );
	}

	@Override
    public List<ContactUsData> getAllUsers() {
        return jdbcTemplate.query(
        		SQL_GET_ALL,
                (rs, rowNum) ->
        		new ContactUsData(
               		 rs.getString("name"),
                        rs.getString("contact"),
                        rs.getString("email"),
                        rs.getString("description")
                      )
        );
	}
      
	@Override
  	public boolean createUser(ContactUsData user) {
		return jdbcTemplate.update(SQL_INSERT_USER,user.getName(),user.getContact(),user.getEmail(),user.getDescription()) > 0;
	}
}
