package com.feuji.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feuji.ecommerce.dto.Seller;
import com.feuji.ecommerce.dto.SellerAddress;
import com.feuji.ecommerce.dto.SellerRegisterAddress;
import com.feuji.ecommerce.service.SellerService;

@RestController
@RequestMapping(value = "/seller")
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
	@PostMapping("/saveSeller")
	public Seller saveUser(@RequestBody SellerRegisterAddress sellerAddress) {
		
		
		Seller seller=sellerService.saveSeller(sellerAddress);
		
		return seller;

		
	}
	@DeleteMapping("/deleteseller")
	public String deleteSeller(@RequestParam int sellerId) {
		
		sellerService.deleteSeller(sellerId);
		
		String logindata = "deleted";
		ObjectMapper objectMapper = new ObjectMapper();
	    String json = null;
	    try {
	        json = objectMapper.writeValueAsString(logindata);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    
	    return json;
	}
	
	
	@GetMapping("/login")
	public byte[] login(@RequestParam String mailId,@RequestParam String password) {
		int logindata = sellerService.login(mailId, password);
		ObjectMapper objectMapper = new ObjectMapper();
	    byte[] json = null;
	    try {
	        json = objectMapper.writeValueAsBytes(logindata);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    
	    return json;
	}
	
	@PostMapping("/addAddress")
	public void addAddress(@RequestBody SellerAddress address) {
		sellerService.addAddress(address);
	}

	@GetMapping("/findallsellers")
	public List<Seller> findAllSellers() {
		return sellerService.getAllSellers();
		
	}
	
	@GetMapping("/getalllocations")
	public ResponseEntity<List<String>> getAllLocations()
	{
		List<String>  locations= sellerService.getAllLocations();
		return ResponseEntity.ok().body(locations);
	}
}
