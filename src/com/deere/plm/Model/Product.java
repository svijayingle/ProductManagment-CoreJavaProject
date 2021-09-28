package com.deere.plm.Model;

public class Product implements Comparable<String>{
	
	private String productId;
	private String productName;
	private String productDescription;
	
	public Product(String productName, String productDescription) {
		super();
		if(productName.length()>2){
			this.productId = "PLM"+productName.substring(0,3);
		}
		else{
			int len = productName.length();
			this.productId = "PLM"+productName.substring(0,len);
			if(len==1){
				this.productId=this.productId+"00";
			}
			else{
				this.productId=this.productId+"0";
			}
			
		}
		this.productName = productName;
		this.productDescription = productDescription;
	}

	public Product(String productId, String productName, String productDescription) {
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		return productId + " " + productName + " "+ productDescription;
	}

	@Override
	public int compareTo(String o) {
		return this.productId.compareTo(o);
	}
	
	
}
