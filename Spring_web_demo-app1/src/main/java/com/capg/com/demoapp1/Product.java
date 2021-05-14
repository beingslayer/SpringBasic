package com.capg.com.demoapp1;

import org.springframework.stereotype.Component;

@Component
public class Product {

	private int productId;
	private String productName;
	private int productCost;
	private int rating;
	private String availabel;
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName, int productCost, int rating,String availability) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.rating=rating;
		this.availabel=availability;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + 
				", productCost=" + productCost
				+ "]";
	}
	public String getAvailable() {
		return availabel;
	}
	public void setAvailable(String availabel) {
		this.availabel = availabel;
	}
	
	
	
}
