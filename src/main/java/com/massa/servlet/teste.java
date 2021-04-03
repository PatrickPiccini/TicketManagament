package com.massa.servlet;
import java.sql.*;

import com.massa.dbutilities.BDConect;
import com.massa.dbutilities.ConectionTypes;


public class teste {
	
	private final static String dirDatabase = System.getProperty("user.dir") + System.getProperty("path.separator") + "Massa" + System.getProperty("path.separator") + "Database" + System.getProperty("path.separator");
	
	public static void main(String[] args) {
		Connection con = BDConect.connectBD(ConectionTypes.SQLITE, dirDatabase + "tecnico.db");
		
		System.out.println(dirDatabase + "tecnico.db");
		
		try {
			String sql= "";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			/*pstmt.setString(1, "Jonas");
			pstmt.setString(2, "000000");*/
			
			
			ResultSet rs = pstmt.executeQuery(sql);

			System.out.println(rs.getString(1));
		
		} catch (SQLException e) {
			System.out.println(e);
		}		
		
	}
}
