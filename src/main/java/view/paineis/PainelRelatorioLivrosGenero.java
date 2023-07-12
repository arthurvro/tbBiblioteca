package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controller.GeneroController;
import model.vo.GeneroVO;
import model.vo.LivroVO;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PainelRelatorioLivrosGenero extends JPanel {
	private JTable tableGeneros;
	private JButton btnEditar;
	private JButton btnPesquisar;
	private JButton btnExcluir;
	private List<GeneroVO> generos;

	/**
	 * Create the panel.
	 */
	public PainelRelatorioLivrosGenero() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);

		JLabel lblRelatorioGeneros = new JLabel("RELAT\u00D3RIO G\u00CANEROS");
		lblRelatorioGeneros.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRelatorioGeneros.setBounds(251, 31, 220, 41);
		add(lblRelatorioGeneros);

		tableGeneros = new JTable();
		tableGeneros.setModel(
				new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "New column", "New column" }));
		tableGeneros.setBackground(new Color(0, 221, 221));
		tableGeneros.setBounds(15, 100, 660, 202);
		add(tableGeneros);

		btnEditar = new JButton("EDITAR");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBackground(new Color(0, 221, 221));
		btnEditar.setBounds(41, 328, 102, 23);
		add(btnEditar);

		btnPesquisar = new JButton("CONSULTAR");
		btnPesquisar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				GeneroController generoController = new GeneroController();
				generos = generoController.consultarTodosOsGeneros(generos);
				atualizarTabela();
			}

			private void atualizarTabela() {
				this.limparTabela();
				DefaultTableModel model = (DefaultTableModel) tableGeneros.getModel();
				for (GeneroVO genero : generos) {
					Object[] novaLinhaTabela = new Object[2];
					// "IDGENERO", "GENERO"
					novaLinhaTabela[0] = genero.getIdGenero();
					novaLinhaTabela[1] = genero.getGenero();

					model.addRow(novaLinhaTabela);
				}

			}

			private void limparTabela() {
				tableGeneros.setModel(new DefaultTableModel(
						new Object[][] {
							{"IDGENERO", "GENERO"},
						},
						new String[] {
								"IDGENERO", "GENERO"
						}
					));
					tableGeneros.getColumnModel().getColumn(0).setPreferredWidth(40);
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisar.setBackground(new Color(0, 221, 221));
		btnPesquisar.setBounds(273, 328, 128, 23);
		add(btnPesquisar);

		btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.setBackground(new Color(0, 221, 221));
		btnExcluir.setBounds(540, 328, 102, 23);
		add(btnExcluir);

	}

}
