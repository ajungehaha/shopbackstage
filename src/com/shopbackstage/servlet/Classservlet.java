package com.shopbackstage.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopbackstage.domain.Class;
import com.shopbackstage.services.Classservices;

/**
 * Servlet implementation class Classservlet
 */
@WebServlet("/Classservlet")
public class Classservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Classservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		//获取services
		Classservices sClassservices = new Classservices();
		//获取请求 action
		String action = request.getParameter("action");
		//判断请求进行操作、
		//请求获取全部的分类信息
		if(action.equals("selectAll"))
		{
			selectAll(sClassservices,request,response);
			
		}
		//请求获取一个分类的信息
		if(action.equals("selectclass"))
		{
			//进行查询一个分类信息的操作
			//获取需要查询的分类的名称
			String className1 = request.getParameter("className");
			ArrayList<Class> list = sClassservices.selectclass(className1);
			request.setAttribute("classlist", list);
			request.getRequestDispatcher("class-list.jsp").forward(request, response);
		}
		//请求添加一个分类
		if(action.equals("addclass")) {
			String className = request.getParameter("className");
			String classDescribe = request.getParameter("classDescribe");
			if(sClassservices.addclass(className, classDescribe)) {
				//如果添加成功就再次返回class-list页面 查询全部
				selectAll(sClassservices, request, response);
			}
			else {
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		}
	}

	private void selectAll(Classservices sClassservices,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//进行查询所有的操作
		ArrayList<Class> list = sClassservices.queryClass();
		request.setAttribute("classlist", list);
		request.getRequestDispatcher("class-list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
