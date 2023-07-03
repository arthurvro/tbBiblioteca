package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PainelMeusEmprestimos extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PainelMeusEmprestimos() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Meus Empr\u00E9stimo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(274, 25, 165, 30);
		add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBackground(new Color(0, 221, 221));
		table.setBounds(20, 141, 650, 151);
		add(table);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.setBounds(274, 327, 148, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DEVOLU\u00C7\u00C3O");
		btnNewButton_1.setBounds(274, 375, 148, 23);
		add(btnNewButton_1);

	}
}
