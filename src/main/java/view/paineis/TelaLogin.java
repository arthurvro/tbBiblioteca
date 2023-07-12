package view.paineis;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.UsuarioController;
import model.bo.UsuarioBO;
import model.vo.UsuarioVO;
import view.MenuPrincipal;
import javax.swing.JPasswordField;

public class TelaLogin extends JFrame {
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;
	private JButton btnEntrar;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setAutoRequestFocus(false);
		setTitle("LOGIN BIBLIOTECA");
		getContentPane().setBackground(new Color(255, 128, 0));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 299);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(67, 74, 88, 20);
		getContentPane().add(lblLogin);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(67, 126, 88, 20);
		getContentPane().add(lblSenha);

		textFieldLogin = new JTextField();
		textFieldLogin.setBackground(new Color(0, 221, 221));
		textFieldLogin.setBounds(150, 76, 130, 20);
		getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);

		textFieldSenha = new JPasswordField();
		textFieldSenha.setBackground(new Color(0, 221, 221));
		textFieldSenha.setBounds(150, 128, 130, 20);
		getContentPane().add(textFieldSenha);
		textFieldSenha.setColumns(10);

		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBackground(new Color(0, 221, 221));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (textFieldLogin.getText().isBlank() || textFieldSenha.getText().isBlank()) {
					TelaAlerta alerta = new TelaAlerta("Por Favor, preencha os Campos.");
					alerta.setVisible(true);
					alerta.setModal(true);
					return;
				}
				// instanciar um usuario controller

				UsuarioController usuarioController = new UsuarioController();
				UsuarioVO usuarioAutenticado = null;

				String login = textFieldLogin.getText();
				String senha = textFieldSenha.getText();
				usuarioAutenticado = usuarioController.autenticarLoginController(login, senha);
				if (usuarioAutenticado != null) {
					MenuPrincipal menu = new MenuPrincipal(usuarioAutenticado);
					menu.setVisible(true);
					dispose();
					TelaAlerta alerta = new TelaAlerta("Usuário Logado com sucesso. Perfil: ["
							+ usuarioAutenticado.getTipoUsuario().toString() + "]");
					alerta.setVisible(true);
					alerta.setModal(true);
				} else {
					TelaAlerta alerta = new TelaAlerta("Usuário ou senha inválidos.");
					alerta.setVisible(true);
					alerta.setModal(true);
					return;
				}

			}
		});
		btnEntrar.setBounds(150, 172, 130, 23);
		getContentPane().add(btnEntrar);

		btnSair = new JButton("SAIR");
		btnSair.setBackground(new Color(0, 221, 221));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(150, 207, 130, 20);
		getContentPane().add(btnSair);
	}
}
