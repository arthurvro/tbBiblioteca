package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.EditoraController;
import model.vo.EditoraVO;
import model.vo.LivroVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PainelRelatorioLivrosEditora extends JPanel {
	private JTable tableEditora;
	private String[] nomesColunas = {"ID EDITORA", "NOME", "CNPJ", "TELEFONE", "ID ENDERECO"};
	/**
	 * Create the panel.
	 */
	public PainelRelatorioLivrosEditora() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblRelatorioEditoras = new JLabel("RELAT\u00D3RIO EDITORAS");
		lblRelatorioEditoras.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRelatorioEditoras.setBounds(243, 32, 229, 37);
		add(lblRelatorioEditoras);
		
		tableEditora = new JTable();
		tableEditora.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID EDITORA", "NOME", "CNPJ", "TELEFONE", "ID ENDERECO"
			}
		));
		tableEditora.setBackground(new Color(0, 221, 221));
		tableEditora.setBounds(10, 110, 665, 223);
		add(tableEditora);
		
		JButton btnNewButton = new JButton("EDITAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(0, 221, 221));
		btnNewButton.setBounds(62, 356, 98, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXCLUIR");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBackground(new Color(0, 221, 221));
		btnNewButton_1.setBounds(518, 356, 104, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CONSULTAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			private List<EditoraVO> editoras;

			public void actionPerformed(ActionEvent e) {
				EditoraController editoraController = new EditoraController();
				editoras = editoraController.consultarTodasEditoras(editoras);
				atualizarTabela();
			}

			private void atualizarTabela() {
				this.limparTabela();
				DefaultTableModel model = (DefaultTableModel) tableEditora.getModel();
				for(EditoraVO editora : editoras) {
					Object[] novaLinhaTabela = new Object[5];
					//"ID EDITORA", "NOME", "CNPJ", "TELEFONE", "ID ENDERECO"
					novaLinhaTabela[0] = editora.getIdEditora();
					novaLinhaTabela[1] = editora.getNome();
					novaLinhaTabela[2] = editora.getCnpj();
					novaLinhaTabela[3] = editora.getTelefone();
					novaLinhaTabela[4] = editora.getEnderecoVO().getIdEndereco();					
					model.addRow(novaLinhaTabela);
				}				
			}

			private void limparTabela() {
				tableEditora.setModel(new DefaultTableModel(
						new Object[][] {
							{"ID EDITORA", "NOME", "CNPJ", "TELEFONE", "ID ENDERECO"},
						},
						new String[] {
								"ID EDITORA", "NOME", "CNPJ", "TELEFONE", "ID ENDERECO"
						}
					));
					tableEditora.getColumnModel().getColumn(0).setPreferredWidth(30);
				
			}
		});
		btnNewButton_2.setBackground(new Color(0, 221, 221));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(271, 356, 119, 23);
		add(btnNewButton_2);

	}

}
