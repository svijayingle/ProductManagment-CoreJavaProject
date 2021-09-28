package com.deere.plm.Services;
import java.util.ArrayList;
import java.util.Iterator;

import com.deere.plm.Exceptions.InvalidProductIdException;
import com.deere.plm.Model.Product;

public class ProductServices {
	
	ArrayList<Product> productList;
	
	public ProductServices() {
		productList = new ArrayList<Product>();
	}
	
	public boolean addProduct(Product product){
		Iterator<Product> i = productList.iterator();
		while(i.hasNext()){
			Product p = i.next();
			if(p.getProductId().equals(product.getProductId())){
				return false;
			}
		}
		return productList.add(product);
	}
	
	public boolean deleteProduct(String productId) throws InvalidProductIdException{
		if(!validateId(productId)){
			throw new InvalidProductIdException("Invalid Id");
		}
		Iterator<Product> i = productList.iterator();
		while(i.hasNext()){
			Product p = i.next();
			if(p.getProductId().equals(productId)){
				i.remove();
				return true;
			}
		}
		return false;
	}
	
	public Product viewProduct(String productId) throws InvalidProductIdException{
		if(!validateId(productId)){
			throw new InvalidProductIdException("Invalid Id");
		}
		Iterator<Product> i = productList.iterator();
		while(i.hasNext()){
			Product p = i.next();
			if(p.getProductId().equals(productId)){
				return p;
			}
		}
		return null;
	}
	
	public boolean modifyProduct(String productId, String productName, String productDescription) throws InvalidProductIdException{
		if(!validateId(productId)){
			throw new InvalidProductIdException("Invalid Id");
		}
		Iterator<Product> i = productList.iterator();
		while(i.hasNext()){
			Product p = i.next();
			if(p.getProductId().equals(productId)){
				System.out.println("Product Found");
				if(!productName.equals("NA")){
					p.setProductName(productName);
					p.setProductId("PLM"+productName.substring(0,3));
				}
				if(!productDescription.equals("NA")){
					p.setProductDescription(productDescription);
				}
				
				return true;
			}
		}
		return false;
	}
	
	public boolean validateId(String Id){
		
		if(Id.length()==6){
			if(!Id.substring(0,3).equals("PLM")){
				return false;
			}
		}
		else{
			return false;
		}
		
		return true;
		
	}

}
