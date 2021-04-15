package com.massa.models;

public class Chamado {
	private Integer idChamado;
	private Integer idTecnico;
	private String descricao;
	
	
	public Chamado(Integer idC, Integer idT, String desc) {
		this.idChamado = idC;
		this.idTecnico = idT;
		this.descricao = desc;
		
	}
	
	@Override
	public String toString() {	
		return getIdChamado() + "\n" + getIdTecnico() + "\n" + getDescricao();
	}
	
	public Integer getIdChamado() {
		return idChamado;
	}
	public void setIdChamado(Integer idChamado) {
		this.idChamado = idChamado;
	}
	
	
	public Integer getIdTecnico() {
		return idTecnico;
	}
	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
		
		
		}
	
	
}
