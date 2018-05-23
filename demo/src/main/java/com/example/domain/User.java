package com.example.domain;

public class User {
	private Integer uid;
	private String username;
	private Integer password;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getPassword() {
		return password;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
	public User(Integer uid, String username, Integer password) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
	}
}
