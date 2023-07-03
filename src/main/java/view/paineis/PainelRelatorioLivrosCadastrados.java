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

public class PainelRelatorioLivrosCadastrados extends JPanel {
	private JTable tableLivrosCadastrados;

	/**
	 * Create the panel.
	 */
	public PainelRelatorioLivrosCadastrados() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblLivrosCadastrados = new JLabel("LIVROS CADASTRADOS");
		lblLivrosCadastrados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLivrosCadastrados.setBounds(257, 21, 233, 24);
		add(lblLivrosCadastrados);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(46, 328, 89, 23);
		add(btnEditar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(385, 328, 89, 23);
		add(btnExcluir);
		
		JButton btnGerarPlanilha = new JButton("GERAR PLANILHA");
		btnGerarPlanilha.setBounds(538, 328, 137, 23);
		add(btnGerarPlanilha);
		
		tableLivrosCadastrados = new JTable();
		tableLivrosCadastrados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		tableLivrosCadastrados.setBackground(new Color(0, 221, 221));
		tableLivrosCadastrados.setBounds(10, 63, 665, 177);
		add(tableLivrosCadastrados);
		
		JButton btnNewButton = new JButton("PESQUISAR");
		btnNewButton.setBounds(208, 328, 106, 23);
		add(btnNewButton);

	}
}
