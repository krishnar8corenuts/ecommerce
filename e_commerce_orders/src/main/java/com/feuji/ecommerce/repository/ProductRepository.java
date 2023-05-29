package com.feuji.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feuji.ecommerce.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	@Query(value="select * from `e-commerce`.products p where p.product_id in "
			+ "(select product_id from `e-commerce`.cart where user_id=:userId)", nativeQuery = true)
	List<Product> findProductfromCart(int userId);
}
