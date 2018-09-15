package com.shopbackstage.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.shopbackstage.domain.Authority;
import com.shopbackstage.domain.Class;
import com.shopbackstage.utils.JDBCutils;

/**
 * 对权限的链接信息的dao
 * @author 高俊立
 *
 */
public class Authoritydao {
	//链接需要的数据
	static Connection conn=null;
	//获取游标
	static Statement stm=null;
	//获取返回结果
	static ResultSet rs=null;
/*
 * 进行所有的权限的查询
 */
	public ArrayList<Authority> Queryauthority(){
		ArrayList<Authority> list = new ArrayList<>();
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "SELECT authorityID,authorityName,authorityAdress from authority;";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				//获取管理员姓名 电话 邮箱 加adminIphone入时间  角色名称  管理员状态
				int authorityID = rs.getInt("authorityID");
				String authorityName = rs.getString("authorityName");
				String authorityAdress = rs.getString("authorityAdress");
				Authority authority = new Authority(authorityID, authorityName, authorityAdress);
				list.add(authority);
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
