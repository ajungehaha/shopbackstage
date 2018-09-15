package com.shopbackstage.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopbackstage.domain.Authority;
import com.shopbackstage.domain.Role;
import com.shopbackstage.services.Authorityservices;
import com.shopbackstage.services.Roleservices;

/**
 * Servlet implementation class Roleservlet
 */
@WebServlet("/Roleservlet")
public class Roleservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Roleservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Roleservices roleservices = new Roleservices();
		String action = request.getParameter("action");
		if(action.equals("selectAll"))
		{
			selectAll(request,response,roleservices);
		}
		else if(action.equals("addAuthoritylist"))
		{
			Authorityservices authorityservices = new Authorityservices();
			ArrayList<Authority> authoritylist = authorityservices.selectauthority();
			request.setAttribute("authoritylist", authoritylist);
			request.getRequestDispatcher("admin-role-add.jsp").forward(request, response);
		}
		else if(action.equals("addOne"))
		{
			//添加一个role
			String roleName = request.getParameter("roleName");
			String roleDescribe = request.getParameter("roleDescribe");
			//如何判断一个角色选择了多个权限
			//暂时只会一个
			int authorityID = Integer.parseInt(request.getParameter("authorityID"));
			if(roleservices.addRole(roleName, roleDescribe,authorityID ))
			{
				selectAll(request, response, roleservices);
				
			}
			else {
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}	
		}
		
		else {
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
	}

	private void selectAll(HttpServletRequest request, HttpServletResponse response, Roleservices roleservices) throws ServletException, IOException {
		ArrayList<Role> rolelist = roleservices.selectRoles();
		request.setAttribute("rolelist", rolelist);
		request.getRequestDispatcher("admin-role.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
