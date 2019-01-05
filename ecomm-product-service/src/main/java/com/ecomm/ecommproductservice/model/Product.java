package com.ecomm.ecommproductservice.model;

public class Product {

private Integer productId;
	
	private String  productCode;
	private String productName;
	private String productDesc;
	private float price;
	private int unitsInStock;
	private String productCatalog;
	
	public Product(Integer productId, String productCode, String productName, String productDesc, float price,
			int unitsInStock, String productCatalog) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.productDesc = productDesc;
		this.price = price;
		this.unitsInStock = unitsInStock;
		this.productCatalog = productCatalog;
	}
	
	public Product(Product product) {
		
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getProductCatalog() {
		return productCatalog;
	}
	public void setProductCatalog(String productCatalog) {
		this.productCatalog = productCatalog;
	}
	
}
