package com.feuji.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feuji.ecommerce.dto.Admin;
import com.feuji.ecommerce.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired(required = true)
	AdminService adminService;
	
	@GetMapping("/loginadmin")
	public String login(@RequestParam String mailId,@RequestParam String password) {
		
		String admin = adminService.login(mailId, password);
		
		ObjectMapper objectMapper = new ObjectMapper();
	    String logindata = null;
	    try {
	    	logindata = objectMapper.writeValueAsString(admin);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    
	    return logindata;
	
	}
}
