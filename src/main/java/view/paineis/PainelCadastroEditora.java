package view.paineis;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;

import controller.EditoraController;
import model.vo.EditoraVO;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelCadastroEditora extends JPanel {
	private JTextField textFieldDataCadastro;
	private JTextField textFieldNumero;
	private JTextField textFieldRua;
	private JTextField textFieldCep;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldTelefone;
	private JTextField textFieldCnpj;
	private JTextField textFieldNomeEditora;
	private JTextField textFieldPais;
	private Component lblBairro;
	private Component lblCnpj;
	private Component lblTelefone;
	private JLabel lblNewLabel;
	private JLabel lblNomeEditora;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblRua;
	private JLabel lblNumero;
	private JLabel lblDataCadastro;
	private JLabel lblCep;	
	private JLabel lblNewLabel_1;
	private JLabel lblPais;	
	private JSeparator separator;
	private JButton btnCadastrar;

	/**
	 * Create the panel.
	 */
	public PainelCadastroEditora() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		lblNewLabel = new JLabel("Cadastro Editora");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(182, 30, 168, 28);
		add(lblNewLabel);
		
		lblNomeEditora = new JLabel("Nome Editora:");
		lblNomeEditora.setBounds(35, 72, 87, 14);
		add(lblNomeEditora);
		
		lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(35, 108, 87, 14);
		add(lblCnpj);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(35, 141, 87, 14);
		add(lblTelefone);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(35, 287, 87, 14);
		add(lblEstado);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(35, 321, 87, 14);
		add(lblCidade);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(35, 356, 87, 14);
		add(lblBairro);
		
		lblRua = new JLabel("Rua:");
		lblRua.setBounds(35, 424, 87, 14);
		add(lblRua);
		
		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(35, 459, 87, 14);
		add(lblNumero);
		
		lblDataCadastro = new JLabel("Data Cadastro:");
		lblDataCadastro.setBounds(35, 496, 87, 14);
		add(lblDataCadastro);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(35, 388, 87, 14);
		add(lblCep);
		
		textFieldDataCadastro = new JTextField();
		textFieldDataCadastro.setBounds(132, 493, 235, 20);
		add(textFieldDataCadastro);
		textFieldDataCadastro.setColumns(10);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(132, 456, 235, 20);
		add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(132, 421, 235, 20);
		add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldCep = new JTextField();
		textFieldCep.setBounds(132, 385, 235, 20);
		add(textFieldCep);
		textFieldCep.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(132, 353, 235, 20);
		add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(132, 318, 235, 20);
		add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(132, 284, 235, 20);
		add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(132, 138, 235, 20);
		add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setBounds(132, 105, 235, 20);
		add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
		textFieldNomeEditora = new JTextField();
		textFieldNomeEditora.setBounds(132, 69, 235, 20);
		add(textFieldNomeEditora);
		textFieldNomeEditora.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(10, 180, 490, 2);
		add(separator);
		
		lblNewLabel_1 = new JLabel("Endere\u00E7o");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(205, 193, 123, 28);
		add(lblNewLabel_1);
		
		lblPais = new JLabel("Pais:");
		lblPais.setBounds(35, 250, 46, 14);
		add(lblPais);
		
		textFieldPais = new JTextField();
		textFieldPais.setBounds(132, 250, 235, 20);
		add(textFieldPais);
		textFieldPais.setColumns(10);
		
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditoraController editoraController = new EditoraController();
				EditoraVO novaEditora = new EditoraVO();
				//Informacoes da editora
				novaEditora.setNome(textFieldNomeEditora.getText());
				novaEditora.setCnpj(textFieldCnpj.getText());
				novaEditora.setTelefone(textFieldTelefone.getText());
				//Informacoes do Endereco da Editora
				
			}
		});
		btnCadastrar.setBounds(132, 524, 235, 23);
		add(btnCadastrar);

	}
}
