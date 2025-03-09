package com.shop.furniture.dto;

public class Member {
	private String name;
	private String email;
	private String id;
	private String password;
	private String passwordcheck;
	
	public Member() {
		super();
	}

	public Member(String name, String email, String id, String password, String passwordcheck) {
		super();
		setName(name);
		setEmail(email);
		setId(id);
		setPassword(password);
		setPasswordcheck(passwordcheck);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordcheck() {
		return passwordcheck;
	}

	public void setPasswordcheck(String passwordcheck) {
		this.passwordcheck = passwordcheck;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", email=" + email + ", id=" + id + ", password=" + password
				+ ", passwordcheck=" + passwordcheck + "]";
	}
	
	
	
	

}
