package com.ebsco.artfulauth.value;

public class UserVO {
	private static int NEXT_ID = 90;
	private int id;
	private String username;
	private String password;
	
	public UserVO(String username, String password) {
		this(NEXT_ID++, username, password);
	}
	
	public UserVO(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
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
