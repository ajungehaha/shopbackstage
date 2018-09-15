package com.shopbackstage.domain;
/**
 * 记录角色的相关信息
 * @author 高俊立
 *
 */
public class Role {
	//角色id
	private int roleID;
	//角色名称
	private String roleName;
	//角色简介
	private String roleDescribe; 
	//拥有此角色的用户
	private String roleAdmins;
	public Role(int roleID, String roleName, String roleDescribe, String roleAdmins) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
		this.roleDescribe = roleDescribe;
		this.roleAdmins = roleAdmins;
	}
	public Role() {
		super();
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescribe() {
		return roleDescribe;
	}
	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}
	public String getRoleAdmins() {
		return roleAdmins;
	}
	public void setRoleAdmins(String roleAdmins) {
		this.roleAdmins = roleAdmins;
	}
	
}
