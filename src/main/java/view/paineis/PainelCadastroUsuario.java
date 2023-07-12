package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import controller.EnderecoController;
import controller.UsuarioController;
import exception.CamposInvalidosException;
import model.vo.EnderecoVO;
import model.vo.TipoUsuarioVO;
import model.vo.UsuarioVO;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class PainelCadastroUsuario extends JPanel {
	private DatePicker dataCadastro;
	private JTextField textFieldDataCadastro;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;
	private JTextField textFieldTelefone;
	private JTextField textFieldCpf;
	private JTextField textFieldNome;
	private JTextField textFieldEstado;
	private JTextField textFieldCidade;
	private JTextField textFieldBairro;
	private JTextField textFieldCep;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldPais;
	private JLabel lblNewLabel;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JLabel lblDataCadastro;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JLabel lblNewLabel_1;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblRua;
	private Component lblNumero;
	private JLabel lblPais;
	private JSeparator separator;
	private MaskFormatter mascaraCpf;
	private MaskFormatter mascaraTelefone;
	private MaskFormatter mascaraCep;
	private JRadioButton rdbtnAdministrador;
	TipoUsuarioVO adm = null;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public PainelCadastroUsuario() throws ParseException {
		setBackground(new Color(255, 128, 0));
		setForeground(new Color(128, 128, 64));
		setLayout(null);

		lblNewLabel = new JLabel("CADASTRO DE USU\u00C1RIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(246, 24, 230, 30);
		add(lblNewLabel);

		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(185, 72, 88, 14);
		add(lblNome);

		lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(185, 105, 88, 14);
		add(lblCpf);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(185, 140, 88, 14);
		add(lblTelefone);

		lblDataCadastro = new JLabel("Data Cadastro:");
		lblDataCadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataCadastro.setBounds(185, 171, 88, 14);
		add(lblDataCadastro);

		lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(185, 201, 88, 14);
		add(lblLogin);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(185, 231, 88, 14);
		add(lblSenha);

		dataCadastro = new DatePicker();
		dataCadastro.getComponentToggleCalendarButton().setBackground(new Color(0, 221, 221));
		dataCadastro.getComponentDateTextField().setBackground(new Color(0, 221, 221));
		dataCadastro.setBounds(272, 166, 204, 20);
		add(dataCadastro);

		textFieldLogin = new JTextField();
		textFieldLogin.setBackground(new Color(0, 221, 221));
		textFieldLogin.setBounds(272, 196, 204, 20);
		add(textFieldLogin);
		textFieldLogin.setColumns(10);

		textFieldSenha = new JTextField();
		textFieldSenha.setBackground(new Color(0, 221, 221));
		textFieldSenha.setBounds(272, 228, 204, 20);
		add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		mascaraTelefone = new MaskFormatter("(##)#####-####");
		mascaraTelefone.setValueContainsLiteralCharacters(false);
		textFieldTelefone = new JFormattedTextField(mascaraTelefone);
		textFieldTelefone.setBackground(new Color(0, 221, 221));
		textFieldTelefone.setBounds(272, 133, 204, 20);
		add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		
		mascaraCpf = new MaskFormatter("###.###.###-##");
		mascaraCpf.setValueContainsLiteralCharacters(false);
		textFieldCpf = new JFormattedTextField(mascaraCpf);
		textFieldCpf.setBackground(new Color(0, 221, 221));
		textFieldCpf.setBounds(272, 100, 204, 20);
		add(textFieldCpf);
		textFieldCpf.setColumns(10);

		textFieldNome = new JTextField();
		textFieldNome.setBackground(new Color(0, 221, 221));
		textFieldNome.setBounds(272, 69, 204, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(20, 284, 650, 9);
		add(separator);
		
		lblNewLabel_1 = new JLabel("CADASTRO ENDERE\u00C7O");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(246, 295, 230, 20);
		add(lblNewLabel_1);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(185, 370, 56, 14);
		add(lblEstado);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setBounds(185, 406, 58, 14);
		add(lblCidade);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBairro.setBounds(185, 441, 56, 14);
		add(lblBairro);
		
		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCep.setBounds(185, 476, 56, 14);
		add(lblCep);
		
		lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRua.setBounds(185, 514, 56, 14);
		add(lblRua);
		
		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(185, 551, 58, 14);
		add(lblNumero);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBackground(new Color(0, 221, 221));
		textFieldEstado.setBounds(272, 369, 203, 20);
		add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBackground(new Color(0, 221, 221));
		textFieldCidade.setBounds(272, 405, 203, 20);
		add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBackground(new Color(0, 221, 221));
		textFieldBairro.setBounds(272, 440, 203, 20);
		add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		mascaraCep = new MaskFormatter("#####-###");
		mascaraCep.setValueContainsLiteralCharacters(false);
		textFieldCep = new JFormattedTextField(mascaraCep);
		textFieldCep.setBackground(new Color(0, 221, 221));
		textFieldCep.setBounds(272, 475, 203, 20);
		add(textFieldCep);
		textFieldCep.setColumns(10);
		
		textFieldRua = new JTextField();
		textFieldRua.setBackground(new Color(0, 221, 221));
		textFieldRua.setBounds(272, 513, 203, 20);
		add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBackground(new Color(0, 221, 221));
		textFieldNumero.setBounds(272, 550, 203, 20);
		add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPais.setBounds(185, 332, 46, 14);
		add(lblPais);
		
		textFieldPais = new JTextField();
		textFieldPais.setBackground(new Color(0, 221, 221));
		textFieldPais.setBounds(272, 329, 204, 20);
		add(textFieldPais);
		textFieldPais.setColumns(10);
		
		rdbtnAdministrador = new JRadioButton("ADMINISTRADOR");
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnAdministrador.setForeground(new Color(64, 0, 0));
		
		rdbtnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnAdministrador.isSelected()) {
					adm = TipoUsuarioVO.getTipoUsuarioVOPorValor(1);
				}else {
					adm=TipoUsuarioVO.getTipoUsuarioVOPorValor(2);
				}				
			}
		});
		rdbtnAdministrador.setBackground(new Color(0, 221, 221));
		rdbtnAdministrador.setBounds(313, 257, 125, 23);
		add(rdbtnAdministrador);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBackground(new Color(0, 221, 221));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioController usuarioController = new UsuarioController();
				EnderecoController enderecoController = new EnderecoController();
				UsuarioVO novoUsuario = new UsuarioVO();
				EnderecoVO novoEndereco = new EnderecoVO();
				
				String cpfSemMascara = textFieldCpf.getText()
						.replace(".", "").replace("-", "");
				String telefoneSemMascara = textFieldTelefone.getText()
						.replace("(", "").replace("-", "").replace(")", "");
				String cepSemMascara = textFieldCep.getText().replace("-", "");
				
				novoUsuario.setNome(textFieldNome.getText());
				novoUsuario.setCpf(cpfSemMascara);

				TipoUsuarioVO tipoUsuarioVO = adm;
				novoUsuario.setTipoUsuario(tipoUsuarioVO);
				novoUsuario.setTelefone(telefoneSemMascara);
				novoUsuario.setDtCadastro(dataCadastro.getDate());
				novoUsuario.setLogin(textFieldLogin.getText());
				novoUsuario.setSenha(textFieldSenha.getText());
				
				novoEndereco.setPais(textFieldPais.getText());
				novoEndereco.setEstado(textFieldEstado.getText());
				novoEndereco.setCidade(textFieldCidade.getText());
				novoEndereco.setBairro(textFieldBairro.getText());
				novoEndereco.setCep(cepSemMascara);
				novoEndereco.setRua(textFieldRua.getText());
				novoEndereco.setNumero(textFieldNumero.getText());
				
				novoUsuario.setEnderecoVO(novoEndereco);
				
				
				
				try {
					novoUsuario = usuarioController.inserirNovoUsuarioController(novoUsuario);
				} catch (CamposInvalidosException e1) {
					TelaAlerta alerta = new TelaAlerta("erro: " +e1.getMessage());
					alerta.setVisible(true);
				}
				TelaAlerta alerta = new TelaAlerta("USUARIO CADASTRADO COM SUCESSO.");
				alerta.setVisible(true);
			}
		});
		btnCadastrar.setBounds(272, 584, 204, 23);
		add(btnCadastrar);

	}
}
