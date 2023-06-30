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
import view.paineis.PainelSobreSistema;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenu mnCadastro;
	private JMenuItem mntmCadastrarLeitro;
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
	
	//Instancia��o dos pain�is no menu principal
	private PainelCadastroUsuario painelCadastroLeitor;
	private PainelCadastroEditora painelCadastroEditora;
	private PainelCadastroLivro painelCadastroLivro;
	private PainelMeusEmprestimos painelEmprestimosNovo;
	private PainelEmprestimoConsultar painelEmprestimos;
	private PainelEmprestimoConsultar painelEmprestimoConsultar;
	private PainelSobreSistema painelSobreSistema;
	private PainelMeusEmprestimos painelMeusEmprestimos;
	private PainelConsultar painelConsultar;
	
	private UsuarioVO usuarioAutenticado;
	private JMenuItem mntmConsultar;
	
	/**
	 * Create the frame.
	 */
	public MenuPrincipal(UsuarioVO usuario) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/icons/iconMenuPrincipalBarra.png")));
		setTitle("Menu Principal");
		this.usuarioAutenticado = usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 682);		
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCadastro = new JMenu("CADASTROS");
		menuBar.add(mnCadastro);
		
		mntmCadastrarLeitro = new JMenuItem("Cadastrar Usu\u00E1rio");
		mntmCadastrarLeitro.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				painelCadastroLeitor = new PainelCadastroUsuario();
				setContentPane(painelCadastroLeitor);
				revalidate();
				
			}
		});
		mnCadastro.add(mntmCadastrarLeitro);
		
		mntmCadastrarLivros = new JMenuItem("Cadastrar Livros");
		mntmCadastrarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroLivro = new PainelCadastroLivro();
				setContentPane(painelCadastroLivro);
				revalidate();
			}
		});
		
		mnCadastro.add(mntmCadastrarLivros);
		
		mntmCadastrarEditora = new JMenuItem("Cadastrar Editora");
		mntmCadastrarEditora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroEditora = new PainelCadastroEditora();
				setContentPane(painelCadastroEditora);
				revalidate();
			}
		});
		mnCadastro.add(mntmCadastrarEditora);
		
		mnEmprestimos = new JMenu("EMPRESTIMOS");
		menuBar.add(mnEmprestimos);
		
		mntmMeusEmprestimos = new JMenuItem("Meus Empr\u00E9stimos");
		mntmMeusEmprestimos.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				painelMeusEmprestimos = new PainelMeusEmprestimos();
				setContentPane (painelMeusEmprestimos);
				revalidate();
			}
		});
		mnEmprestimos.add(mntmMeusEmprestimos);
		
		mntmConsultarEmprestimo = new JMenuItem("Consultar Empr\u00E9stimo");
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
		
		mnRelatorios = new JMenu("RELAT\u00D3RIOS");
		menuBar.add(mnRelatorios);
		
		mntmRelatorioLivrosCadastrados = new JMenuItem("Relat\u00F3rio de Livros Cadastrados");
		mntmRelatorioLivrosCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		mnRelatorios.add(mntmRelatorioLivrosCadastrados);
		
		mntmRelatorioLivrosPorAutor = new JMenuItem("Relat\u00F3rio de Livros por Autor");
		mntmRelatorioLivrosPorAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		mnRelatorios.add(mntmRelatorioLivrosPorAutor);
		
		mntmRelatorioLivrosPorGenero = new JMenuItem("Relat\u00F3rio de Livros por G\u00EAnero");
		mntmRelatorioLivrosPorGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		mnRelatorios.add(mntmRelatorioLivrosPorGenero);
		
		mntmRelatorioLivrosPorEditora = new JMenuItem("Relat\u00F3rio de Livros por Editora");
		mntmRelatorioLivrosPorEditora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		mnRelatorios.add(mntmRelatorioLivrosPorEditora);
		
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
		
		//TODO verificar as permissoes do usuario autenticado e mostrar / esconder os componenetes
	}
}
