package com.shop.furniture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.shop.furniture.dto.Product;

@Mapper
public interface ProductDao {
	
	public List<Product> getOnepageProducts() throws Exception;
	
}
