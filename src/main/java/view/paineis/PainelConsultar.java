package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.GeneroController;
import controller.LivroController;
import model.dao.GeneroDAO;
import model.vo.LivroVO;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainelConsultar extends JPanel {
	private JTable tableLivros;
	private String[] nomesColunas = { "ID", "TÃ�TULO", "SUBTÃ�TULO", "GÃŠNERO", "AUTOR", "DATA LANÃ‡AMENTO" };
	private JComboBox cbConsultarPorGenero;
	private JTextField textFieldConsultarPorAutor;
	private JTextField textFieldConsultarPorTitulo;
	protected List<LivroVO> livros;
	private JLabel lblNewLabel;
	private JLabel lblConsultarPorGenero;
	private JButton btnConsultar;
	private JLabel lblConsultarPorAutor;
	private JLabel lblConsultarPorTitulo;
	private JButton btnSolicitarEmprestimo;
	private JButton btnNewButton;
	

	/**
	 * Create the panel.
	 */
	public PainelConsultar() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);

		lblNewLabel = new JLabel("CONSULTAR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(291, 28, 127, 28);
		add(lblNewLabel);

		lblConsultarPorGenero = new JLabel("Consultar por G\u00EAnero: ");
		lblConsultarPorGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsultarPorGenero.setBounds(163, 81, 137, 19);
		add(lblConsultarPorGenero);
		GeneroDAO generoDAO = new GeneroDAO();
		cbConsultarPorGenero = new JComboBox(generoDAO.consultarTodosOsGenerosDAO().toArray());
		cbConsultarPorGenero.setBackground(new Color(0, 221, 221));
		cbConsultarPorGenero.setSelectedIndex(-1);
		cbConsultarPorGenero.setBounds(315, 79, 171, 21);
		add(cbConsultarPorGenero);

		tableLivros = new JTable();
		tableLivros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		tableLivros.setBackground(new Color(0, 221, 221));
		limparTabela();
		tableLivros.setBounds(10, 223, 665, 144);
		add(tableLivros);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBackground(new Color(0, 221, 221));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(textFieldConsultarPorAutor.getText().isBlank() && textFieldConsultarPorTitulo.getText().isBlank() && cbConsultarPorGenero == null) {
					LivroController livroController = new LivroController();
					livros = livroController.consultarTodosLivros();
					atualizarTabela();
				//}
//				String nomeAutor = textFieldConsultarPorAutor.getText();
//				LivroController livroController = new LivroController();
//				livros = livroController.consultarLivroPorAutor(nomeAutor);
//				atualizarTabela();
			}
		});
		btnConsultar.setBounds(256, 390, 171, 23);
		add(btnConsultar);

		lblConsultarPorAutor = new JLabel("Consultar por Autor:");
		lblConsultarPorAutor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsultarPorAutor.setBounds(163, 114, 137, 14);
		add(lblConsultarPorAutor);

		textFieldConsultarPorAutor = new JTextField();
		textFieldConsultarPorAutor.setBackground(new Color(0, 221, 221));
		textFieldConsultarPorAutor.setBounds(315, 111, 171, 20);
		add(textFieldConsultarPorAutor);
		textFieldConsultarPorAutor.setColumns(10);

		lblConsultarPorTitulo = new JLabel("Consultar por T\u00EDtulo:");
		lblConsultarPorTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsultarPorTitulo.setBounds(163, 153, 137, 14);
		add(lblConsultarPorTitulo);

		textFieldConsultarPorTitulo = new JTextField();
		textFieldConsultarPorTitulo.setBackground(new Color(0, 221, 221));
		textFieldConsultarPorTitulo.setBounds(315, 147, 171, 20);
		add(textFieldConsultarPorTitulo);
		textFieldConsultarPorTitulo.setColumns(10);

		btnSolicitarEmprestimo = new JButton("SOLICITAR EMPR\u00C9STIMO");
		btnSolicitarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TODO
			}
		});
		btnSolicitarEmprestimo.setBackground(new Color(0, 221, 221));
		btnSolicitarEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSolicitarEmprestimo.setBounds(256, 435, 171, 23);
		add(btnSolicitarEmprestimo);
		
		btnNewButton = new JButton("LIMPAR TABELA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.limparTabela();
			}

			private void limparTabela() {
				tableLivros.setModel(new DefaultTableModel(
						new Object[][] {
							{"ID", "TÍTULO", "SUBTÍTULO", "GÊNERO", "AUTOR", "DATA LANÇAMENTO"},
						},
						new String[] {
								"ID", "TÍTULO", "SUBTÍTULO", "GÊNERO", "AUTOR", "DATA LANÇAMENTO"
						}
					));
					tableLivros.getColumnModel().getColumn(0).setPreferredWidth(10);				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(0, 221, 221));
		btnNewButton.setBounds(256, 474, 171, 23);
		add(btnNewButton);

	}

	protected void atualizarTabela() {
		this.limparTabela();
		
		DefaultTableModel model = (DefaultTableModel) tableLivros.getModel();
		for(LivroVO livro : livros) {
			Object[] novaLinhaTabela = new Object[6];
			//"ID", "TÍTULO", "SUBTÍTULO", "GÊNERO", "AUTOR", "DATA LANÇAMENTO"
			novaLinhaTabela[0] = livro.getIdLivro();
			novaLinhaTabela[1] = livro.getTitulo();
			novaLinhaTabela[2] = livro.getSubTitulo();
			novaLinhaTabela[3] = livro.getGeneroVO().getGenero();
			novaLinhaTabela[4] = livro.getAutor();
			novaLinhaTabela[5] = livro.getDtCadastro();
			
			model.addRow(novaLinhaTabela);
		}
	}

	private void limparTabela() {
		tableLivros.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "TÍTULO", "SUBTÍTULO", "GÊNERO", "AUTOR", "DATA LANÇAMENTO"},
			},
			new String[] {
					"ID", "TÍTULO", "SUBTÍTULO", "GÊNERO", "AUTOR", "DATA LANÇAMENTO"
			}
		));
		tableLivros.getColumnModel().getColumn(0).setPreferredWidth(10);
	}
}
