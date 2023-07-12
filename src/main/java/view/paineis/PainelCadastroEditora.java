package view.paineis;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.EditoraController;
import model.vo.EditoraVO;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
	private MaskFormatter mascaraCnpj;
	private MaskFormatter mascaraTelefone;
	private MaskFormatter mascaraCep;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public PainelCadastroEditora() throws ParseException {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		lblNewLabel = new JLabel("CADASTRO EDITORA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(259, 29, 222, 28);
		add(lblNewLabel);
		
		lblNomeEditora = new JLabel("Nome Editora:");
		lblNomeEditora.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeEditora.setBounds(177, 72, 87, 14);
		add(lblNomeEditora);
		
		lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCnpj.setBounds(177, 108, 87, 14);
		add(lblCnpj);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(177, 141, 87, 14);
		add(lblTelefone);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(177, 287, 87, 14);
		add(lblEstado);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setBounds(177, 321, 87, 14);
		add(lblCidade);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBairro.setBounds(177, 356, 87, 14);
		add(lblBairro);
		
		lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRua.setBounds(177, 424, 87, 14);
		add(lblRua);
		
		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(177, 459, 87, 14);
		add(lblNumero);
		
		lblDataCadastro = new JLabel("Data Cadastro:");
		lblDataCadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataCadastro.setBounds(177, 496, 87, 14);
		add(lblDataCadastro);
		
		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCep.setBounds(177, 388, 87, 14);
		add(lblCep);
		
		textFieldDataCadastro = new JTextField();
		textFieldDataCadastro.setBackground(new Color(0, 221, 221));
		textFieldDataCadastro.setBounds(274, 493, 235, 20);
		add(textFieldDataCadastro);
		textFieldDataCadastro.setColumns(10);
		
		textFieldNumero = new JFormattedTextField();
		textFieldNumero.setBackground(new Color(0, 221, 221));
		textFieldNumero.setBounds(274, 456, 235, 20);
		add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		textFieldRua = new JTextField();
		textFieldRua.setBackground(new Color(0, 221, 221));
		textFieldRua.setBounds(274, 421, 235, 20);
		add(textFieldRua);
		textFieldRua.setColumns(10);
		
//		mascaraCpf = new MaskFormatter("###.###.###-##");
//		mascaraCpf.setValueContainsLiteralCharacters(false);
//		
//		txtCpf = new JFormattedTextField(mascaraCpf);
//		txtCpf.setBounds(85, 60, 300, 20);
//		frmNovoCliente.getContentPane().add(txtCpf);
		
		mascaraCep = new MaskFormatter("#####-###");
		mascaraCep.setValueContainsLiteralCharacters(false);
		
		textFieldCep = new JFormattedTextField(mascaraCep);
		textFieldCep.setBackground(new Color(0, 221, 221));
		textFieldCep.setBounds(274, 385, 235, 20);
		add(textFieldCep);
		textFieldCep.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBackground(new Color(0, 221, 221));
		textFieldBairro.setBounds(274, 353, 235, 20);
		add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBackground(new Color(0, 221, 221));
		textFieldCidade.setBounds(274, 318, 235, 20);
		add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBackground(new Color(0, 221, 221));
		textFieldEstado.setBounds(274, 284, 235, 20);
		add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		mascaraTelefone = new MaskFormatter("(##)#####-####");
		mascaraTelefone.setValueContainsLiteralCharacters(false);
		
		textFieldTelefone = new JFormattedTextField(mascaraTelefone);
		textFieldTelefone.setBackground(new Color(0, 221, 221));
		textFieldTelefone.setBounds(274, 138, 235, 20);
		add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		mascaraCnpj = new MaskFormatter("##.###.###/####-##");
		mascaraCnpj.setValueContainsLiteralCharacters(false);
		
		textFieldCnpj = new JFormattedTextField(mascaraCnpj);
		textFieldCnpj.setBackground(new Color(0, 221, 221));
		textFieldCnpj.setBounds(274, 105, 235, 20);
		add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
		textFieldNomeEditora = new JTextField();
		textFieldNomeEditora.setBackground(new Color(0, 221, 221));
		textFieldNomeEditora.setBounds(274, 69, 235, 20);
		add(textFieldNomeEditora);
		textFieldNomeEditora.setColumns(10);
		
		separator = new JSeparator();
		separator.setBackground(new Color(0, 221, 221));
		separator.setBounds(10, 180, 665, 2);
		add(separator);
		
		lblNewLabel_1 = new JLabel("CADASTRO ENDERE\u00C7O EDITORA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(213, 203, 311, 28);
		add(lblNewLabel_1);
		
		lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPais.setBounds(177, 250, 54, 14);
		add(lblPais);
		
		textFieldPais = new JTextField();
		textFieldPais.setBackground(new Color(0, 221, 221));
		textFieldPais.setBounds(274, 250, 235, 20);
		add(textFieldPais);
		textFieldPais.setColumns(10);
		
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBackground(new Color(0, 221, 221));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		btnCadastrar.setBounds(274, 524, 235, 23);
		add(btnCadastrar);

	}
}
