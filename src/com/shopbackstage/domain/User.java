package com.shopbackstage.domain;
/***
 * 
 * @author 高俊立
 *user模型 
 */
public class User {
	/*
	 * 用户名
	 */
	private String userName;
	/*
	 * 用户密码
	 */
	private String userPassword;
	/*
	 * 用户积分
	 */	
	private int userIntegral;
	
	
	public User() {
		super();
	}
	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userIntegral = 0;
	}
	
	public User(String userName, int userIntegral) {
		super();
		this.userName = userName;
		this.userIntegral = userIntegral;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserIntegral() {
		return userIntegral;
	}
	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}
	
	
}
