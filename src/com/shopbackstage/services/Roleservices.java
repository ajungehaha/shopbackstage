package com.shopbackstage.services;

import java.util.ArrayList;

import com.shopbackstage.dao.Role_authoritydao;
import com.shopbackstage.dao.Roledao;
import com.shopbackstage.domain.Role;

public class Roleservices {
	Roledao roledao = new Roledao();
	Role_authoritydao role_authoritydao = new Role_authoritydao();
	/*
	 * 查询所有的role
	 */
	public ArrayList<Role> selectRoles()
	{
		return roledao.selectroles();
	}
	/*
	 * 添加一条数据
	 */
	public boolean addRole(String roleName,String roleDescribe,int authorityID)
	{
		if(roledao.addrole(roleName, roleDescribe))
		{
			int roleID = roledao.selectRoleID(roleName);
			if(role_authoritydao.addRole_authority(roleID, authorityID))
			{
				return true;
			}
			return false;
		}
		return false;
	}
	/*
	 * 查询id
	 */
	public int selectRoleID(String roleName)
	{
		return roledao.selectRoleID(roleName);
	}

}
