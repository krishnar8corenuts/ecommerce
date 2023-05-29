package com.feuji.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feuji.ecommerce.dto.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "select * from `e-commerce`.products where seller_id =:sellerId",nativeQuery = true)
	 List<Product> findProductsById(int sellerId);
	
	@Query(value = "select * from `e-commerce`.products where seller_id in "
	 		+ "(select seller_id from `e-commerce`.seller_address where city =:city)",nativeQuery=true)
	 List<Product> findBasedOnLocation(String city);
}
