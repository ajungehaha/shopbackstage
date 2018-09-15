package com.shopbackstage.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import com.shopbackstage.utils.JDBCutils;

/**
 * 进行商品 分类信息的保存
 * @author 高俊立
 *
 */
public class Product_classdao {
	//获取数据连接
	static Connection conn=null;
	//获取游标
	static Statement stm=null;
	//获取返回结果
	static ResultSet rs=null;
	/*
	 * 进行商品分类数据的保存
	 */
	public boolean addProduct_class(int productID,int classID){
		//查询表
		boolean flag = false;
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "insert into product_class(productID,classID) values('"+productID+"','"+classID+"');";
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
