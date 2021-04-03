package com.massa.dbutilities;
import java.sql.*;

abstract class BDConect {
	static final String dirDatabase = System.getProperty("user.home") + System.getProperty("file.separator") + "eclipse-workspace" + System.getProperty("file.separator") + "Massa" + System.getProperty("file.separator") + "Database" + System.getProperty("file.separator");
	
	
	static Connection connectBD(ConectionTypes ct, String url) {
		
		Connection con = null;
		
		try {
			con =  DriverManager.getConnection(ct.getTipo()+url);
			System.out.println("Banco conectado!");
						
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
		
	static void closeDB(Connection con) {
		try {
			if (!con.isClosed()) {}
				con.close();
				System.out.println("Conexão encerrada!");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
