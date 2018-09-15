package com.shopbackstage.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.shopbackstage.domain.Class;
import com.shopbackstage.domain.User;
import com.shopbackstage.utils.JDBCutils;

/***
 * user模型 dao层
 * @author 高俊立
 *
 */
public class Userdao {
	//数据库连接需要的变量
	static Connection conn=null;
	//获取游标
	static Statement stm=null;
	//获取返回结果
	static ResultSet rs=null;
	//进行所有的user的查询
	public ArrayList<User> queryUsers(){
		ArrayList<User> list = new ArrayList<>();
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "SELECT userName,userIntegral from user ;";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				//获取user的名称和积分
				
				String userName = rs.getString("userName");
				String userIntegral = rs.getString("userIntegral");
				User user = new User(userName, userIntegral);
				list.add(user);
			}
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//关闭数据库
			JDBCutils.closeSelect(stm, conn, rs);
		}
		
		return list;
	}
	/*
	 * 对用户数的统计 返回统计的个数
	 */
	public int selectUserCount() {
		int count = 0;
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "select count(*) from user;";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			if(rs.next())
			{
				count = rs.getInt(1);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//关闭数据库
			JDBCutils.closeSelect(stm, conn, rs);
		}
		
		
		return count;
	}
	/*
	 * 查询一个用户
	 */
	public ArrayList<User> selectUser(String  userName){
		ArrayList<User> list = new ArrayList<>();
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "select userName,userIntegral from user where userName='"+userName+"';";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				//获取管理员姓名 电话 邮箱 加adminIphone入时间  角色名称  管理员状态
				
				String userName1 = rs.getString("userName");
				int userIntegral = rs.getInt("userIntegral");
				User user = new User(userName1, userIntegral);
				list.add(user);
			}
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//关闭数据库
			JDBCutils.closeSelect(stm, conn, rs);
		}
		
		return list;
	}
	
}
