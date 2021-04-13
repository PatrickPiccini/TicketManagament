package com.massa.dbutilities;
import java.sql.*;
import java.util.ArrayList;

import org.apache.catalina.util.ToStringUtil;

import com.massa.models.Usuario;

public class BDManip extends BDConect{
	
	
	
	private static Integer countUsers() {
		Connection con = connectBD(ConectionTypes.SQLITE, dirDatabase + "tecnico.db");
		String sql = "select count(*) as soma from tecnico";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery();){
			while(rs.next()) {
				return  rs.getInt("soma");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
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
		} 
		catch (SQLException e) { 
			e.printStackTrace();
		}
		BDConect.closeDB(con);
		return result;
	}
	
	
	public static Integer getTecID(Usuario u){
		Connection con = BDConect.connectBD(ConectionTypes.SQLITE, dirDatabase + "tecnico.db");
		
		try {
			String sql= "select id from tecnico where nome = ? and senha = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, u.getNome());
			pstmt.setString(2, u.getSenha());
			
			ResultSet rs = pstmt.executeQuery();
			
			closeDB(con);
			return rs.getInt("id");
		} 
		catch (SQLException e) { 
			e.printStackTrace();
		}
		BDConect.closeDB(con);
		return null;
	}
	
	
	
	public static void userRegister (String n, String s, String ln, String em) {
		Connection con = BDConect.connectBD(ConectionTypes.SQLITE, dirDatabase + "tecnico.db");

		try {
			String sql = "insert into tecnico(id, nome, sobrenome, senha, email, nascimento) values (NULL, ?, ?, ?, ?, '01/01/2020')";
			
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
	
	
	public static ArrayList<String> viewTickets (Integer id) {
		try (Connection con = connectBD(ConectionTypes.SQLITE, dirDatabase + "tecnico.db");)
		{
			ArrayList<String> chamados = new ArrayList<String>();
			
			String sql = "SELECT * FROM CHAMADO WHERE IDTECNICO = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				chamados.add(Integer.toString(rs.getInt("IDTECNICO")));
				chamados.add(Integer.toString(rs.getInt("IDCHAMADO")));
				chamados.add(rs.getString("DESCRICAO"));
			}
			
			closeDB(con);
			return chamados;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}