package com.shopbackstage.domain;
/**
 * 权限信息管理 模型
 * @author 高俊立
 *
 */
public class Authority {
	//权限id
	private int authorityID;
	//权限名称
	private String authorityName;
	//权限管理地址
	private String authorityAdress;
	public int getAuthorityID() {
		return authorityID;
	}
	public void setAuthorityID(int authorityID) {
		this.authorityID = authorityID;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public String getAuthorityAdress() {
		return authorityAdress;
	}
	public void setAuthorityAdress(String authorityAdress) {
		this.authorityAdress = authorityAdress;
	}
	public Authority(int authorityID, String authorityName, String authorityAdress) {
		super();
		this.authorityID = authorityID;
		this.authorityName = authorityName;
		this.authorityAdress = authorityAdress;
	}
	public Authority() {
		super();
	}

}
