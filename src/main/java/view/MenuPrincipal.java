package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.vo.UsuarioVO;
import view.paineis.PainelCadastroEditora;
import view.paineis.PainelCadastroLivro;
import view.paineis.PainelCadastroUsuario;
import view.paineis.PainelConsultar;
import view.paineis.PainelEmprestimoConsultar;
import view.paineis.PainelMeusEmprestimos;
import view.paineis.PainelRelatorioLivrosAutor;
import view.paineis.PainelRelatorioLivrosCadastrados;
import view.paineis.PainelRelatorioLivrosEditora;
import view.paineis.PainelRelatorioLivrosGenero;
import view.paineis.PainelRelatorioUsuarios;
import view.paineis.PainelSobreSistema;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.ParseException;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenu mnCadastro;
	private JMenuItem mntmCadastrarUsuario;
	private JMenuItem mntmCadastrarLivros;
	private JMenuItem mntmCadastrarEditora;
	private JMenu mnEmprestimos;
	private JMenuItem mntmMeusEmprestimos;
	private JMenu mnConsultas;
	private JMenu mnRelatorios;
	private JMenuItem mntmRelatorioLivrosCadastrados;
	private JMenuItem mntmRelatorioLivrosPorAutor;
	private JMenuItem mntmRelatorioLivrosPorGenero;
	private JMenuItem mntmRelatorioLivrosPorEditora;
	private JMenu mnSair;
	private JMenuItem mntmSobreSistema;
	private JMenuItem mntmSair;
	private JMenuBar menuBar;
	private JMenuItem mntmConsultarEmprestimo;

	// Instanciação dos painéis no menu principal
	private PainelCadastroUsuario painelCadastroLeitor;
	private PainelCadastroEditora painelCadastroEditora;
	private PainelCadastroLivro painelCadastroLivro;
	private PainelEmprestimoConsultar painelEmprestimoConsultar;
	private PainelSobreSistema painelSobreSistema;
	private PainelMeusEmprestimos painelMeusEmprestimos;
	private PainelConsultar painelConsultar;
	private PainelRelatorioLivrosCadastrados painelRelatorioLivrosCadastrados;
	private PainelRelatorioLivrosAutor painelRelatorioLivrosAutor;
	private PainelRelatorioLivrosGenero painelRelatorioLivrosGenero;
	private PainelRelatorioLivrosEditora painelRelatorioLivrosEditora;
	private PainelRelatorioUsuarios painelRelatorioUsuarios;

	private UsuarioVO usuarioAutenticado;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmRelatorioDeUsuarios;

	/**
	 * Create the frame.
	 */
	public MenuPrincipal(UsuarioVO usuario) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MenuPrincipal.class.getResource("/icons/iconMenuPrincipalBarra.png")));
		setTitle("Menu Principal - Bem-vindo, " + usuario.getNome() + " (" + usuario.getTipoUsuario().toString() + ")");
		this.usuarioAutenticado = usuario;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 682);
		setLocationRelativeTo(null);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnCadastro = new JMenu("CADASTROS");
		mnCadastro.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {

			}
		});
		menuBar.add(mnCadastro);

		mntmCadastrarUsuario = new JMenuItem("Cadastrar Usuário");
		mntmCadastrarUsuario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					painelCadastroLeitor = new PainelCadastroUsuario();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setContentPane(painelCadastroLeitor);
				revalidate();
			}
		});
		mnCadastro.add(mntmCadastrarUsuario);

		mntmCadastrarLivros = new JMenuItem("Cadastrar Livros");
		mntmCadastrarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					painelCadastroLivro = new PainelCadastroLivro();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setContentPane(painelCadastroLivro);
				revalidate();
			}
		});

		mnCadastro.add(mntmCadastrarLivros);

		mntmCadastrarEditora = new JMenuItem("Cadastrar Editora");
		mntmCadastrarEditora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					painelCadastroEditora = new PainelCadastroEditora();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setContentPane(painelCadastroEditora);
				revalidate();
			}
		});
		mnCadastro.add(mntmCadastrarEditora);

		mnEmprestimos = new JMenu("EMPRÉSTIMOS");
		menuBar.add(mnEmprestimos);

		mntmMeusEmprestimos = new JMenuItem("Meus Empréstimos");
		mntmMeusEmprestimos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				painelMeusEmprestimos = new PainelMeusEmprestimos();
				setContentPane(painelMeusEmprestimos);
				revalidate();
			}
		});
		mnEmprestimos.add(mntmMeusEmprestimos);

		mntmConsultarEmprestimo = new JMenuItem("Consultar Empréstimo");
		mntmConsultarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelEmprestimoConsultar = new PainelEmprestimoConsultar();
				setContentPane(painelEmprestimoConsultar);
				revalidate();
			}
		});
		mnEmprestimos.add(mntmConsultarEmprestimo);

		mnConsultas = new JMenu("CONSULTAS");
		menuBar.add(mnConsultas);

		mntmConsultar = new JMenuItem("CONSULTAR");
		mntmConsultar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				painelConsultar = new PainelConsultar();
				setContentPane(painelConsultar);
				revalidate();
			}
		});
		mnConsultas.add(mntmConsultar);

		mnRelatorios = new JMenu("RELATÓRIOS");
		menuBar.add(mnRelatorios);

		mntmRelatorioLivrosCadastrados = new JMenuItem("Relatório de Livros Cadastrados");
		mntmRelatorioLivrosCadastrados.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				painelRelatorioLivrosCadastrados = new PainelRelatorioLivrosCadastrados();
				setContentPane(painelRelatorioLivrosCadastrados);
				revalidate();
			}
		});
		mnRelatorios.add(mntmRelatorioLivrosCadastrados);

		mntmRelatorioLivrosPorAutor = new JMenuItem("Relatório de Livros por Autor");
		mntmRelatorioLivrosPorAutor.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				painelRelatorioLivrosAutor = new PainelRelatorioLivrosAutor();
				setContentPane(painelRelatorioLivrosAutor);
				revalidate();
			}
		});
		mnRelatorios.add(mntmRelatorioLivrosPorAutor);

		mntmRelatorioLivrosPorGenero = new JMenuItem("Relatório de Livros por Gênero");
		mntmRelatorioLivrosPorGenero.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				painelRelatorioLivrosGenero = new PainelRelatorioLivrosGenero();
				setContentPane(painelRelatorioLivrosGenero);
				revalidate();
			}
		});
		mnRelatorios.add(mntmRelatorioLivrosPorGenero);

		mntmRelatorioLivrosPorEditora = new JMenuItem("Relatório de Livros por Editora");
		mntmRelatorioLivrosPorEditora.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				painelRelatorioLivrosEditora = new PainelRelatorioLivrosEditora();
				setContentPane(painelRelatorioLivrosEditora);
			}
		});
		mnRelatorios.add(mntmRelatorioLivrosPorEditora);

		mntmRelatorioDeUsuarios = new JMenuItem("Relat\u00F3rio de Usu\u00E1rios");
		mntmRelatorioDeUsuarios.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				painelRelatorioUsuarios = new PainelRelatorioUsuarios();
				setContentPane(painelRelatorioUsuarios);
				revalidate();
			}
		});
		mnRelatorios.add(mntmRelatorioDeUsuarios);

		mnSair = new JMenu("SAIR");
		menuBar.add(mnSair);

		mntmSobreSistema = new JMenuItem("Sobre o Sistema");
		mntmSobreSistema.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				painelSobreSistema = new PainelSobreSistema();
				setContentPane(painelSobreSistema);
				revalidate();
			}
		});
		mnSair.add(mntmSobreSistema);

		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnSair.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 64, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		if (usuario.getTipoUsuario().toString().equalsIgnoreCase("USUARIO")) {
			mnCadastro.hide();
			mntmConsultarEmprestimo.hide();
			mntmRelatorioDeUsuarios.hide();
			mnRelatorios.hide();
		}
	}
}
