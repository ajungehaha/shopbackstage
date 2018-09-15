package com.shopbackstage.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.mysql.jdbc.EscapeTokenizer;
import com.mysql.jdbc.PreparedStatement;
import com.shopbackstage.domain.Admin;
import com.shopbackstage.domain.User;
import com.shopbackstage.utils.JDBCutils;



/**
 * 管理员信息
 * @author 高俊立
 *
 */
public class Admindao {
	//数据库连接
	static Connection conn=null;
	//获取游标
	static Statement stm=null;
	//获取返回结果
	static ResultSet rs=null;
	/*
	 * 验证一个管理员的账号和密码进行登录
	 */
	public boolean test(String adminName,String adminPassword)
	{
		//创建一个admin的对象
		Admin admin = null;
		//
		try {
			//获取链接
			conn = JDBCutils.getConn();
			
			String sql = "SELECT adminName,adminPassword FROM admin WHERE adminName='"+adminName+"' and adminPassword='"+adminPassword+"';";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			if(rs.next())
			{
				return true;
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
		
		return false;
	}
	/*
	 * 查询一个管理员信息
	 */
	public ArrayList<Admin> selectOne(String adminName1)
	{
		//创建一个admin的对象
		ArrayList<Admin> adminlist =  new ArrayList<>();
		//
		try {
			//获取链接
			conn = JDBCutils.getConn();
			String sql = "SELECT adminName,adminIphone,adminEmail,adminJoinTime,adminState,roleName  FROM admin,role WHERE adminRoleID=roleID and adminName='"+adminName1+"' ;";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				//获取管理员姓名 电话 邮箱 加adminIphone入时间  角色名称  管理员状态
				String adminName = rs.getString("adminName");
				String adminIphone = rs.getString("adminIphone");
				String adminEmail = rs.getString("adminEmail");
				String adminJoinTime = rs.getString("adminJoinTime");
				String adminRole = rs.getString("roleName");
				//保存的是这个用户的等级  1 表示启用  0 表示 停用
				int adminState = Integer.parseInt(rs.getString("adminState"));
				Admin admin = new Admin(adminName, adminIphone, adminEmail,adminRole, adminJoinTime,adminState);
				adminlist.add(admin);
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
		
		return adminlist;
	}
	/*
	 * 查询所有的管理员信息
	 */
	public ArrayList<Admin> selectAdmins()
	{
		//创建一个arraylist的对象
		ArrayList<Admin> admins = new ArrayList<>();
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "SELECT adminName,adminIphone,adminEmail,adminJoinTime,adminState,roleName  FROM admin,role WHERE adminRoleID=roleID ;";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				//获取管理员姓名 电话 邮箱 加adminIphone入时间  角色名称  管理员状态
				
				String adminName = rs.getString("adminName");
				String adminIphone = rs.getString("adminIphone");
				String adminEmail = rs.getString("adminEmail");
				String adminJoinTime = rs.getString("adminJoinTime");
				String adminRole = rs.getString("roleName");
				//保存的是这个用户的等级  1 表示启用  0 表示 停用
				int adminState = Integer.parseInt(rs.getString("adminState"));
				Admin admin = new Admin(adminName, adminIphone, adminEmail,adminRole, adminJoinTime,adminState);
				admins.add(admin);
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
		
		return admins;
	}
	/*
	 * 进行管理员信息的修改
	 */
	public boolean changePassword(String adminName,String changePassword)
	{	
		boolean flag = false;
		//获取链接
		try {
			conn = JDBCutils.getConn();
			//修改密码
			String sql = "update admin set adminPassword='"+changePassword+"' where adminName='"+adminName+"';";
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
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			//关闭数据库
			JDBCutils.close(stm, conn);
		}
		return flag;
	}
	/*
	 * 添加一个管理员的信息
	 */
	public boolean addone(Admin admin)
	{
		int roleid = 0;
		boolean flag= false;
		
			//获取链接
			try {
				conn = JDBCutils.getConn();
				//先进行一个角色id的查找
				String sql = "select roleID from role where roleName='"+admin.getAdminRole()+"' ;";
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);
				while(rs.next())
				{
					roleid = rs.getInt("roleID");
				}
			//再进行角色id的添加
			String sql2 = "insert into admin values('"+admin.getAdminName()+"','"+admin.getAdminPassword()+"','"+admin.getAdminIphone()+"','"+admin.getAdminEmail()+"','"+roleid+"','"+admin.getAdminJoinTime()+"','"+admin.getAdminState()+"');";
			if(stm.executeUpdate(sql2)>0)
			{
				flag=true;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			finally {
				//关闭数据库
				JDBCutils.closeSelect(stm, conn, rs);
			}
			return flag;
		
	}
	/*
	 * 删除一个管理员的信息
	 */
	public void deleteOne(String adminName1)
	{
			//获取链接
			try {
				conn = JDBCutils.getConn();
				//先进行一个角色id的查找
				String sql = "delete from admin where adminName='"+adminName1+"';";
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			finally {
				//关闭数据库
				JDBCutils.close(stm, conn);
			}
		
	}
	/*
	 * 查询一共有多少个管理员
	 */
	public int selectAdminCount() {
		int count = 0;
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "select count(*) from admin;";
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
 * 根据用户名查询权限地址并且返回
 * 
 */
	public ArrayList<String> selectAuthorityAdress(String adminName)
	{
		ArrayList<String> list = new ArrayList<>();
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "select authorityAdress from admin,role,role_authority,authority where adminName='"+adminName+"' and admin.adminRoleID=role.roleID and role.roleID=role_authority.roleID and role_authority.authorityID=authority.authorityID;";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				String authorityAdress = rs.getString("authorityAdress");
				list.add(authorityAdress);
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
