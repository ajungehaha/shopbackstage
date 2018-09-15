package com.shopbackstage.domain;
/**
 * 保存管理员的信息模型
 * @author 高俊立
 *
 */
public class Admin {
	//管理员名称
	private String adminName;
	//管理员密码
	private String adminPassword;
	//管理员电话
	private String adminIphone;
	//管理员邮箱
	private String adminEmail;
	//管理员角色
	private String adminRole;
	//管理员加入时间
	private String adminJoinTime;
	//管理员状态 启用 或者 停用
	private int adminState;
	public Admin( String adminName, String adminIphone, String adminEmail,
			String adminRole, String adminJoinTime, int adminState) {
		super();
		
		this.adminName = adminName;
		this.adminIphone = adminIphone;
		this.adminEmail = adminEmail;
		this.adminRole = adminRole;
		this.adminJoinTime = adminJoinTime;
		this.adminState = adminState;
	}
	public Admin() {
		super();
	}
	
	
	public Admin(String adminName, String adminPassword, String adminIphone, String adminEmail, String adminRole,
			String adminJoinTime, int adminState) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminIphone = adminIphone;
		this.adminEmail = adminEmail;
		this.adminRole = adminRole;
		this.adminJoinTime = adminJoinTime;
		this.adminState = adminState;
	}
	
	
	
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminIphone() {
		return adminIphone;
	}
	public void setAdminIphone(String adminIphone) {
		this.adminIphone = adminIphone;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
	public String getAdminJoinTime() {
		return adminJoinTime;
	}
	public void setAdminJoinTime(String adminJoinTime) {
		this.adminJoinTime = adminJoinTime;
	}
	public int getAdminState() {
		return adminState;
	}
	public void setAdminState(int adminState) {
		this.adminState = adminState;
	}
	
	
	
}
