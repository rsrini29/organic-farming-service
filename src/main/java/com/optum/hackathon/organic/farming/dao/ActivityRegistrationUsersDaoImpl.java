package com.optum.hackathon.organic.farming.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.optum.hackathon.organic.farming.data.ActivityRegistrationUsersData;



@Component
public class ActivityRegistrationUsersDaoImpl implements ActivityRegistrationUsersDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_USER_ACTIVITY    = "select * from ORGF_REGISTER_ACTVITY where act_location = ?";
	private final String SQL_GET_ALL          = "select * from  ORGF_REGISTER_ACTVITY";
	private final String SQL_INSERT_ACTVITY   = "insert into  ORGF_REGISTER_ACTVITY(act_location, act_date, user_actvities,user_contact) values(?,?,?,?)";

	@Override
	public List<ActivityRegistrationUsersData> getUserActivityByContact(String contact) {
		 return jdbcTemplate.query(
				 SQL_FIND_USER_ACTIVITY,
	                new Object[]{"%" + contact + "%"},
	                (rs, rowNum) ->
	                        new ActivityRegistrationUsersData(
	                        		 rs.getString("location"),
	                                 rs.getString("date"),
	                                 rs.getString("activites"),
	                                 rs.getString("mobileNum")
	                                
	                        )
	        );
	}

	@Override
    public List<ActivityRegistrationUsersData> getAllUsersActivities() {
        return jdbcTemplate.query(
        		SQL_GET_ALL,
                (rs, rowNum) ->
        		 new ActivityRegistrationUsersData(
                		 rs.getString("location"),
                         rs.getString("date"),
                         rs.getString("activites"),
                         rs.getString("mobileNum")
                        
                )
        );
	}
      
	@Override
  	public boolean createUserActivity(ActivityRegistrationUsersData act) {
		return jdbcTemplate.update(SQL_INSERT_ACTVITY, act.getLocation(),act.getDate(),act.getActivites().toString(),act.getMobileNum()) > 0;
	}
}
