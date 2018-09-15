package com.shopbackstage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopbackstage.dao.Admindao;
import com.shopbackstage.dao.Orderdao;
import com.shopbackstage.dao.Productdao;
import com.shopbackstage.dao.Userdao;
import com.shopbackstage.services.Adminservices;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Adminservices sAdminservices = new Adminservices();
		String action = request.getParameter("action");
		
		if(action.equals("login"))
		{
			String adminName = request.getParameter("adminName");
			String adminPassword = request.getParameter("adminPassword");
			if(sAdminservices.loginTest(adminName, adminPassword))
			{
				//保存用户信息
				session.setAttribute("adminName", adminName);
				response.setContentType("charset=utf-8");
				response.setCharacterEncoding("utf-8");
				Userdao userdao = new Userdao();
				Admindao admindao = new Admindao();
				Orderdao orderdao = new Orderdao();
				Productdao productdao = new Productdao();
				int userCount = userdao.selectUserCount();
				request.setAttribute("userCount", userCount);
				int adminCount = admindao.selectAdminCount();
				request.setAttribute("adminCount", adminCount);
				int productCount = productdao.selectProductCount();
				request.setAttribute("productCount", productCount);
				int orderCount = orderdao.selectOrderCount();
				request.setAttribute("orderCount", orderCount);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
				request.setAttribute("flag", "error");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if(action.equals("change"))
		{
			String adminName = (String) session.getAttribute("adminName");
			String adminPassword = request.getParameter("newpassword");
			if(sAdminservices.changPassword(adminName, adminPassword))
				//修改密码成功
				request.getRequestDispatcher("change-password-success.jsp").forward(request, response);
			else {
				request.getRequestDispatcher("404.jsp");
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
