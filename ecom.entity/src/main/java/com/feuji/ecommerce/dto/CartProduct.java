package com.feuji.ecommerce.dto;



public class CartProduct {
	
	private int cartId;
	private int cartNumber;
	private int userId;
	private int productId;
	private int orderQuantity;
	private String productSize;
	//private Product product;
	 private String productName;
	 private double price;
	 private double finalPrice;
	 private double totalPrice;
	 private String discription;
	 private int productQuantity;
	 private String category;
	 private String productImage;
	 private Seller seller;

	
	public CartProduct() {
		super();
	}




	public CartProduct(int cartId, int cartNumber, int userId, int productId, int orderQuantity, String productSize,
			String productName, double price, double finalPrice, double totalPrice, String discription,
			int productQuantity, String category, String productImage, Seller seller) {
		super();
		this.cartId = cartId;
		this.cartNumber = cartNumber;
		this.userId = userId;
		this.productId = productId;
		this.orderQuantity = orderQuantity;
		this.productSize = productSize;
		this.productName = productName;
		this.price = price;
		this.finalPrice = finalPrice;
		this.totalPrice = totalPrice;
		this.discription = discription;
		this.productQuantity = productQuantity;
		this.category = category;
		this.productImage = productImage;
		this.seller = seller;
	}




	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public int getCartNumber() {
		return cartNumber;
	}


	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getOrderQuantity() {
		return orderQuantity;
	}


	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}


	public String getProductSize() {
		return productSize;
	}


	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getFinalPrice() {
		return finalPrice;
	}


	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}


	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String discription) {
		this.discription = discription;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getProductImage() {
		return productImage;
	}


	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}


	public Seller getSeller() {
		return seller;
	}


	public void setSeller(Seller seller) {
		this.seller = seller;
	}


	public double getTotalPrice() {
		return totalPrice;
	}




	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}




	@Override
	public String toString() {
		return "CartProduct [cartId=" + cartId + ", cartNumber=" + cartNumber + ", userId=" + userId + ", productId="
				+ productId + ", orderQuantity=" + orderQuantity + ", productSize=" + productSize + ", productName="
				+ productName + ", price=" + price + ", finalPrice=" + finalPrice + ", totalPrice=" + totalPrice
				+ ", discription=" + discription + ", productQuantity=" + productQuantity + ", category=" + category
				+ ", productImage=" + productImage + ", seller=" + seller + "]";
	}




	
	
}
