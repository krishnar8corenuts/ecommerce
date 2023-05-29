package com.feuji.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feuji.ecommerce.dto.User;



public interface UserRepository extends JpaRepository<User, Integer> {
	User findByMailIdAndPassword(String mailId,String password);
	
	User findByUserId(int Userid);
//	User findByUserId(int userid);
}
