package com.shopbackstage.services;

import java.util.ArrayList;

import com.shopbackstage.dao.Authoritydao;
import com.shopbackstage.domain.Authority;

public class Authorityservices {
	Authoritydao authoritydao = new Authoritydao();
/*
 * 查询所有的权限
 */
	public ArrayList<Authority> selectauthority(){
		return authoritydao.Queryauthority();
	}
}
