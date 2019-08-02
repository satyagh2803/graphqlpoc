package com.infy.poc.ProductAggregatorServiceGraphQLPoc.DTO;

public class ProductInventory {
	private int productID;
	private int productInventory;

	public ProductInventory() {
		super();
	}

	public ProductInventory(int productID, int productInventory) {
		super();
		this.productID = productID;
		this.productInventory = productInventory;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(int productInventory) {
		this.productInventory = productInventory;
	}

	@Override
	public String toString() {
		return "ProductInventory [productID=" + productID + ", productInventory=" + productInventory + "]";
	}

}
