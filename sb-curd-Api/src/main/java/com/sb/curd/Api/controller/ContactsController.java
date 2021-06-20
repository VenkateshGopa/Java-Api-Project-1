package com.sb.curd.Api.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sb.curd.Api.model.contact;
import com.sb.curd.Api.service.ContactsService;
@RestController
public class ContactsController {

	@Autowired
	ContactsService service;
	
	@GetMapping("/contacts")
	public List<Map<String, Object>> getallcontacts(){
		return service.getall();
	}
	
	@PostMapping("/contact")
	public String addContact(@RequestBody contact con)
	{
		return service.addcontact(con);
	}
	
	@PutMapping("/contact")
	public String updateContact(@RequestBody contact con)
	{
		return service.updatecontact(con);
	}
	
	@DeleteMapping("/contact/{name}")
	public String deleteContact(@PathVariable("name") String name)
	{
		return service.deletecontact(name);
	}
}
