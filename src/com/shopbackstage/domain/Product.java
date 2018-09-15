package com.shopbackstage.domain;
/**
 * 
 * @author 高俊立
 *存储商品信息
 */
public class Product {
	/*
	 * 商品id
	 */
	private int productID;
	/*
	 * 商品图片地址
	 */
	
	
	private String pictureAdress;
	/*
	 * 商品地址 快递出发地
	 */
	private String productAdress;
	/*
	 * 商品名称
	 */
	private String productName;
	/*
	 * 商品单价
	 */
	private double productPrice;
	/*
	 * 商品原价
	 */
	private double productCsot;
	/*
	 * 商品库存
	 */
	private int productStock;
	/*
	 * 商品销量
	 */
	private int productSales;
	/*
	 * 商品状态
	 */
	private int productState;
	/*
	 * 商品最低点积分兑换
	 */
	private int lessIntegral;
	/*
	 * 商品出版社
	 */
	private String press;
	/*
	 * 出版日期
	 */
	private String pressTime;
	/*
	 * 书号
	 */
	private String bookNum;
	/*
	 * 印刷日期
	 */
	private String printingTime;
	/*
	 * 书籍作者
	 */
	private String authorName;
	/*
	 * 商品描述
	 */
	private String productCast;
	
	public Product(int productID, String pictureAdress, String productAdress, String productName, double productPrice,
			double productCsot, int productStock, int productSales, int productState, int lessIntegral, String press,
			String pressTime, String bookNum, String printingTime, String authorName,String productCast) {
		super();
		this.productID = productID;
		this.pictureAdress = pictureAdress;
		this.productAdress = productAdress;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCsot = productCsot;
		this.productStock = productStock;
		this.productSales = productSales;
		this.productState = productState;
		this.lessIntegral = lessIntegral;
		this.press = press;
		this.pressTime = pressTime;
		this.bookNum = bookNum;
		this.printingTime = printingTime;
		this.authorName = authorName;
		this.productCast = productCast;
	}
	
	public Product(String productAdress, String productName, double productPrice, double productCsot, int productStock,
			int productSales, int productState, int lessIntegral, String press, String pressTime, String bookNum,
			String printingTime, String authorName, String productCast) {
		super();
		this.productAdress = productAdress;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCsot = productCsot;
		this.productStock = productStock;
		this.productSales = productSales;
		this.productState = productState;
		this.lessIntegral = lessIntegral;
		this.press = press;
		this.pressTime = pressTime;
		this.bookNum = bookNum;
		this.printingTime = printingTime;
		this.authorName = authorName;
		this.productCast = productCast;
	}

	public String getProductAdress() {
		return productAdress;
	}
	public void setProductAdress(String productAdress) {
		this.productAdress = productAdress;
	}
	public Product() {
		super();
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getPictureAdress() {
		return pictureAdress;
	}
	public void setPictureAdress(String pictureAdress) {
		this.pictureAdress = pictureAdress;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public double getProductCsot() {
		return productCsot;
	}
	public void setProductCsot(double productCsot) {
		this.productCsot = productCsot;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	public int getProductSales() {
		return productSales;
	}
	public void setProductSales(int productSales) {
		this.productSales = productSales;
	}
	public int getProductState() {
		return productState;
	}
	public void setProductState(int productState) {
		this.productState = productState;
	}
	public int getLessIntegral() {
		return lessIntegral;
	}
	public void setLessIntegral(int lessIntegral) {
		this.lessIntegral = lessIntegral;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		press = press;
	}
	public String getPressTime() {
		return pressTime;
	}
	public void setPressTime(String pressTime) {
		this.pressTime = pressTime;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getPrintingTime() {
		return printingTime;
	}
	public void setPrintingTime(String printingTime) {
		this.printingTime = printingTime;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getProductCast() {
		return productCast;
	}
	public void setProductCast(String productCast) {
		this.productCast = productCast;
	}

	
}
