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
import com.feuji.ecommerce.dto.Cart;
import com.feuji.ecommerce.dto.CartProduct;
import com.feuji.ecommerce.dto.Product;
import com.feuji.ecommerce.service.CartService;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
	
	@Autowired
	CartService cartService;

	@GetMapping("/findCart")
	public ResponseEntity<List<Cart>> findCart(){
		
		List<Cart> list = cartService.findAllCarts();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/saveCart")
	public String  saveCart(@RequestParam int productId,int userId,int quantity,String size)
	{	
		String saved = cartService.saveCart(productId,userId,quantity,size);
		ObjectMapper objectMapper = new ObjectMapper();
	    String json = null;
	    try {
	        json = objectMapper.writeValueAsString(saved);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    
	    return json;
		
	}
	

	
	@DeleteMapping("/removefromcart")
	public String deleteCart(@RequestParam int userId,@RequestParam int productId,@RequestParam String size)
	{
		
		String logindata = cartService.deleteCart(userId, productId, size);
		ObjectMapper objectMapper = new ObjectMapper();
	    String json = null;
	    try {
	        json = objectMapper.writeValueAsString(logindata);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    
	    return json;
	
	}
	
	@GetMapping(value="/findCartbyuserid")
	public ResponseEntity<List<Product>> findCarttByUserId(@RequestParam int userId)
	{
		return ResponseEntity.ok(cartService.findCartByUserId(userId));
	}
	

	
	@GetMapping("/cartproduct")
	public ResponseEntity<List<CartProduct>> findCartProduct(@RequestParam int userId) {
		List<CartProduct>  cartProductList=  cartService.findCartProductByUserId(userId);
		return ResponseEntity.ok(cartProductList);
	}
	
//	@GetMapping("/payments")
//	public ResponseEntity<String> payment(@RequestParam int userId) {
//		String result = cartService.payment();
//		if(result.equals("Payment Successful")) {
//			cartService.deleteCartWhenOrderPlaced(userId);
//		}
//		return ResponseEntity.ok(result);
//	}
	
	//this method is used for remove the cart based in product id.
		@GetMapping("/findcartbyproductid")
		public void findCartByProductId(@RequestParam int productId) {
		   cartService.deleteCartByProductId(productId);
		}
	
	
}

