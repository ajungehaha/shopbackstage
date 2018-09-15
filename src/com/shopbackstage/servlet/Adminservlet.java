package com.shopbackstage.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.css.ElementCSSInlineStyle;

import com.shopbackstage.dao.Admindao;
import com.shopbackstage.dao.Orderdao;
import com.shopbackstage.dao.Productdao;
import com.shopbackstage.dao.Userdao;
import com.shopbackstage.domain.Admin;
import com.shopbackstage.domain.Role;
import com.shopbackstage.services.Adminservices;
import com.shopbackstage.services.Roleservices;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Adminservlet")
public class Adminservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated 		method stub

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Adminservices sAdminservices = new Adminservices();
		String action = request.getParameter("action");
		
		if(action.equals("selectAll"))
		{
			
			selectAll(request, response, sAdminservices);
			}
		
		else if(action.equals("selectOne"))
		{
			String adminName1 = request.getParameter("adminName");
			ArrayList<Admin> adminlist = sAdminservices.selectAdmin(adminName1);
			request.setAttribute("adminlist", adminlist);
			request.getRequestDispatcher("admin-list.jsp").forward(request, response);
		}
		else if(action.equals("addrolelist"))
		{
			//进行进入管理员添加是的获取列表操作
			Roleservices roleservices = new Roleservices();
			ArrayList<Role> rolelist = roleservices.selectRoles();
			request.setAttribute("rolelist", rolelist);
			request.getRequestDispatcher("admin-add.jsp").forward(request, response);
		}
		else if (action.equals("addAdmin")) {
			//进行管理员的添加
			String adminName = request.getParameter("adminName");
			String adminPassword = request.getParameter("adminPassword");
			String adminIphone = request.getParameter("adminIphone");
			String adminEmail = request.getParameter("adminEmail");
			String adminRole =request.getParameter("adminRole");
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-DD");
			
			String adminJoinTime =format.format(date).toString()+"";
			Admin admin = new Admin(adminName, adminPassword, adminIphone, adminEmail, adminRole, adminJoinTime, 1);
			if(sAdminservices.addone(admin)) {
				request.getRequestDispatcher("admin-list.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
			
		}
		else {
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
	}

	private void selectAll(HttpServletRequest request, HttpServletResponse response, Adminservices sAdminservices) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//查询管理员列表
		
		ArrayList<Admin> adminlist = sAdminservices.selectAdmins();
		request.setAttribute("adminlist", adminlist);
		request.getRequestDispatcher("admin-list.jsp").forward(request, response);;
		
	}

}
