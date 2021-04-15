package com.massa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.massa.models.Usuario;
import com.massa.dbutilities.*;
import com.massa.models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Boolean resposta;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String u = (String)request.getParameter("username");
		String s = (String)request.getParameter("password");
		
		
		Usuario loginUser = new Usuario(u, s);
		
		ArrayList<Object> userExist = BDManip.userExists(loginUser);
		
		if ((boolean) userExist.get(0)) {
			response.sendRedirect("teste.jsp?idTecnico=" + userExist.get(1));
			}
		else {
			response.getWriter().append(":( deu erro");
			}
		
	}

}