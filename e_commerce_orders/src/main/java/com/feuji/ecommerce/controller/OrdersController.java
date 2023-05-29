package com.feuji.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import com.feuji.ecommerce.dto.Order;
import com.feuji.ecommerce.dto.Product;
import com.feuji.ecommerce.dto.ProductOrder;
import com.feuji.ecommerce.dto.UserAddress;
import com.feuji.ecommerce.service.CartService;
import com.feuji.ecommerce.service.OrdersService;



@RestController
@RequestMapping(value = "/order")
public class OrdersController {
	
	@Autowired
	 private OrdersService ordersService;
	@Autowired
	private CartService cartService;

	@GetMapping("/getAllSellerOrders")
	public ResponseEntity<List<ProductOrder>> findAllOrders(@RequestParam int sellerId){
		
		List<ProductOrder> list = ordersService.findAllOrders(sellerId);
		return ResponseEntity.ok().body(list);
	}

	
	@PostMapping(value="/saveOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	public String  saveOrders(@RequestParam int userId,@RequestParam int deleteCart,@RequestBody List<ProductOrder> productList)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String result = null;
	    String saveOrder = ordersService.saveOrders(userId,productList);
		
		if(deleteCart == 2) {
		cartService.deleteCartWhenOrderPlaced(userId);
		}
		
		
		
		try {
			result=objectMapper.writeValueAsString(saveOrder);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
		return result;
	}
	
			
	
	@DeleteMapping("/deleteOrder")
	public ResponseEntity<String> deleteOrder(@RequestParam int orderId)
	{
		ordersService.deleteOrder(orderId);
		return ResponseEntity.ok().body("Order Deleted......");
	}
	
	
	
	@GetMapping("/vieworders")
	public ResponseEntity<List<ProductOrder>> viewOrders(@RequestParam int userId) {
		List<ProductOrder> orderList =  ordersService.viewOrders(userId);
		return ResponseEntity.ok(orderList);
	}
	
	//this method is used for remove the cart based in product id.
		@GetMapping("/findorderbyproductid")
		public void findOrderByProductId(@RequestParam int productId) {
			ordersService.deleteOrderByProductId(productId);
		}
		
		@GetMapping("/payment")
		public String payment() {
			
			ObjectMapper objectMapper = new ObjectMapper();
			String result=null;
			String value = ordersService.payment();
			
			
			try {
				result=objectMapper.writeValueAsString(value);
		    } catch (JsonProcessingException e) {
		        e.printStackTrace();
		    }
			return result;
		}
}
