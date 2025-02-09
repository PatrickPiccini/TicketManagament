package com.massa.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.massa.dbutilities.BDManip;
import com.massa.models.Usuario;


@WebServlet(description = "Servlet que ficar� respons�vel pelo recebimento do novo cadastro e cria��o de seu registro no BD", urlPatterns = { "/ServletRegister" })
public class ServletRegister extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	 		
			response.setContentType("text/html");
			
	 		String u = request.getParameter("username");
	 		String ln = request.getParameter("lastname");
	 		String em = request.getParameter("email");
			String s = request.getParameter("password");

			BDManip.userRegister(u, s, ln, em);
			
			Usuario user = new Usuario(u, s);
			ArrayList<Object> userExist = BDManip.userExists(user);
			
			response.sendRedirect("teste.jsp?idTecnico=" + (Integer) userExist.get(1));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doGet(request, response);
	}
}
