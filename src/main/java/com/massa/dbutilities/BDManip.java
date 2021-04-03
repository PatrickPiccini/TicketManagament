package com.massa.dbutilities;
import java.sql.*;
import java.util.Date;

import com.massa.models.Usuario;

public class BDManip {
	private String dirDatabase;

	public BDManip (String dir) {
		this.dirDatabase = dir;
	}
	
	public String getDirDatabase() {
		return dirDatabase;
	}
	

	
	public boolean userExists(Usuario u){
		Connection con = BDConect.connectBD(ConectionTypes.SQLITE, dirDatabase + "tecnico.db");
		
		try {
			String sql= "select * from tecnico where nome = ? and senha = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, u.getNome());
			pstmt.setString(2, u.getSenha());
			
			System.out.println("1");
			ResultSet rs = pstmt.executeQuery(sql);

			if (rs.getString("nome").equals(u.getNome()) && rs.getString("senha").equals(u.getSenha())) {
				pstmt.close();
				BDConect.closeDB(con);
				return true;
			}
			
			else {
				pstmt.close();
				BDConect.closeDB(con);
				return false;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}
	
	public void userRegister (String n, String s) {
		Connection con = BDConect.connectBD(ConectionTypes.SQLITE, dirDatabase + "tecnico.db");

		try {
			String sql = "insert into tecnico(nome, senha, nascimento) values (?, ?, '01/01/2020')";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);
			pstmt.setString(2, s);
			
			pstmt.executeUpdate();
			pstmt.close();
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
}