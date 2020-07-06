package com.chandra.spring;

public class Product {
	
	public int pid;
	public String productName;
	
     public Product()
     {
    	 System.out.println("Product Object Created");
     }

/*	//constructor Injection
	public Product(int pid,String productName) {
		this.pid=pid;
		this.productName = productName;
	}
	*/
	
	//setter Injection
    public void setPid(int pid) {
		this.pid = pid;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public void productDetails()
	{
		System.out.println("Product Id  : "+pid);
		System.out.println("Product Name : "+productName);
	}

}
