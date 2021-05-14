package com.capg.com.demoapp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

// Manage Database

@Component
public class ProductDAOImpl {

	List<Product> list = new ArrayList<>();

	public ProductDAOImpl() {
		
		Product p1 = new Product(101, "HP-101",45000,1,"yes");
		Product p2 = new Product(102, "HP-102",15000,3,"yes");
		Product p3 = new Product(103, "HP-103",25000,4,"yes");
		Product p4 = new Product(104, "HP-104",20000,4,"yes");
		Product p5 = new Product(105, "HP-105",145000,5,"yes");
		
		list = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5));
	
	}
	
	public List<Product> getAllProducts()
	{
		return list;
	}
	
	public List<Product> getProductsByRange(int r1,int r2)
	{
		
		Comparator<Product> comp = (p1,p2)->p1.getProductCost() - p2.getProductCost();
		
		List<Product> productList = list.stream().
		filter((product)->product.getProductCost()>=r1&&product.getProductCost()<=r2).
		collect(Collectors.toList());
		
		return productList;
	}
	
	public Product getProductById(int searchid)
	{
		boolean isIdFound = false;
		Product searchedProduct = null;
		for (Product product : list) {
			if(product.getProductId() == searchid)
			{
				isIdFound = true;
				searchedProduct = product;
				break;
			}
		}
		return searchedProduct;
	}
	public List<Product> getProductsByRating(int r1,int r2)
	{
		
		Comparator<Product> compare = (p1,p2)->p1.getRating() - p2.getRating();
		
		List<Product> productList = list.stream().
		filter((product)->product.getRating()>=r1&&product.getRating()<=r2).
		collect(Collectors.toList());
		
		return productList;
	}
	public Product doDeleteById(int searchedId)
	{
		Product p = getProductById(searchedId);
		boolean x = false;
		if(p != null)
		{
			System.out.println(" ===> DAO List Size before delete "+list.size()+" and p "+p);
			x = list.remove(p);
			System.out.println(" ===> DAO List Size after delete "+list.size());
			System.out.println(" ===>> DAO Delete operation "+x);
		}
		
		if(x) return p;
		else return null;
	}
	//update product
		public Product updateproduct(Product d,int searchid)
		{
			Product p=getProductById(searchid);
			if(p!=null) {
			p.setProductCost(d.getProductCost());
			p.setProductId(d.getProductId());
			p.setProductName(d.getProductName());
			p.setRating(d.getRating());
			p.setAvailable(d.getAvailable());
			}
			return p;
			
		}
		//this will insert new product
		public Product insertProduct(Product news)
		{ 
			list.add(news);
			return news;
		}
	
}//end class
