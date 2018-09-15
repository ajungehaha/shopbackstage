package com.shopbackstage.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopbackstage.dao.Authoritydao;
import com.shopbackstage.domain.Authority;
import com.shopbackstage.services.Authorityservices;
import com.shopbackstage.services.Roleservices;

/**
 * Servlet implementation class Authorityservlet
 */
@WebServlet("/Authorityservlet")
public class Authorityservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authorityservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Authorityservices authorityservices = new Authorityservices();
		String action = request.getParameter("action");
		if(action.equals("selectAll"))
		{
			selectAll(request,response,authorityservices);
		}
	}

	private void selectAll(HttpServletRequest request, HttpServletResponse response,
			Authorityservices authorityservices) throws ServletException, IOException {
		ArrayList<Authority> authoritylist = authorityservices.selectauthority();
		request.setAttribute("authoritylist", authoritylist);
		request.getRequestDispatcher("admin-permission.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
