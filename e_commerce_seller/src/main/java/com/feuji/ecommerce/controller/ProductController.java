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
import com.feuji.ecommerce.dto.Product;
import com.feuji.ecommerce.service.ProductService;


/**
 * @author rudra *
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductService productService;
	


	@GetMapping("/findProducts")
	public ResponseEntity<List<Product>> findAllProducts() {

		List<Product> list = productService.findAllProducts();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/saveProducts")
	public String saveProduct(@RequestBody Product product,@RequestParam int sellerId) {
		productService.addProduct(product,sellerId);		
		String logindata = "Products are added.....";
		ObjectMapper objectMapper = new ObjectMapper();
	    String json = null;
	    try {
	        json = objectMapper.writeValueAsString(logindata);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    
	    return json;
	}
	
	@PostMapping("/editproducts")
	public String editProduct(@RequestBody Product product,@RequestParam int sellerId) {
		productService.editProduct(product,sellerId);
		String logindata = "Product edited.....";
		ObjectMapper objectMapper = new ObjectMapper();
	    String json = null;
	    try {
	        json = objectMapper.writeValueAsString(logindata);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    
	    return json;
	}
	@GetMapping("/deleteProduct")
	public ResponseEntity<String> deleteProduct(@RequestParam int productId) {
		productService.deleteProduct(productId);
		return ResponseEntity.ok().body("Product Deleted......");
	}
	
	@GetMapping(value="/findproductbyid")
	public Product findProductById(@RequestParam int productId)
	{
		return productService.findProductById(productId);
	}
	
	@GetMapping("/findproductbysellerid")
	public ResponseEntity<List<Product>> findProductBySellerId(@RequestParam int sellerId) {
		List<Product> productList = productService.findProductsBySellerId(sellerId);
		return ResponseEntity.ok(productList);
	}
	

	@GetMapping("/findproductsbycity")
	public ResponseEntity<List<Product>> findProductsBasedOnLocation(@RequestParam String city) {
		List<Product> productList = productService.findProductsBasedOnLocation(city);
		System.err.println(productList);
		return ResponseEntity.ok(productList);
	}

}
