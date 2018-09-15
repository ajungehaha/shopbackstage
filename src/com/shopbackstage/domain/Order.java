package com.shopbackstage.domain;
/**
 * 
 * @author 高俊立
 *记录订单的信息
 */

import org.eclipse.jdt.internal.compiler.ast.DoubleLiteral;

public class Order {
	/*
	 *订单id 
	 */
	private int orderID;
	/*
	 * 订单状态
	 */
	private int orderState;
	/*
	 * 订单金额
	 */
	private double orderPrice;
	/*
	 * 订单包含的商品数量
	 */
	private int orderProductNum;
	/*
	 * 用户名
	 */
	private String userName;
	/*
	 * 下单时间
	 */
	private String placeTime;
	/*
	 * 支付时间
	 */
	private String payTime;
	/*
	 * 发货时间
	 */
	private String deliveryTime;
	/*
	 * 确认收货时间
	 */
	private String accessTime;
	/*
	 * 地址详细
	 */
	private String adressName;
	/*
	 * 收货人姓名
	 */
	private String consigneeName;
	/*
	 * 收货人手机号码
	 */
	private String consigneerPhone;
	public Order(int orderID, int orderState, double orderPrice, int orderProductNum, String userName, String placeTime,
			String payTime, String deliveryTime, String accessTime, String adressName, String consigneeName,
			String consigneerPhone) {
		super();
		this.orderID = orderID;
		this.orderState = orderState;
		this.orderPrice = orderPrice;
		this.orderProductNum = orderProductNum;
		this.userName = userName;
		this.placeTime = placeTime;
		this.payTime = payTime;
		this.deliveryTime = deliveryTime;
		this.accessTime = accessTime;
		this.adressName = adressName;
		this.consigneeName = consigneeName;
		this.consigneerPhone = consigneerPhone;
	}
	public Order() {
		super();
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getOrderProductNum() {
		return orderProductNum;
	}
	public void setOrderProductNum(int orderProductNum) {
		this.orderProductNum = orderProductNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPlaceTime() {
		return placeTime;
	}
	public void setPlaceTime(String placeTime) {
		this.placeTime = placeTime;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}
	public String getAdressName() {
		return adressName;
	}
	public void setAdressName(String adressName) {
		this.adressName = adressName;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneerPhone() {
		return consigneerPhone;
	}
	public void setConsigneerPhone(String consigneerPhone) {
		this.consigneerPhone = consigneerPhone;
	}
	
	
}
