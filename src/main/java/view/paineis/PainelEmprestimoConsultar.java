package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PainelEmprestimoConsultar extends JPanel {
	private JTextField textFieldDataEmprestimo;
	private JTextField textFieldDataDevolucao;
	private JTextField textFieldIsbn;
	private JTextField textFieldEditora;
	private JTextField textFieldLivro;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField textFieldNome;
	private JSeparator separator;
	private JButton btnVoltar;
	private JLabel lblNewLabel;
	private JLabel lblLivro;
	private JLabel lblEditora;
	private JLabel lblIsbn;	
	private JLabel lblDataEmprestimo;
	private JLabel lblDataDevolucao;
	private JLabel lblNewLabel_6;
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	

	/**
	 * Create the panel.
	 */
	public PainelEmprestimoConsultar() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		lblNewLabel = new JLabel("Consultar Empr\u00E9stimos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(157, 26, 217, 38);
		add(lblNewLabel);
		
		lblLivro = new JLabel("Livro:");
		lblLivro.setBounds(39, 88, 46, 14);
		add(lblLivro);
		
		lblEditora = new JLabel("Editora:");
		lblEditora.setBounds(39, 127, 46, 14);
		add(lblEditora);
		
		lblIsbn = new JLabel("ISBN:");
		lblIsbn.setBounds(39, 168, 46, 14);
		add(lblIsbn);
		
		separator = new JSeparator();
		separator.setBounds(10, 249, 484, 7);
		add(separator);
		
		lblDataEmprestimo = new JLabel("Data Empr\u00E9stimo:");
		lblDataEmprestimo.setBounds(39, 205, 97, 14);
		add(lblDataEmprestimo);
		
		lblDataDevolucao = new JLabel("Data Devolu\u00E7\u00E3o:");
		lblDataDevolucao.setBounds(262, 205, 87, 14);
		add(lblDataDevolucao);
		
		textFieldDataEmprestimo = new JTextField();
		textFieldDataEmprestimo.setBounds(132, 202, 120, 20);
		add(textFieldDataEmprestimo);
		textFieldDataEmprestimo.setColumns(10);
		
		textFieldDataDevolucao = new JTextField();
		textFieldDataDevolucao.setColumns(10);
		textFieldDataDevolucao.setBounds(351, 202, 120, 20);
		add(textFieldDataDevolucao);
		
		textFieldIsbn = new JTextField();
		textFieldIsbn.setBounds(132, 165, 339, 20);
		add(textFieldIsbn);
		textFieldIsbn.setColumns(10);
		
		textFieldEditora = new JTextField();
		textFieldEditora.setBounds(132, 124, 339, 20);
		add(textFieldEditora);
		textFieldEditora.setColumns(10);
		
		textFieldLivro = new JTextField();
		textFieldLivro.setBounds(132, 85, 339, 20);
		add(textFieldLivro);
		textFieldLivro.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Locat\u00E1rio");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(216, 267, 113, 27);
		add(lblNewLabel_6);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(39, 300, 46, 14);
		add(lblNome);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(39, 339, 46, 14);
		add(lblTelefone);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(39, 380, 46, 14);
		add(lblEmail);
		
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(132, 405, 339, 23);
		add(btnVoltar);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(132, 377, 339, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(132, 339, 339, 20);
		add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(132, 300, 339, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);

	}
}
