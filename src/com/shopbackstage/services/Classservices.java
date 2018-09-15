package com.shopbackstage.services;

import java.util.ArrayList;

import com.shopbackstage.dao.Classdao;
/**
 * 分类的逻辑处理类
 * @author 高俊立
 *
 */
import com.shopbackstage.domain.Class;
public class Classservices {
	//引入dao层对象 Classdao
	Classdao classdao = new Classdao();
	/*
	 * 进行对所有class列表的获取
	 */
	public ArrayList<Class> queryClass()
	{
		return classdao.Queryclass();
	}
	/*
	 * 只查询一个分类数据
	 */
	public ArrayList<Class> selectclass(String className1)
	{
		return classdao.selectclass(className1);
	}
	/*
	 * 删除分类数据
	 */
	public boolean deleteclass(int classID) {
		return classdao.deleteclass(classID);
	}
	/*
	 * 添加一个分类
	 */
	public boolean addclass(String className,String classDescribe) {
		return classdao.addclass(className, classDescribe);
	}

}
