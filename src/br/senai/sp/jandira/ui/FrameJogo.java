package br.senai.sp.jandira.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.jandira.model.Jogo;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class FrameJogo extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtPreco;

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

		JComboBox comboBoxFabricante = new JComboBox();
		comboBoxFabricante.setBounds(98, 62, 166, 22);
		contentPane.add(comboBoxFabricante);

		JButton btnNovoFabricante = new JButton("Outro");
		btnNovoFabricante.setBounds(274, 62, 91, 22);
		contentPane.add(btnNovoFabricante);

		JLabel lblConsole = new JLabel("Console: ");
		lblConsole.setBounds(10, 99, 58, 14);
		contentPane.add(lblConsole);

		JComboBox comboBoxConsole = new JComboBox();
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
		contentPane.add(chckbxZerado);

		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservacoes.setBounds(10, 193, 91, 14);
		contentPane.add(lblObservacoes);
		
		JScrollPane scrollPaneObservacoes = new JScrollPane();
		scrollPaneObservacoes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneObservacoes.setBounds(98, 193, 166, 105);
		contentPane.add(scrollPaneObservacoes);
		
		JEditorPane editorPaneObeservacoes = new JEditorPane();
		scrollPaneObservacoes.setViewportView(editorPaneObeservacoes);

		JLabel lblMeusJogos = new JLabel("Meus jogos:");
		lblMeusJogos.setBounds(387, 29, 89, 14);
		contentPane.add(lblMeusJogos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(387, 44, 214, 255);
		contentPane.add(scrollPane);

		JList listJogos = new JList();
		scrollPane.setViewportView(listJogos);

		JButton btnSalvarJogo = new JButton("Salvar");
		btnSalvarJogo.setForeground(Color.WHITE);
		btnSalvarJogo.setBackground(Color.BLUE);
		btnSalvarJogo.setBounds(98, 306, 166, 39);
		contentPane.add(btnSalvarJogo);

		btnSalvarJogo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Jogo jogo = new Jogo();
				jogo.setTitulo(txtTitulo.getText());
				jogo.setPreco(txtPreco.getText());
				jogo.setObservacoes(editorPaneObeservacoes.getText());

			}
		});

		JButton btnVoltarJogo = new JButton("<");
		btnVoltarJogo.setForeground(Color.WHITE);
		btnVoltarJogo.setBackground(Color.BLUE);
		btnVoltarJogo.setBounds(387, 310, 89, 31);
		contentPane.add(btnVoltarJogo);

		JButton btnAvancarJogo = new JButton(">");
		btnAvancarJogo.setForeground(Color.WHITE);
		btnAvancarJogo.setBackground(Color.BLUE);
		btnAvancarJogo.setBounds(512, 310, 89, 31);
		contentPane.add(btnAvancarJogo);

	}
}
