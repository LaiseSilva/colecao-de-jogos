package br.senai.sp.jandira.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.senai.sp.jandira.model.Consoles;
import br.senai.sp.jandira.model.Fabricante;
import br.senai.sp.jandira.model.Jogo;
import br.senai.sp.jandira.repository.FabricanteRepository;
import br.senai.sp.jandira.repository.JogoRepository;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameJogo extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtPreco;
	private int posicao;

	public FrameJogo() {

		setTitle("Cole\u00E7\u00E3o de Jogos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("T\u00EDtulo do jogo:");
		lblTitulo.setBounds(10, 32, 89, 14);
		contentPane.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(98, 29, 166, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblFabricante = new JLabel("Fabricante: ");
		lblFabricante.setBounds(10, 66, 77, 14);
		contentPane.add(lblFabricante);

		DefaultComboBoxModel<String> listaFabricantes = new DefaultComboBoxModel<String>();
		JComboBox comboBoxFabricante = new JComboBox(listaFabricantes);
		comboBoxFabricante.setBounds(98, 62, 166, 22);

		FabricanteRepository fabricantes = new FabricanteRepository();

		for (Fabricante fabricante : fabricantes.getListaDeFabricantes()) {
			listaFabricantes.addElement(fabricante.getNome());
		}
		contentPane.add(comboBoxFabricante);

		JButton btnNovoFabricante = new JButton("Outro");
		btnNovoFabricante.setBounds(274, 62, 91, 22);
		contentPane.add(btnNovoFabricante);

		JLabel lblConsole = new JLabel("Console: ");
		lblConsole.setBounds(10, 99, 58, 14);
		contentPane.add(lblConsole);

		DefaultComboBoxModel<String> listaDeConsoles = new DefaultComboBoxModel<String>();
		for (Consoles consoles : Consoles.values()) {
			listaDeConsoles.addElement(consoles.getDescricao());
		}

		JComboBox comboBoxConsole = new JComboBox(listaDeConsoles);
		comboBoxConsole.setBounds(98, 95, 166, 22);
		contentPane.add(comboBoxConsole);

		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(10, 133, 77, 14);
		contentPane.add(lblPreco);

		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(98, 130, 166, 20);
		contentPane.add(txtPreco);

		JCheckBox chckbxZerado = new JCheckBox("Zerado");
		chckbxZerado.setBounds(98, 163, 109, 23);
		chckbxZerado.setSelected(false);
		contentPane.add(chckbxZerado);

		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservacoes.setBounds(10, 193, 91, 14);
		contentPane.add(lblObservacoes);

		JScrollPane scrollPaneObservacoes = new JScrollPane();
		scrollPaneObservacoes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneObservacoes.setBounds(98, 193, 185, 105);
		contentPane.add(scrollPaneObservacoes);

		JEditorPane editorPaneObeservacoes = new JEditorPane();
		scrollPaneObservacoes.setViewportView(editorPaneObeservacoes);

		JLabel lblMeusJogos = new JLabel("Meus jogos:");
		lblMeusJogos.setBounds(387, 29, 89, 14);
		contentPane.add(lblMeusJogos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(387, 44, 214, 255);
		contentPane.add(scrollPane);

		DefaultListModel<String> modelJogos = new DefaultListModel<String>();
		JList listJogos = new JList(modelJogos);
		scrollPane.setViewportView(listJogos);

		JButton btnSalvarJogo = new JButton("Salvar");
		btnSalvarJogo.setForeground(Color.WHITE);
		btnSalvarJogo.setBackground(Color.BLUE);
		btnSalvarJogo.setBounds(108, 306, 166, 39);
		contentPane.add(btnSalvarJogo);

		JogoRepository colecao = new JogoRepository(3);

		btnSalvarJogo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				Jogo jogo = new Jogo();
				jogo.setTitulo(txtTitulo.getText());
				jogo.setFabricante(fabricantes.getNomeFabricante(comboBoxFabricante.getSelectedIndex()));
				jogo.setConsole(determinarConsole(comboBoxConsole.getSelectedIndex()));
				jogo.setPreco(txtPreco.getText());
				jogo.setZerado(chckbxZerado.isSelected());
				jogo.setObservacoes(editorPaneObeservacoes.getText());

				colecao.gravar(jogo, posicao);
				posicao++;

				modelJogos.addElement(jogo.getTitulo());

				if (posicao == colecao.getTamanho()) {
					btnSalvarJogo.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Sua coleção já está cheia!!");
				}
			}
		});

		listJogos.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				Jogo jogo = colecao.getJogo(listJogos.getSelectedIndex());
				txtTitulo.setText(jogo.getTitulo());
				comboBoxFabricante.setSelectedIndex(fabricantes.getIndexFabricante(jogo.getFabricante()));
				comboBoxConsole.setSelectedIndex(jogo.getConsole().ordinal());
				txtPreco.setText(jogo.getPreco());
				chckbxZerado.setSelected(jogo.isZerado());
				editorPaneObeservacoes.setText(jogo.getObservacoes());

			}
		});

		JButton btnVoltarJogo = new JButton("<");
		btnVoltarJogo.setForeground(Color.WHITE);
		btnVoltarJogo.setBackground(Color.BLUE);
		btnVoltarJogo.setBounds(387, 310, 89, 31);
		contentPane.add(btnVoltarJogo);

		btnVoltarJogo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listJogos.setSelectedIndex(listJogos.getSelectedIndex() - 1);
			}
		});

		JButton btnAvancarJogo = new JButton(">");
		btnAvancarJogo.setForeground(Color.WHITE);
		btnAvancarJogo.setBackground(Color.BLUE);
		btnAvancarJogo.setBounds(512, 310, 89, 31);
		contentPane.add(btnAvancarJogo);

		btnAvancarJogo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listJogos.setSelectedIndex(listJogos.getSelectedIndex() + 1);
			}
		});

	}

	private Consoles determinarConsole(int selecaoConsole) {

		if (selecaoConsole == 0) {
			return Consoles.PLAYSTATION4;
		} else {
			return Consoles.NITENDOSWITCH;
		}

	}

}
