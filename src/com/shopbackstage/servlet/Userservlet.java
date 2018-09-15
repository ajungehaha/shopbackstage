package com.shopbackstage.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopbackstage.domain.User;
import com.shopbackstage.services.Userservices;

/**
 * Servlet implementation class Userservlet
 */
@WebServlet("/Userservlet")
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		Userservices sUserservices = new Userservices();
		if(action.equals("selectAll"))
		{
			selectAll(request,response,sUserservices);
		}
		else if(action.equals("selectOne"))
		{
			selectOne(request,response,sUserservices);
		}
	}

	
	private void selectOne(HttpServletRequest request, HttpServletResponse response, Userservices sUserservices) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		ArrayList<User> userlist = sUserservices.selectUser(userName);
		request.setAttribute("userlist", userlist);
		request.getRequestDispatcher("user-list.jsp").forward(request, response);
		
	}

	private void selectAll(HttpServletRequest request, HttpServletResponse response, Userservices sUserservices) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<User> list = sUserservices.queryUsers();
		request.setAttribute("userlist", list);
		request.getRequestDispatcher("user-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
