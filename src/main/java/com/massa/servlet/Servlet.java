package com.massa.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.massa.dbutilities.BDConect;
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
	private final String dirDatabase = System.getProperty("user.home") + System.getProperty("file.separator") + "eclipse-workspace" + System.getProperty("file.separator") + "Massa" + System.getProperty("file.separator") + "Database" + System.getProperty("file.separator");
	private BDManip bdm = new BDManip(dirDatabase);
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String u = request.getParameter("username");
		String s = request.getParameter("password");
		
		Usuario loginUser = new Usuario(u, s);
		System.out.println(dirDatabase + "tecnico.db");
		boolean userExists = bdm.userExists(loginUser);
		
		if (userExists) {
			response.sendRedirect("home.html");	
		}
		else {
			response.sendRedirect("");
			}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
