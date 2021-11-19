package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Jogo;

public class JogoRepository {
	
	private Jogo[] colecao;
	
	public JogoRepository() {
		this.colecao = new Jogo[10];
	}
	
	public JogoRepository(int quantidadeDeJogos) {
		this.colecao = new Jogo[quantidadeDeJogos];
	}
	
	public void gravar(Jogo jogo, int posicao) {
		colecao[posicao] = jogo;
	}
	
	public Jogo[] listarJogos(){
		return colecao;
	} 
	
	public Jogo getJogo(int posicao) {
		return colecao[posicao];
	}
	
	public int getTamanho() {
		return colecao.length;
	}

}
