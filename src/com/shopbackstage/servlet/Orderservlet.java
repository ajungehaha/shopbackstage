package com.shopbackstage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import com.shopbackstage.domain.Order;
import com.shopbackstage.domain.Product;
import com.shopbackstage.services.Orderservices;

/**
 * Servlet implementation class Orderservlet
 */
@WebServlet("/Orderservlet")
public class Orderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Orderservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("charset='utf-8'");
		response.setCharacterEncoding("utf-8");
		String  action = request.getParameter("action");
		Orderservices orderservices = new Orderservices();
		if(action.equals("changeAdress"))
		{
			int orderID =Integer.parseInt(request.getParameter("orderID"));
			String adressName = request.getParameter("adressName");
			if(orderservices.changeOrderAdress(orderID, adressName))
			{
				selectOrderAsorderID(request,response,orderservices);			
			}
			else {
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		}
		else if(action.equals("selectOrderAsorderID"))
		{
			selectOrderAsorderID(request,response,orderservices);
			
		}
		else if(action.equals("fahuo"))
		{
			int orderID  = Integer.parseInt(request.getParameter("orderID"));
			if(orderservices.fahuo(orderID))
			{
				selectOrderAsorderID(request,response,orderservices);
			}
			
		}
		else if(action.equals("tuikuan"))
		{
			int orderID  = Integer.parseInt(request.getParameter("orderID"));
			if(orderservices.tuikuan(orderID))
			{
				selectOrderAsorderID(request,response,orderservices);
			}
			
		}
		
		else {
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
	}

	private void selectOrderAsorderID(HttpServletRequest request, HttpServletResponse response,
			Orderservices orderservices) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("charset='utf-8'");
		int orderID =Integer.parseInt(request.getParameter("orderID"));
		System.out.println(orderID);
		ArrayList<Order> orderlist = orderservices.selectordersASid(orderID);
		System.out.println(orderlist);
		request.setAttribute("orderlist", orderlist);
		ArrayList<Product> productlist = orderservices.selectProductAsOrderID(orderID);
		request.setAttribute("productlist", productlist);
		request.getRequestDispatcher("order-list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
