package com.shopbackstage.services;
/**
 * 对订单的状态的管理
 * @author 高俊立
 *
 */

import java.util.ArrayList;

import com.shopbackstage.dao.Orderdao;
import com.shopbackstage.dao.Productdao;
import com.shopbackstage.domain.Order;
import com.shopbackstage.domain.Product;

public class Orderservices {
	//获取services层的变量
	Orderdao orderdao = new Orderdao();
	Productdao productdao = new Productdao();
	
	/*
	 * 根据id查询订单
	 */
	public ArrayList<Order> selectordersASid(int orderID)
	{
		return orderdao.selectordersASid(orderID);
	}
	/*
	 * 订单的发货操作
	 */
	public  boolean fahuo(int orderID)
	{
		return orderdao.changeOrderState(orderID, 2);
	}
	/*
	 * 订单的退款操作
	 */
	public boolean tuikuan(int orderID)
	{
		return orderdao.changeOrderState(orderID, 5);
	}
	/*
	 * 订单的修改地址的操作
	 */
	public boolean changeOrderAdress(Integer orderID,String adressName )
	{
		return orderdao.changeOrderAdress(orderID, adressName);
	}
	/*
	 * 根据id查询商品信息
	 */
	public ArrayList<Product> selectProductAsOrderID( int orderID){
		return productdao.selectProductAsOrderID(orderID);
	}
}
