package com.shopbackstage.services;

import java.util.ArrayList;

import com.shopbackstage.dao.Admindao;
import com.shopbackstage.domain.Admin;

/**
 * 进行关于管理员的一系列操作
 * @author 高俊立
 *
 */
public class Adminservices {
	//进行dao层数据的创建
	Admindao admindao  = new Admindao();
	/*
	 * 进行登陆的验证
	 */
	public boolean loginTest(String adminName,String adminPassword)
	{
		return admindao.test(adminName, adminPassword);
	}
	/*
	 * 进行修改密码的操作
	 */
	public boolean changPassword(String adminName,String changePassword)
	{
		return admindao.changePassword(adminName, changePassword);
	}
	/*
	 * 进行查询所有的管理员的操作
	 */
	public ArrayList<Admin> selectAdmins()
	{
		return admindao.selectAdmins();
	}
	/*
	 * 添加管理员的操作
	 */
	public boolean addone(Admin admin)
	{
		return admindao.addone(admin);
	}
	/*
	 * 查找一个管理员的操作
	 * 
	 */
	public ArrayList<Admin> selectAdmin(String adminName1)
	{
		return admindao.selectOne(adminName1);
	}
/*
 * 查找权限地址
 */ 
	public ArrayList<String> selectAuthorityAdress(String adminName)
	{
		return admindao.selectAuthorityAdress(adminName);
	}
}
