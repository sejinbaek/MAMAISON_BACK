package com.shop.furniture.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.furniture.dto.Product;
import com.shop.furniture.service.ProductService;

@RestController
@CrossOrigin("http://192.168.0.16:5500/")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	Map<String, Object> storage = new HashMap<>();
	
	@GetMapping("getOnepageProducts")
	public List<Product> getOnepageProducts() {
		try {
			Object o = storage.get("firstPageProducts");
			if(o == null) {
				List<Product> list = productService.getOnepageProducts();
				storage.put("firstPageProducts", list);
				return list;
			}
			return (List<Product>) o;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
