package com.ebsco.artfulauth.value;

public class AuthVO {
	private String username;
	private String UUID;
	public AuthVO(String username, String uUID) {
		super();
		this.username = username;
		UUID = uUID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public AuthVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
