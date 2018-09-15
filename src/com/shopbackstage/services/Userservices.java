package com.shopbackstage.services;
/**
 * 进行关于user的一些逻辑处理
 * @author 高俊立
 *
 */

import java.util.ArrayList;

import com.shopbackstage.dao.Userdao;
import com.shopbackstage.domain.User;

public class Userservices {
	//获取dao层的一些对象
	Userdao userdao  = new Userdao();
	/*
	 * 获取全部的user信息，返回到servlet进行显示
	 */
	public ArrayList<User> queryUsers()
	{
		return userdao.queryUsers();
	}
	/*
	 * 获取用户数
	 */
	public int selectUserCount()
	{
		return userdao.selectUserCount();
	}
	/*
	 * 获取一个用户
	 */
	public ArrayList<User> selectUser(String userName)
	{
		return userdao.selectUser(userName);
	}

}
