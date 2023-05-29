package com.feuji.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feuji.ecommerce.dto.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
	
	Seller findByMailIdAndPassword(String mailId,String password);
	
	Seller findSellerBySellerId(int sellerId);
	
	List<Seller> findAll();
	
	@Query(value="select city from `e-commerce`.seller_address",nativeQuery=true)
	List<String> getAllLoactions();
}
