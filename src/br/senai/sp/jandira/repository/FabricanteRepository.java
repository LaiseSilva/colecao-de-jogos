package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Fabricante;

public class FabricanteRepository {

	private Fabricante[] colecaoFabricante;

	public FabricanteRepository() {
		Fabricante rockstar = new Fabricante();
		rockstar.setNome("Rockstar");

		Fabricante sony = new Fabricante();
		sony.setNome("Sony");

		colecaoFabricante = new Fabricante[3];
		colecaoFabricante[1] = sony;
		colecaoFabricante[0] = rockstar;

	}

	public FabricanteRepository(int quantidadeDeJogos) {
		colecaoFabricante = new Fabricante[quantidadeDeJogos];
	}

	public void gravar(Fabricante fabricante, int posicao) {
		colecaoFabricante[posicao] = fabricante;
	}

	public Fabricante getNomeFabricante(int posicao) {
		return colecaoFabricante[posicao];
	}

	public Fabricante[] getListaDeFabricantes() {
		return colecaoFabricante;
	}

}
