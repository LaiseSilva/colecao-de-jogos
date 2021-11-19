package br.senai.sp.jandira;

import br.senai.sp.jandira.model.Consoles;
import br.senai.sp.jandira.model.Fabricante;
import br.senai.sp.jandira.model.Jogo;
import br.senai.sp.jandira.repository.FabricanteRepository;
import br.senai.sp.jandira.repository.JogoRepository;
import br.senai.sp.jandira.ui.FrameJogo;

public class App {

	public static void main(String[] args) {
		
		/*Fabricante fabricante = new Fabricante();
		fabricante.setNome("isso isso");
		fabricante.setFundacao("2013");
		
		Jogo jogo1 = new Jogo();
		jogo1.setTitulo("ABADABADU");
		jogo1.setConsole(Consoles.NITENDOSWITCH);
		jogo1.setZerado(true);
		jogo1.setFabricante(fabricante);
		jogo1.setPreco("2000.0");
		jogo1.setObservacoes("trabalho para isso");
		
		Jogo jogo2 = new Jogo();
		jogo2.setTitulo("uuaauuua");
		jogo2.setConsole(Consoles.PLAYSTATION4);
		jogo2.setZerado(false);
		jogo2.setFabricante(fabricante);
		jogo2.setPreco("3000.0");
		jogo2.setObservacoes("vale a pena");
		
		
		JogoRepository repositorio = new JogoRepository(2);
		repositorio.gravar(jogo1, 0);
		repositorio.gravar(jogo2, 1);
		
		
		
		for(Jogo jogo : repositorio.listarJogos() ) {
			System.out.println(jogo.getTitulo());
			System.out.println(jogo.getPreco());
		}*/
		
		FrameJogo jogo = new FrameJogo();
		jogo.setVisible(true);
		
		
		

	}

}
