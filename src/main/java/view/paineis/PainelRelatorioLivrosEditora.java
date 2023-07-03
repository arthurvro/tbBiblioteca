package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class PainelRelatorioLivrosEditora extends JPanel {
	private JTable tableEditora;

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
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		tableEditora.setBackground(new Color(0, 221, 221));
		tableEditora.setBounds(10, 110, 665, 223);
		add(tableEditora);
		
		JButton btnNewButton = new JButton("EDITAR");
		btnNewButton.setBounds(62, 356, 98, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXCLUIR");
		btnNewButton_1.setBounds(518, 356, 104, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CONSULTAR");
		btnNewButton_2.setBounds(271, 356, 119, 23);
		add(btnNewButton_2);

	}

}
