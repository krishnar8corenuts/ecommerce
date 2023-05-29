package com.feuji.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.ecommerce.dto.Admin;
import com.feuji.ecommerce.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired(required = true)
	AdminRepository adminRepository;
	
	public  String login(String mailId,String Password) {
		Admin admin = adminRepository.findByMailIdAndPassword(mailId, Password);
		if(admin!=null) {
			 return "Admin found";
		 }
		 else {
			 return "Admin not found";
		 }
		
	}

}
