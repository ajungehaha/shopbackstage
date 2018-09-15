package com.shopbackstage.services;
/**
 * 操作product的services的对象
 * @author 高俊立
 *
 */

import java.util.ArrayList;
import java.util.Iterator;

import com.shopbackstage.dao.Classdao;
import com.shopbackstage.dao.Product_classdao;
import com.shopbackstage.dao.Product_picturedao;
import com.shopbackstage.dao.Productdao;
import com.shopbackstage.domain.Product;

public class Productservices {
	//获取dao层对象
	Productdao productdao = new Productdao();
	Product_classdao product_classdao = new Product_classdao();
	Product_picturedao product_picturedao = new Product_picturedao();
	Classdao classdao = new Classdao();
	/*
	 * 查询对应分类的对象
	 */
	public ArrayList<Product> selectProducts(int classID)
	{
		return productdao.selectProducts(classID);
	}
	/*
	 * 更改商品的状态  下架
	 */
	public boolean changeProductState(int productID,int productState) {
		return productdao.changeProductState(productID, productState);		
	}
	/*
	 * 删除商品
	 */
	public boolean deleteProduct(int productID) {
		return productdao.deleteproduct(productID);
	}
	/*
	 * 添加商品    在商品分类表里面进行添加 需要在商品图片表里面添加
	 */
	public void addProduct(String className,Product product)
	{
		//获取分类id 存入商品分类表
		int classID = classdao.selectClassID(className);
		//添加到商品表里面
		productdao.addproduct(product);	
		int productID = productdao.selectproductID(product.getProductName());
		product_classdao.addProduct_class(productID, classID);
		
			
	}
	/*
	 * 添加一张图片
	 * 
	 */
	public boolean addOneicture(int productID,String pictureAdress)
	{
		return product_picturedao.addPicture(productID, 0, pictureAdress);
	}
	/*
	 * 查询一个商品 利用商品名称进行查询
	 * 
	 */
	public ArrayList<Product> selectOneProduct(String productName1)
	{
		return productdao.selectOneProduct(productName1);
	}
	/*
	 * 查询productID
	 */
	public int selectProductID(String productName)
	{
		return productdao.selectproductID(productName);
	}

}
