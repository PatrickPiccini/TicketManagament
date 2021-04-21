package com.massa.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.massa.dbutilities.BDManip;


@WebServlet(description = "Servlet que ficará responsável pelo recebimento do novo cadastro e criação de seu registro no BD", urlPatterns = { "/ServletRegister" })
public class ServletRegister extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	 		
			response.setContentType("text/html");
			
	 		String u = request.getParameter("username");
	 		String ln = request.getParameter("lastname");
	 		String em = request.getParameter("email");
			String s = request.getParameter("password");

			BDManip.userRegister(u, s, ln, em);
	 	
 		
		response.sendRedirect("index.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doGet(request, response);
	}
}
