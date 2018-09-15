package com.shopbackstage.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.PreparedStatement;

public class JDBCutils {
	//获取数据路的链接
		private static ComboPooledDataSource source = new ComboPooledDataSource();
		/**
		 * 私有构造方法，说明本类不允许生成对象
		 */
		private JDBCutils(){}
		/**
		 * 获取数据库连接
		 * @return
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 * @throws NamingException 
		 */
		public static Connection getConn() throws ClassNotFoundException, SQLException, NamingException{		
			Connection conn = (Connection) source.getConnection();

			return conn;
		}
		//这里是数据库的工具类
		//执行数据路的关闭 查询的关闭
		public static void closeSelect(Statement stm,Connection conn,ResultSet rs)
		{
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					rs=null;
				}
			}
			if(stm!=null)
			{
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					stm=null;
				}
			}
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					conn=null;
				}
			}
				
		}
		//执行数据的关闭  增加数据  修改数据 删除数据的关闭
		public static void close(Statement stm,Connection conn)
		{
			if(stm!=null)
			{
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					stm=null;
				}
			}
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					conn=null;
				}
			}
				
		}
		
}
