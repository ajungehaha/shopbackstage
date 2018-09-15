package com.shopbackstage.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import com.shopbackstage.utils.JDBCutils;

/**
 * 角色权限表操作添加
 * @author 高俊立
 *
 */
public class Role_authoritydao {
	static Connection conn=null;
	//获取游标
	static Statement stm=null;
	//获取返回结果
	static ResultSet rs=null;
		
	/*
	 * 添加角色权限
	 */
	public boolean addRole_authority(int roleID,int authorityID){
		//查询表
		boolean flag = false;
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "insert into role_authority(roleID,authorityID) values("+roleID+","+authorityID+");";
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
