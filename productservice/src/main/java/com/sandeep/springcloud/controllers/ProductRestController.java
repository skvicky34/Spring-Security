package com.sandeep.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sandeep.springcloud.dto.Coupon;
import com.sandeep.springcloud.model.Product;
import com.sandeep.springcloud.repos.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
	
	@Autowired
	ProductRepo repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${couponService.url}")
	String couponServiceURL;
	
	@RequestMapping(value="/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product)
	{
		Coupon coupon = restTemplate.getForObject(couponServiceURL+product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);
		
	}

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id") Long id)
	{
		return repo.findById(id).get();
		
	}
}
