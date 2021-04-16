package com.massa.dbutilities;
import java.sql.*;
import java.util.ArrayList;

import org.apache.catalina.util.ToStringUtil;

import com.massa.models.Chamado;
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
	
	public static ArrayList<Object> userExists(Usuario u){
		Connection con = BDConect.connectBD(ConectionTypes.SQLITE, dirDatabase + "tecnico.db");
		ArrayList<Object> result = new ArrayList<Object>();
		
		try {
			String sql= "select * from tecnico where nome = ? and senha = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, u.getNome());
			pstmt.setString(2, u.getSenha());
			
			ResultSet rs = pstmt.executeQuery();
			System.out.println(rs.getString("senha"));
			
			if (rs.getString("nome").equals(u.getNome()) && rs.getString("senha").equals(u.getSenha())) {
				while (rs.next()) {
					result.add(true);
					result.add(rs.getInt("id"));					
				}
			}
			else {
				result.add(false);
				}
			}
		 
		catch (SQLException e) {
			result.add(false);
			e.printStackTrace();
		}
		
		BDConect.closeDB(con);
		return result;
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
	
	
	public static ArrayList<Chamado> viewTickets (Integer id) {
		try (Connection con = connectBD(ConectionTypes.SQLITE, dirDatabase + "tecnico.db");)
		{
			ArrayList<Chamado> chamados = new ArrayList<Chamado>();
			
			String sql = "SELECT * FROM CHAMADO WHERE IDTECNICO = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Chamado chamado = new Chamado(rs.getInt("IDCHAMADO"), rs.getInt("IDTECNICO"), rs.getString("DESCRICAO"));

				chamados.add(chamado);
			}
			
			closeDB(con);
			return chamados;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}