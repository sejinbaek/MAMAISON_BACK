package com.shop.furniture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.furniture.dao.ProductDao;
import com.shop.furniture.dto.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public List<Product> getOnepageProducts() throws Exception {
		return productDao.getOnepageProducts();
	}

}
