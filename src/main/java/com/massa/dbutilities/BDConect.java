package com.massa.dbutilities;
import java.sql.*;

public class BDConect {
	
	public static Connection connectBD(ConectionTypes ct, String url) {
		
		Connection con = null;
		
		try {
			con =  DriverManager.getConnection(ct.getTipo()+url);
			System.out.println("Banco conectado!");
						
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;

		
	}
		
	public static void closeDB(Connection con) {
		try {
			if (!con.isClosed()) {}
				con.close();
				System.out.println("Conexão encerrada!");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
