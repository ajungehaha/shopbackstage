package com.shopbackstage.dao;
/**
 * 
 * @author 高俊立
 *查询修改商品信息的dao 
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.mchange.v2.async.StrandedTaskReporting;
import com.shopbackstage.domain.Product;
import com.shopbackstage.domain.User;
import com.shopbackstage.utils.JDBCutils;

public class Productdao {
	//获取链接数据库所需要的变量
	static Connection conn=null;
	//获取游标
	static Statement stm=null;
	//获取返回结果
	static ResultSet rs=null;
	/*
	 * 查询一共有多少条数据，进行显示
	 * 
	 */
	public int selectProductCount() {
		int count = 0;
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "select count(*) from product;";
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
	 * 按分类查询商品
	 */
	public ArrayList<Product> selectProducts(int classID)
	{
		ArrayList<Product> list = new ArrayList<>();
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "SELECT product.productID,product.productName,productPrice,productAdress,productCsot,productStock,productSales,productState,lessIntegral,Press,pressTime,bookNum,printingTime,authorName,productCast,pictureAdress  FROM product,product_class,product_picture WHERE product_class.classID="+classID+" AND product.productID=product_class.productID AND product.productID=product_picture.productID AND product_picture.pictureAttrabute=0 ;";  
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				//获取商品的各个信息，进行对象的存储 对图片表进行关联查询 对分类表进行查询
				int productID = rs.getInt("productID");
				String productName = rs.getString("productName");
				double productPrice = rs.getDouble("productPrice");
				double productCsot = rs.getDouble("productCsot");
				String productAdress = rs.getString("productAdress");
				String pictureAdress = rs.getString("pictureAdress");				
				int productStock = rs.getInt("productStock");
				int productSales = rs.getInt("productSales");
				int productState = rs.getInt("productState");
				int lessIntegral = rs.getInt("lessIntegral");
				String Press = rs.getString("Press");
				String pressTime = rs.getString("pressTime");
				String bookNum = rs.getString("bookNum");
				String printingTime = rs.getString("printingTime");
				String authorName = rs.getString("authorName");
				String productCast = rs.getString("productCast");
				Product product = new Product(productID, pictureAdress, productAdress, productName, productPrice, productCsot, productStock, productSales, productState, lessIntegral, Press, pressTime, bookNum, printingTime, authorName,productCast);
				list.add(product);
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
	 *  按商品名称 查询一个
	 */
	public ArrayList<Product> selectOneProduct(String productName1)
	{
		ArrayList<Product> list = new ArrayList<>();
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "SELECT product.productID,product.productName,productPrice,productAdress,productCsot,productStock,productSales,productState,lessIntegral,Press,pressTime,bookNum,printingTime,authorName,productCast,pictureAdress  FROM product,product_picture,product_class WHERE   product.productID=product_class.productID AND product.productID=product_picture.productID AND product_picture.pictureAttrabute=0 and productName='"+productName1+"' ;";  
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				//获取商品的各个信息，进行对象的存储 对图片表进行关联查询 对分类表进行查询
				int productID = rs.getInt("productID");
				String productName = rs.getString("productName");
				double productPrice = rs.getDouble("productPrice");
				double productCsot = rs.getDouble("productCsot");
				String productAdress = rs.getString("productAdress");
				String pictureAdress = rs.getString("pictureAdress");				
				int productStock = rs.getInt("productStock");
				int productSales = rs.getInt("productSales");
				int productState = rs.getInt("productState");
				int lessIntegral = rs.getInt("lessIntegral");
				String Press = rs.getString("Press");
				String pressTime = rs.getString("pressTime");
				String bookNum = rs.getString("bookNum");
				String printingTime = rs.getString("printingTime");
				String authorName = rs.getString("authorName");
				String productCast = rs.getString("productCast");
				Product product = new Product(productID, pictureAdress, productAdress, productName, productPrice, productCsot, productStock, productSales, productState, lessIntegral, Press, pressTime, bookNum, printingTime, authorName,productCast);				
				list.add(product);
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
	 * 添加一个商品 不用管分类 我需要在商品分类表里面添加数据 通过上层查找到分类的id 然后再进行商品分类表的存储
	 * 需要的参数有商品信息  分类表的分类id进行分类的单独存储，这里只存储商品的相关信息  、单独写一个图片存储的东西 商品分类表的存储单独写一个
	 */
	public boolean addproduct(Product product){
		//查询表
		boolean flag = false;
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "insert into product(productAdress,productName,productPrice,productCsot,productStock,productSales,productState,lessIntegral,Press,pressTime,bookNum,printingTime,authorName,productCast) values('"+product.getProductAdress()+"','"+product.getProductName()+"',"+product.getProductPrice()+","+product.getProductCsot()+","+product.getProductStock()+","+product.getProductSales()+","+product.getProductState()+","+product.getLessIntegral()+",'"+product.getPress()+"','"+product.getPressTime()+"','"+product.getBookNum()+"','"+product.getPrintingTime()+"','"+product.getAuthorName()+"','"+product.getProductCast()+"');";
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
	 * 删除商品
	 */
	public boolean deleteproduct(int productID){
		boolean flag=false;
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "delete from  product where productID='"+productID+"'; ";
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
	 * 更改商品的状态 上架 下架
	 */
	public boolean changeProductState(int productID,int productState){
		boolean flag=false;
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "update   product set productState="+productState+" where productID="+productID+"; ";
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
	 * 根据orderID查询product
	 */
	public ArrayList<Product> selectProductAsOrderID(int orderID)
	{
		ArrayList<Product> list = new ArrayList<>();
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "SELECT product.productID,product.productName,orders_product.productPrice,productAdress,productCsot,productStock,productSales,productState,lessIntegral,Press,pressTime,bookNum,printingTime,authorName,productCast,pictureAdress  FROM product,orders_product,product_picture WHERE orders_product.orderID="+orderID+" AND product.productID=orders_product.productID AND product.productID=product_picture.productID AND product_picture.pictureAttrabute=0 ;";  
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				//获取商品的各个信息，进行对象的存储 对图片表进行关联查询 对分类表进行查询
				int productID = rs.getInt("productID");
				String productName = rs.getString("productName");
				double productPrice = rs.getDouble("productPrice");
				double productCsot = rs.getDouble("productCsot");
				String productAdress = rs.getString("productAdress");
				String pictureAdress = rs.getString("pictureAdress");				
				int productStock = rs.getInt("productStock");
				int productSales = rs.getInt("productSales");
				int productState = rs.getInt("productState");
				int lessIntegral = rs.getInt("lessIntegral");
				String Press = rs.getString("Press");
				String pressTime = rs.getString("pressTime");
				String bookNum = rs.getString("bookNum");
				String printingTime = rs.getString("printingTime");
				String authorName = rs.getString("authorName");
				String productCast = rs.getString("productCast");
				Product product = new Product(productID, pictureAdress, productAdress, productName, productPrice, productCsot, productStock, productSales, productState, lessIntegral, Press, pressTime, bookNum, printingTime, authorName,productCast);
				list.add(product);
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
	 * 查询productID
	 * 
	 */
	public int selectproductID(String productName)
	{
		int productID = 0 ;
		//查询表
		try {
			//获取链接
			conn = JDBCutils.getConn();			
			String sql = "SELECT productID from product where productName='"+productName+"';";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next())
			{
				//获取管理员姓名 电话 邮箱 加adminIphone入时间  角色名称  管理员状态
				productID = rs.getInt("productID");
				
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
		
		return productID;
	}
	
}	

