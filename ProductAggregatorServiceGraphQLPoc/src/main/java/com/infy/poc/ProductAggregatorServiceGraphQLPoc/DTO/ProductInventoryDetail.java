package com.infy.poc.ProductAggregatorServiceGraphQLPoc.DTO;

public class ProductInventoryDetail {
	private int productID;
	private String productName;
	//private String productDescription;
	private int productInventory;

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

	/*
	 * public String getProductDescription() { return productDescription; } public
	 * void setProductDescription(String productDescription) {
	 * this.productDescription = productDescription; }
	 */
	public int getProductInventory() {
		return productInventory;
	}
	public void setProductInventory(int productInventory) {
		this.productInventory = productInventory;
	}
	@Override
	public String toString() {
		return "ProductInventoryDetail [productID=" + productID + ", productName=" + productName
				+  ", productInventory=" + productInventory + "]";
	}
	
}
