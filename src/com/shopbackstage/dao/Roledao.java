package com.shopbackstage.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.shopbackstage.domain.Class;
import com.shopbackstage.domain.Role;
import com.shopbackstage.utils.JDBCutils;

/**
 * 角色的信息的管理
 * @author 高俊立
 *
 */
public class Roledao {
	//获取连接需要的东西
	static Connection conn=null;
	//获取游标
	static Statement stm=null;
	//获取返回结果
	static ResultSet rs=null;
	/*
	 * 查询所有的角色   
	 */
	public ArrayList<Role> selectroles(){
		ArrayList<Role> list = new ArrayList<>();
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "SELECT roleID,roleName,roleDescribe,concat(',',adminName) roleadmins from role,admin where admin.adminRoleID=role.roleID ;";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				int roleID = rs.getInt("roleID");
				String roleName = rs.getString("roleName");
				String roleDescribe = rs.getString("roleDescribe");
				String roleAdmins = rs.getString("roleadmins");
				Role role = new Role(roleID, roleName, roleDescribe, roleAdmins);				
				list.add(role);
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
	 * 在角色表里面添加数据
	 */
	public boolean addrole(String roleName,String roleDescribe){
		//查询表
		boolean flag = false;
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "insert into role(roleName,roleDescribe) values('"+roleName+"','"+roleDescribe+"');";
			stm = conn.createStatement();
			int a = stm.executeUpdate(sql);
			if(a>0)
			{
				flag=true;
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
			JDBCutils.close(stm, conn);
		}
		
		return flag ;
	}
	/*
	 * 获取角色id
	 */
	public int selectRoleID(String roleName)
	{
		int roleID = 0 ;
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "SELECT roleID from role where roleName='"+roleName+"';";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				//获取管理员姓名 电话 邮箱 加adminIphone入时间  角色名称  管理员状态
				roleID = rs.getInt("roleID");
				
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
		
		return roleID;
	}
	
}
