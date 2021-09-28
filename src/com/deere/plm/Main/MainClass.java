package com.deere.plm.Main;

import java.util.Scanner;

import com.deere.plm.Exceptions.InvalidProductIdException;
import com.deere.plm.Model.Product;
import com.deere.plm.Services.ProductServices;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ProductServices ps = new ProductServices();
		
		System.out.println("Welcome to PLM!!!");
		
		while(true){
			System.out.print("--------------------------\n|Menu \t\t\t |\n--------------------------");
			System.out.print("\n1.Add Product\n2.Delete Product\n3.Modify product\n4.View Product\n\nSelect option >> ");
			String option=sc.next();
			
			switch(option){
			
				case "1":
						System.out.println("Enter Product name >> ");
						String name=sc.next();
						System.out.println("Enter Product description >> ");
						String description =sc.next();
						boolean status = ps.addProduct(new Product(name,description));
						if(status){
							System.out.println(">> Product Added");
						}
						else
						{
							System.out.println(">> Failure in Adding");
						}
					break;
				case "2":
						System.out.print("Enter Product ID >>  ");
						String id =sc.next();
						try {
							status = ps.deleteProduct(id);
							if(status){
								System.out.println(">> Product Deleted");
							}
							else
							{
								System.out.println(">> Failure in Delete");
							}
						} catch (InvalidProductIdException e) {
							System.out.println(e.getMessage());
							System.out.println(">> append Zeros in case Product id is short");
						}
					break;
				case "3":
						System.out.print("Enter Product ID >>  ");
						id =sc.next();
						if(ps.validateId(id)){
							System.out.print("Enter Product Name (Enter NA to skipp) >>  ");
							name =sc.next();
							System.out.print("Enter Product Description (Enter NA to skipp) >>  ");
							description = sc.next();
								try 
								{
									status = ps.modifyProduct(id,name,description);
									if(status){
										System.out.println(">> Modified Successfully");
									}
									else
									{
										System.out.println(">> Failure in modification");
									}
								} catch (InvalidProductIdException e) {
									System.out.println(">> "+e.getMessage());
									System.out.println(">> append Zeros in case Product id is short");
								}
						}
						else
						{
							System.out.println(">> Product Id Invalid");
						}
						
					break;
				case "4":
						System.out.print("Enter Product ID >> ");
						id =sc.next();
						try {
							Product p = ps.viewProduct(id);
							if(p==null){
								System.out.println(">> Product Not Found");
							}
							else{
								System.out.println(">> "+p);
							}
						} catch (InvalidProductIdException e) {
							System.out.println(">> "+e.getMessage());
							System.out.println(">> append Zeros in case Product id is short");
						}
					break;
				default:
					if(!option.equals("exit"))
					System.out.println("\n>> Please select from 1 to 4 or exit to end \n");
					break;
			}
			if(option.equals("exit")){
				System.out.println("\nThankyou....");
				break;
			}
			
		}
	}

}
