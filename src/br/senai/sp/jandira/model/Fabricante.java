package br.senai.sp.jandira.model;

public class Fabricante {
	
	private String nome;
	private int anoDeFundacao;
	private String sobre;
	
	public Fabricante() {
	 this.nome = "sony";
	}
	
	public Fabricante(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getFundacao() {
		return anoDeFundacao;
	}
	
	public void setFundacao(String fundacao) {
		this.anoDeFundacao = Integer.parseInt(fundacao);
	}
	
	public String getSobre() {
		return sobre;
	}
	
	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
	
	

}
