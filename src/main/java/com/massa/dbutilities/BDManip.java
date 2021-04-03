package com.massa.dbutilities;
import java.sql.*;
import java.util.Date;

import com.massa.models.Usuario;

public class BDManip extends BDConect{
	
	
	public static boolean userExists(Usuario u){
		Connection con = BDConect.connectBD(ConectionTypes.SQLITE, dirDatabase + "tecnico.db");
		boolean result = false;
		
		try {
			String sql= "select * from tecnico where nome = ? and senha = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, u.getNome());
			pstmt.setString(2, u.getSenha());
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("nome").equals(u.getNome()) && rs.getString("senha").equals(u.getSenha())) {
					pstmt.close();
					BDConect.closeDB(con);
					result = true;
				}
				else {
					pstmt.close();
					BDConect.closeDB(con);
			}
		}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public static void userRegister (String n, String s, String ln, String em) {
		Connection con = BDConect.connectBD(ConectionTypes.SQLITE, dirDatabase + "tecnico.db");

		try {
			String sql = "insert into tecnico(id, nome, sobrenome, senha, email, nascimento) values (null, ?, ?, ?, ?, '01/01/2020')";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);
			pstmt.setString(2, ln);
			pstmt.setString(3, s);
			pstmt.setString(4, em);
			
			pstmt.executeUpdate();
			pstmt.close();
			BDConect.closeDB(con);
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
			BDConect.closeDB(con);
		}
		
	}
	
	
}