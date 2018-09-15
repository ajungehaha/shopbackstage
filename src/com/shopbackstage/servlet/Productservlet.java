package com.shopbackstage.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.w3c.dom.css.ElementCSSInlineStyle;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.shopbackstage.dao.Classdao;
import com.shopbackstage.domain.Class;
import com.shopbackstage.domain.Product;
import com.shopbackstage.services.Classservices;
import com.shopbackstage.services.Productservices;

/**
 * Servlet implementation class Productservlet
 */
@WebServlet("/Productservlet")
public class Productservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productservlet() {
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
		//获取session
		HttpSession session = request.getSession();
		//获取请求
		String action = request.getParameter("action");
		//获取下层servles对象
		Classservices classservices = new Classservices();
		Productservices productservices = new Productservices();
		if(action.equals("productlist"))
		{
			ArrayList<Class> classlist = classservices.queryClass();
			session.setAttribute("classlist", classlist);
			Class class1 = (Class)classlist.get(0);
			ArrayList<Product> productlist = productservices.selectProducts(class1.getClassID());
			request.setAttribute("productlist", productlist);
			request.getRequestDispatcher("product-list.jsp").forward(request, response);
		}
		else if(action.equals("selectProductAsClass")) {
			int classID = Integer.parseInt(request.getParameter("classID"));
			ArrayList<Product> productlist = productservices.selectProducts(classID);
			request.setAttribute("productlist", productlist);
			request.getRequestDispatcher("product-list.jsp").forward(request, response);
		}
		else if(action.equals("selectOne"))
		{
			String productName1 = request.getParameter("productName");
			ArrayList<Product> productlist = productservices.selectOneProduct(productName1);
			request.setAttribute("productlist", productlist);
			request.getRequestDispatcher("product-list.jsp").forward(request, response);
			
		}
		else if(action.equals("changeState"))
		{
			//改变状态
			int productState =Integer.parseInt(request.getParameter("productState")) ;
			int productID = Integer.parseInt(request.getParameter("productID"));
			productservices.changeProductState(productID, productState);
			
			ArrayList<Class> classlist = classservices.queryClass();
			session.setAttribute("classlist", classlist);
			Class class1 = (Class)classlist.get(0);
			ArrayList<Product> productlist = productservices.selectProducts(class1.getClassID());
			request.setAttribute("productlist", productlist);
			request.getRequestDispatcher("product-list.jsp").forward(request, response);
			
			
		}
		else if(action.equals("deleteProduct"))
		{
			int productID = Integer.parseInt(request.getParameter("productID"));
			productservices.deleteProduct(productID);
			ArrayList<Class> classlist = classservices.queryClass();
			session.setAttribute("classlist", classlist);
			Class class1 = (Class)classlist.get(0);
			ArrayList<Product> productlist = productservices.selectProducts(class1.getClassID());
			request.setAttribute("productlist", productlist);
			request.getRequestDispatcher("product-list.jsp").forward(request, response);
			
		}
		else if(action.equals("productadd")){
			ArrayList<Class> classlist = classservices.queryClass();
			request.setAttribute("classlist", classlist);
			request.getRequestDispatcher("productadd.jsp").forward(request, response);
		}
		else if(action.equals("addOne"))
		{
			//获取数据 添加商品的地址
			System.out.println(request.getParameter("productName"));
			String productName = request.getParameter("productName");
			System.out.println(request.getParameter("productPrice"));
			double productPrice =Double.parseDouble(request.getParameter("productPrice"));
			double productCsot = Double.parseDouble(request.getParameter("productCsot"));
			int productStock =Integer.parseInt(request.getParameter("productStock"));
			String productAdress = request.getParameter("productAdress");
			String productCast = request.getParameter("productCast");
			String Press = request.getParameter("Press");
			String pressTime = request.getParameter("pressTime");
			String bookNum = request.getParameter("bookNum");
			String printingTime = request.getParameter("printingTime");
			String authorName = request.getParameter("authorName");
			int lessIntegral = Integer.parseInt(request.getParameter("lessIntegral"));
			
			String className = request.getParameter("className");
			Product product = new Product(productAdress, productName, productPrice, productCsot, productStock, 0, 1, lessIntegral, Press, pressTime, bookNum, printingTime, authorName, productCast);
			//添加商品
			productservices.addProduct(className, product);
			//添加商品图片页面
			//先查找productID
			int productID = productservices.selectProductID(productName);
			request.setAttribute("productID", productID);
			request.getRequestDispatcher("addpicture.jsp").forward(request, response);
			
		}
		else if(action.equals("addOnepicture"))
		{
			SmartUpload smartUpload = new SmartUpload();
			ServletConfig config = this.getServletConfig();
			smartUpload.initialize(config, request, response);
			String picture=request.getParameter("picture");
			int productID = Integer.parseInt(request.getParameter("productID"));
			// 上传文件
			try {smartUpload.upload();
					// 得到上传的文件对象
				com.jspsmart.upload.File smartFile = smartUpload.getFiles().getFile(0);
				String name = smartFile.getFileName();
				smartFile.saveAs("E:\\jsp综合实训\\shopbackstage\\WebContent\\img"+name, SmartUpload.SAVE_AUTO);
				String pictureAdress = "/img/"+name;
				if(productservices.addOneicture(productID, pictureAdress))
				{
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
		}
		else {
			request.getRequestDispatcher("404.jsp").forward(request, response);
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
