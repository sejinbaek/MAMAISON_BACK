package com.shop.furniture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.shop.furniture.dto.Member;
import com.shop.furniture.dto.Product;

@Repository
public class MemberDao {
	
	@Value("${spring.datasource.driver-class-name}")
	private String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String DB_USER;
	
	@Value("${spring.datasource.password}")
	private String DB_PW;

	
	public void insertMember(Member m) throws Exception {
		Class.forName(DB_DRIVER);
		try(
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
			PreparedStatement stmt = con.prepareStatement("insert into member(name, email, id, password, passwordcheck) values(?,?,?,?,?)");
				) {
			stmt.setString(1, m.getName());
			stmt.setString(2, m.getEmail());
			stmt.setString(3, m.getId());
			stmt.setString(4, m.getPassword());
			stmt.setString(5, m.getPasswordcheck());
			
			int i = stmt.executeUpdate();
			
			System.out.println(i + "행이 insert 되었습니다");	
			
		}
	}
	
	public Member login(Member m) throws Exception {
		Class.forName(DB_DRIVER);
		try(
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
			PreparedStatement stmt = con.prepareStatement("select * from member where id=? and password=?");
				) {
			
			stmt.setString(1, m.getId());
			stmt.setString(2, m.getPassword());
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				m.setName(name);
			}
			return m;
			
		}
	}

}
