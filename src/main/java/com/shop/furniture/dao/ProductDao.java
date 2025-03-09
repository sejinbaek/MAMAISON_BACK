package com.shop.furniture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.shop.furniture.dto.Product;

@Repository
public class ProductDao {
	
	@Value("${spring.datasource.driver-class-name}")
	private String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String DB_USER;
	
	@Value("${spring.datasource.password}")
	private String DB_PW;

	
	public List<Product> getOnepageProducts() throws Exception {
		Class.forName(DB_DRIVER);
		try(
				Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
				PreparedStatement stmt = con.prepareStatement("select * from product limit 8");
				ResultSet rs = stmt.executeQuery();
				) {
			
			List<Product> list = new ArrayList<>();
			while(rs.next()) {
				int prodcode = rs.getInt("prodcode");
				String prodname = rs.getString("prodname");
				int price = rs.getInt("price");
				String pimg = rs.getString("pimg");
				list.add(new Product(prodname, pimg, prodcode, price));
			}
			
			return list;
			
		}
		
	}

}
