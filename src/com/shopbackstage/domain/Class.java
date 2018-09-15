package com.shopbackstage.domain;
/**
 * 
 * @author 高俊立
 *分类信息 模型
 */
public class Class {
	/*
	 * 分类id
	 */
	private int classID;
	/*
	 * 分类名称
	 */
	private String className;
	/*
	 * 分类简介
	 */
	private String classDescribe;
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassDescribe() {
		return classDescribe;
	}
	public void setClassDescribe(String classDescribe) {
		this.classDescribe = classDescribe;
	}
	
	public Class( String className, String classDescribe) {
		super();
		this.className = className;
		this.classDescribe = classDescribe;
	}
	public Class(int classID, String className, String classDescribe) {
		super();
		this.classID = classID;
		this.className = className;
		this.classDescribe = classDescribe;
	}
	public Class() {
		super();
	}
	

}
