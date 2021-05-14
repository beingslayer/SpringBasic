package com.capg.com.demoapp1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyRestController {
	
	@Autowired
	ProductDAOImpl dao;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello";
	}
    
	//            localhost:9090:\product\10000\40000
	//  endpoint :- www.abc.com\product\10000\40000
	@GetMapping("/product/{r1}/{r2}")
	public List<Product> getProductsbyrange(@PathVariable int r1 ,@PathVariable int r2)
	{
		return dao.getProductsByRange(r1, r2);
	}
	
	// ..../product/101
	@GetMapping("/product")
	public List<Product> getProduct()
	{
		return dao.getAllProducts();
	}
	@GetMapping("/product/{searchid}")
	public Product getProductByid(@PathVariable int searchid)
	{
		return dao.getProductById(searchid);
	}
	@GetMapping("/product/delete/{searchid}")
	public Product DeletebyId(@PathVariable int searchid)
	{
		return dao.doDeleteById(searchid);
	}
	@GetMapping("/productbyrating/{a1}/{a2}")
	public List<Product> getProductsbyrating(@PathVariable int a1 ,@PathVariable int a2)
	{
		return dao.getProductsByRating(a1, a2);
	}
	@PostMapping("/product")
	public Product insertproduct(@RequestBody Product product)
	{
		return dao.insertProduct(product);
	}
	@PutMapping("/product")
	public Product updateproduct( @RequestBody Product d)
	{
		return dao.updateproduct(d,d.getProductId());
		
	}
	
	
}
