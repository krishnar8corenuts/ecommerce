package com.feuji.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.feuji.ecommerce.dto.Order;

public interface OrdersReposotory extends JpaRepository<Order, Integer> {

//	@Query("SELECT o FROM Order o WHERE o.userId = :userid")
	List<Order> findOrderByUserId(int userid);
	
	@Query(value="select * from `e-commerce`.ecom_order where product_id=:productId",nativeQuery = true)
	List<Order> findOrderByProductId(int productId);
}
