package com.shopbackstage.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.shopbackstage.domain.Class;
import com.shopbackstage.utils.JDBCutils;

/**
 * 
 * @author 高俊立
 *数据库获取分类的信息
 */
public class Classdao {
	//数据库连接
		static Connection conn=null;
		//获取游标
		static Statement stm=null;
		//获取返回结果
		static ResultSet rs=null;
		
		/*
		 * 一个分类的查找
		 */
		public ArrayList<Class> selectclass(String  className1){
			ArrayList<Class> list = new ArrayList<>();
			//查询表
			try {
				//获取链接
				conn = JDBCutils.getConn();			
				String sql = "SELECT classID,className,classDescribe from class where className='"+className1+"';";
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);
				while(rs.next())
				{
					//获取管理员姓名 电话 邮箱 加adminIphone入时间  角色名称  管理员状态
					int classID = rs.getInt("classID");
					String className = rs.getString("className");
					String classDescribe = rs.getString("classDescribe");
					Class class1 = new Class(classID, className, classDescribe);
					list.add(class1);
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
		 * 获取分类列表
		 */
		
		public ArrayList<Class> Queryclass(){
			ArrayList<Class> list = new ArrayList<>();
			//查询表
			try {
				//获取链接
				conn = JDBCutils.getConn();			
				String sql = "SELECT classID,className,classDescribe from class;";
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);
				while(rs.next())
				{
					//获取管理员姓名 电话 邮箱 加adminIphone入时间  角色名称  管理员状态
					int classID = rs.getInt("classID");
					String className = rs.getString("className");
					String classDescribe = rs.getString("classDescribe");
					Class class1 = new Class(classID, className, classDescribe);
					list.add(class1);
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
		 * 查询分类id 用来进行商品分类表的存储
		 */
		public int selectClassID(String className)
		{
			int classID = 0 ;
			//查询表
			try {
				//获取链接
				conn = JDBCutils.getConn();			
				String sql = "SELECT classID from class where className='"+className+"';";
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);
				while(rs.next())
				{
					//获取管理员姓名 电话 邮箱 加adminIphone入时间  角色名称  管理员状态
					classID = rs.getInt("classID");
					
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
			
			return classID;
		}
		/*
		 * 添加分类
		 */
		public boolean addclass(String className,String classDescribe){
			//查询表
			boolean flag = false;
			try {
				//获取链接
				conn = JDBCutils.getConn();			
				String sql = "insert into class(className,classDescribe) values('"+className+"','"+classDescribe+"');";
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
		 * 删除分类
		 */
		public boolean deleteclass(int classID){
			boolean flag=false;
			//查询表
			try {
				//获取链接
				conn = JDBCutils.getConn();			
				String sql = "delete from  class where classID='"+classID+"' ";
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
		
}
