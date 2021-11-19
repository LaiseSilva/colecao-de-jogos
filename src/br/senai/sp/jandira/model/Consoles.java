package br.senai.sp.jandira.model;

public enum Consoles {
	
	PLAYSTATION4 ("Plastation 4", 2013, 2499.00),
	NITENDOSWITCH ("Nitendo Switch" , 2004, 1859.99);
	
	private int anoDeLancamento;
	private String descricao;
	private double precoMedio;
	
	private Consoles(String descricao) {
		this.descricao = descricao;
	}
	
	private Consoles(String descricao, int anoDeLancamento, double precoMedio) {
		this.descricao = descricao; 
		this.anoDeLancamento = anoDeLancamento;
		this.precoMedio = precoMedio;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPrecoMedio() {
		return precoMedio;
	}
	
	
	
	
	

}
