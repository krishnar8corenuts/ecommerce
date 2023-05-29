package com.feuji.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feuji.ecommerce.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByMailIdAndPassword(String mailId,String password);
}
