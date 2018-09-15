package com.shopbackstage.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.shopbackstage.domain.Class;
import com.shopbackstage.domain.Order;
import com.shopbackstage.utils.JDBCutils;

/*
 * 订单信息的查询
 */
public class Orderdao {
	/*
	 * 查询订单的相关信息
	 * 将商品的单价进行求和  将商品的信息进行arraylist的保存 利用map进行存储
	 */
	//查询需要的链接变量
	static Connection conn=null;
	//获取游标
	static Statement stm=null;
	//获取返回结果
	static ResultSet rs=null;
	 /*
	  * 查询基础得订单信息
	  */
	public ArrayList<Order> selectorders(){
		ArrayList<Order> list = new ArrayList<>();
		int orderProductNum = 0;
		double orderPrice = 0;
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();				
			String sql = "SELECT orderID,userName,orderState,placeTime,payTime,deliveryTime,accessTime,adressName,consigneeName,consigneerPhone from orders ;";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				int orderID = rs.getInt("orderID");				
				String sql1 = "select count(*),sum(productPrice) from order-product where orderID='"+orderID+"'";
				ResultSet rs2 = stm.executeQuery(sql1);
				if(rs2.next())
				{
					orderProductNum = rs2.getInt(1);
					orderPrice = rs2.getDouble(2);
					rs2.close();
				}
				String userName = rs.getString("userName");
				String placeTime = rs.getString("placeTime");
				String deliveryTime = rs.getString("deliveryTime");
				String payTime = rs.getString("payTime");
				String accessTime = rs.getString("accessTime");
				String adressName = rs.getString("adressName");
				String consigneeName = rs.getString("consigneeName");
				String consigneerPhone = rs.getString("consigneerPhone");
				int orderState = rs.getInt("orderState");
				Order order = new Order(orderID, orderState, orderPrice, orderProductNum, userName, placeTime, payTime, deliveryTime, accessTime, adressName, consigneeName, consigneerPhone);
				list.add(order);
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
	 * 修改订单的状态		
	 */
	public boolean changeOrderState(int orderID,int orderState)
	{
		boolean flag=false;
		try {
			//获取链接
			conn = JDBCutils.getConn();				
			String sql = "update orders set orderState='"+orderState+"' where orderID='"+orderID+"';";
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
		
		return flag;
	}
	/*
	 * 修改订单的adress地址
	 */
	public boolean changeOrderAdress(int orderID,String adressName)
	{
		boolean flag=false;
		try {
			//获取链接
			conn = JDBCutils.getConn();				
			String sql = "update orders set adressName='"+adressName+"' where orderID='"+orderID+"';";
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
		
		return flag;
	}
	/*
	 * 查询后台的订单数
	 */
	public int selectOrderCount() {
		int count = 0;
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "select count(*) from orders;";
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
 * 根据id查询订单
 * 
 */
	public ArrayList<Order> selectordersASid(int orderID){
		ArrayList<Order> list = new ArrayList<>();
		int orderProductNum = 0;
		double orderPrice = 0;
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();				
			String sql = "SELECT count(*),sum(productPrice),orders.orderID,userName,orderState,placeTime,payTime,deliveryTime,accessTime,adressName,consigneeName,consigneerPhone from orders,orders_product where orders.orderID="+orderID+" and orders_product.orderID="+orderID+";";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{			
				
				orderProductNum = rs.getInt(1);
				orderPrice = rs.getDouble(2);
				
				String userName = rs.getString("userName");
				String placeTime = rs.getString("placeTime");
				String deliveryTime = rs.getString("deliveryTime");
				String payTime = rs.getString("payTime");
				String accessTime = rs.getString("accessTime");
				String adressName = rs.getString("adressName");
				String consigneeName = rs.getString("consigneeName");
				String consigneerPhone = rs.getString("consigneerPhone");
				int orderState = rs.getInt("orderState");
				Order order = new Order(orderID, orderState, orderPrice, orderProductNum, userName, placeTime, payTime, deliveryTime, accessTime, adressName, consigneeName, consigneerPhone);
				list.add(order);
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
