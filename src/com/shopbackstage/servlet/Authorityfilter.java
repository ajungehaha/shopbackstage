package com.shopbackstage.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopbackstage.services.Adminservices;

/**
 * Servlet Filter implementation class Authorityfilter
 */
@WebFilter("/*")
public class Authorityfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Authorityfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		HttpSession session = request2.getSession();
		String url = request2.getRequestURI();
		
		if(url.contains("login.jsp"))
		{
		}	
		else if(url.contains("Loginservlet"))
		{
			
		}
		else if(url.contains("index.jsp")){
			
		}
		else if(url.contains("order-list.jsp")){
			
		}
		
		//跳过login
		else
		{
			System.out.println(url);
			String adminName =(String) session.getAttribute("adminName");
			if(!adminName.equals("admin"))
			{	Adminservices adminservices = new Adminservices();
				ArrayList<String> list = adminservices.selectAuthorityAdress(adminName);
				//获取访问的url
				
				
				boolean flag = false;
				Iterator<String> iterator = list.iterator();
				while(iterator.hasNext())
				{
					String authorityAdress = iterator.next();
					if(url.contains(authorityAdress))
					{
						flag=true;
					}
				}
				if(!flag)
				{
					request2.getRequestDispatcher("authorityno.jsp").forward(request2, response2);
				}
		}
		
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
