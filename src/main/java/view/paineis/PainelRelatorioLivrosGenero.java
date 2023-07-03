package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class PainelRelatorioLivrosGenero extends JPanel {
	private JTable tableGeneros;

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
		tableGeneros.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		tableGeneros.setBackground(new Color(0, 221, 221));
		tableGeneros.setBounds(15, 100, 660, 202);
		add(tableGeneros);
		
		JButton btnNewButton = new JButton("EDITAR");
		btnNewButton.setBounds(41, 328, 102, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CONSULTAR");
		btnNewButton_1.setBounds(273, 328, 128, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXCLUIR");
		btnNewButton_2.setBounds(540, 328, 102, 23);
		add(btnNewButton_2);

	}

}
