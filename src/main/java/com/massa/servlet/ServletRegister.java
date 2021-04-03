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
	private final String dirDatabase = System.getProperty("user.home") + System.getProperty("file.separator") + "eclipse-workspace" + System.getProperty("file.separator") + "Massa" + System.getProperty("file.separator") + "Database" + System.getProperty("file.separator");
	private BDManip bdm = new BDManip(dirDatabase);
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	 		
	 		String u = request.getParameter("username");
			String s = request.getParameter("password");

			bdm.userRegister(u, s);
	 	
 		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doGet(request, response);
	}
}
