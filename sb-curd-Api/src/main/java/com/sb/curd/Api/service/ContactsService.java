package com.sb.curd.Api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sb.curd.Api.model.contact;
@Service
public class ContactsService {
	@Autowired
	JdbcTemplate jdbc;
	
	private final String getall ="SELECT * FROM CONTACT";
	private final String insert ="INSERT INTO CONTACT"
			+ " ( name, country_code, mobile_number, country_name,emailid) values (?,?,?,?,?)"; 
	private final String update ="update CONTACT SET "
			+ " country_code=?, mobile_number=?, country_name=?,emailid=? where name=?"; 
	private final String delete ="delete FROM CONTACT Where name= ?";
	public List<Map<String, Object>> getall() {
		return jdbc.queryForList(getall);
	}

	public String addcontact(contact con) {
		if(jdbc.update(insert,con.getName(),con.getCountry_code(),con.getMobile_number(),con.getCountry_name(),con.getEmailid())>0)
			return "succesfully added";
		else
			return "error occured";
	}

	public String updatecontact(contact con) {
		if(jdbc.update(update,con.getCountry_code(),con.getMobile_number(),con.getCountry_name(),con.getEmailid(),con.getName())>0)
			return "succesfully Updated";
		else
			return "error occured";
	}

	public String deletecontact(String name) {
		if(jdbc.update(delete,name)>0)
			return "succesfully deleted";
		else
			return "Contact not existed with this name";
	}
	
	
}
