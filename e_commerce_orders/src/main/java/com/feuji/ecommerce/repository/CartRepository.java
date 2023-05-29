package com.feuji.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feuji.ecommerce.dto.Cart;
import com.feuji.ecommerce.dto.Product;


public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	@Query(value="select product_id from `e-commerce`.cart where user_id =:userId",nativeQuery =true)
	List<Integer> findProductIdByUserId(int userId);
	
	@Query(value="select * from `e-commerce`.cart where user_id=:userId and product_id=:productId",nativeQuery = true)
	Cart findByUserIdAndProductId(int userId,int productId);
	
	@Query(value="select * from `e-commerce`.cart where user_id =:userId",nativeQuery =true)
	List<Cart> findCartProductIdByUserId(int userId);
	
	@Query(value="select * from `e-commerce`.cart where (user_id =:userId and product_id=:productId) and size=:productSize ",nativeQuery = true)
	Cart findCartBasedOnIdAndSize(int userId,int productId,String productSize);
	
	@Query(value="select * from `e-commerce`.cart where product_id=:productId",nativeQuery = true)
	List<Cart> findCartByProductId(int productId);
}
