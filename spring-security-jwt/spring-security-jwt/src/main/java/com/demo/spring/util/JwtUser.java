package com.demo.spring.util;

public class JwtUser {
	private String username;
	private String password;

	public JwtUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
