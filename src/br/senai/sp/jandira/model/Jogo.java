package br.senai.sp.jandira.model;

public class Jogo {
	
	private String titulo;
	private Fabricante fabricante;
	private Consoles console;
	private boolean zerado;
	private double preco;
	private String observacoes;
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public Consoles getConsole() {
		return console;
	}
	
	public void setConsole(Consoles console) {
		this.console = console;
	}
	
	public boolean isZerado() {
		return zerado;
	}
	
	public void setZerado(boolean zerado) {
		this.zerado = zerado;
	}
	
	public String getPreco() {
		String preco = String.valueOf(this.preco);
		return preco;
	}
	
	public void setPreco(String preco) {
		this.preco = Double.parseDouble(preco);
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
	
	

}
