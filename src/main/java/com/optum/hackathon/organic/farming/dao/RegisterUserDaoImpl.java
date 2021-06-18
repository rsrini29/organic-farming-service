package com.optum.hackathon.organic.farming.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.optum.hackathon.organic.farming.data.RegisterUsersData;


@Component
public class RegisterUserDaoImpl implements RegisterUsersDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_USER     = "select * from ORGF_REGISTER_USER where user_contact = ?";
	private final String SQL_GET_ALL       = "select * from ORGF_REGISTER_USER";
	private final String SQL_INSERT_USER   = "insert into ORGF_REGISTER_USER(user_name, user_contact, user_address,user_pincode,user_city,user_email,user_password,user_fullname) values(?,?,?,?,?,?,?,?)";

	@Override
	public List<RegisterUsersData> getUserByContact(String mobNum) {
		 return jdbcTemplate.query(
				 SQL_FIND_USER,
	                new Object[]{"%" + mobNum + "%"},
	                (rs, rowNum) ->
	                        new RegisterUsersData(
	                        		 rs.getString("name"),
	                                 rs.getString("mobNum"),
	                                 rs.getString("address"),
	                                 rs.getString("pin"),
	                                 rs.getString("city"),
	                                 rs.getString("email"),
	                                 rs.getString("password"),
	                                 rs.getString("comName")
	                        )
	        );
	}

	@Override
    public List<RegisterUsersData> getAllUsers() {
        return jdbcTemplate.query(
        		SQL_GET_ALL,
                (rs, rowNum) ->
        		  new RegisterUsersData(
                 		 rs.getString("name"),
                          rs.getString("mobNum"),
                          rs.getString("address"),
                          rs.getString("pin"),
                          rs.getString("city"),
                          rs.getString("email"),
                          rs.getString("password"),
                          rs.getString("comName")
                 )
        );
	}
      
	@Override
  	public boolean createUser(RegisterUsersData user) {
		return jdbcTemplate.update(SQL_INSERT_USER,user.getName(), user.getMobNum(),user.getAddress(),user.getPin(),
				user.getCity(),user.getEmail(),user.getPassword(),user.getComName()) > 0;
	}
}
