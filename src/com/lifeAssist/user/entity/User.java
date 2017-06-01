package com.lifeAssist.user.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 4963196589541711291L;
	
	private String id;
	private String account;
	private String password;
	private String name;
	private boolean gender;
	private String headImg;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public User() {
		super();
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public User(String id, String account, String password, String name, boolean gender, String headImg) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.setHeadImg(headImg);
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	
}
