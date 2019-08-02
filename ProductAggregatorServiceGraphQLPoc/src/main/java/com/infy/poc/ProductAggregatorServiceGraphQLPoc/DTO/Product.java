package com.infy.poc.ProductAggregatorServiceGraphQLPoc.DTO;

public class Product {

	private int productID;
	private String productName;
	private String productDescription;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Product() {
		super();
	}

	public Product(int productID, String productName, String productDescription) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productDescription="
				+ productDescription + "]";
	}

}
