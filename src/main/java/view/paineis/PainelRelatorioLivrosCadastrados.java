package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.LivroController;
import model.vo.LivroVO;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PainelRelatorioLivrosCadastrados extends JPanel {
	private JTable tableLivrosCadastrados;
	private List<LivroVO> livros;
	private JLabel lblLivrosCadastrados;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnGerarPlanilha;
	// id livro, titulo, sub titulo, genero, editora, autor,qtd total, qtd disponivel, isbn, ano pub
	private String[] nomesColunas = {"ID LIVRO", "TÍTULO", "SUBTÍTULO", "GÊNERO", "EDITORA", "AUTOR", "QTD TOTAL", "QTD DIS.", "ISBN", "ANO PUB."};
	/**
	 * Create the panel.
	 */
	public PainelRelatorioLivrosCadastrados() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		lblLivrosCadastrados = new JLabel("LIVROS CADASTRADOS");
		lblLivrosCadastrados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLivrosCadastrados.setBounds(257, 21, 233, 24);
		add(lblLivrosCadastrados);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBackground(new Color(0, 221, 221));
		btnEditar.setBounds(46, 328, 89, 23);
		add(btnEditar);
		
		btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBackground(new Color(0, 221, 221));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.setBounds(385, 328, 89, 23);
		add(btnExcluir);
		
		btnGerarPlanilha = new JButton("GERAR PLANILHA");
		btnGerarPlanilha.setBackground(new Color(0, 221, 221));
		btnGerarPlanilha.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGerarPlanilha.setBounds(538, 328, 137, 23);
		add(btnGerarPlanilha);
		
		tableLivrosCadastrados = new JTable();
		tableLivrosCadastrados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"IDLIVRO", "T\u00CDTULO", "SUBT\u00CDTULO", "G\u00CANERO", "EDITORA", "AUTOR", "QTD TOTAL", "QTD DISPONIVEL", "ISBN", "ANO PUB"
			}
		));
		tableLivrosCadastrados.getColumnModel().getColumn(0).setPreferredWidth(40);
		tableLivrosCadastrados.getColumnModel().getColumn(6).setPreferredWidth(40);
		tableLivrosCadastrados.getColumnModel().getColumn(7).setPreferredWidth(40);
		tableLivrosCadastrados.getColumnModel().getColumn(9).setPreferredWidth(40);
		tableLivrosCadastrados.setBackground(new Color(0, 221, 221));
		tableLivrosCadastrados.setBounds(10, 63, 665, 177);
		add(tableLivrosCadastrados);
		
		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisar.addActionListener(new ActionListener() {			

			public void actionPerformed(ActionEvent e) {
				LivroController livroController = new LivroController();
				livros = livroController.consultarTodosLivros();
				atualizarTabela();				
			}

			private void atualizarTabela() {
				this.limparTabela();
				
				DefaultTableModel model = (DefaultTableModel) tableLivrosCadastrados.getModel();
				for(LivroVO livro : livros) {
			// "IDLIVRO", "T\u00CDTULO", "SUBT\u00CDTULO", "G\u00CANERO", "EDITORA", "AUTOR", "QTD TOTAL", "QTD DISPONIVEL", "ISBN", "ANO PUB"
					Object[] novaLinhaTabela = new Object[10];
					novaLinhaTabela[0] = livro.getIdLivro();
					novaLinhaTabela[1] = livro.getTitulo();
					novaLinhaTabela[2] = livro.getSubTitulo();
					novaLinhaTabela[3] = livro.getGeneroVO().getGenero();
					novaLinhaTabela[4] = livro.getEditoraVO().getIdEditora();
					novaLinhaTabela[5] = livro.getAutor();
					novaLinhaTabela[6] = livro.getQtdLivros();
					novaLinhaTabela[7] = livro.getQtdDisponivel();
					novaLinhaTabela[8] = livro.getIsbn();
					novaLinhaTabela[9] = livro.getAnoPublicacao();
					
					model.addRow(novaLinhaTabela);
				}
				
			}

			private void limparTabela() {
				// TODO Auto-generated method stub
				tableLivrosCadastrados.setModel(new DefaultTableModel(
						new Object[][] {
							{"IDLIVRO", "T\u00CDTULO", "SUBT\u00CDTULO", "G\u00CANERO", "EDITORA", "AUTOR", "QTD TOTAL", "QTD DISPONIVEL", "ISBN", "ANO PUB"},
						},
						new String[] {
								"IDLIVRO", "T\u00CDTULO", "SUBT\u00CDTULO", "G\u00CANERO", "EDITORA", "AUTOR", "QTD TOTAL", "QTD DISPONIVEL", "ISBN", "ANO PUB"
						}
					));
					tableLivrosCadastrados.getColumnModel().getColumn(0).setPreferredWidth(40);
			}
		});
		btnPesquisar.setBackground(new Color(0, 221, 221));
		btnPesquisar.setBounds(208, 328, 106, 23);
		add(btnPesquisar);

	}
}
