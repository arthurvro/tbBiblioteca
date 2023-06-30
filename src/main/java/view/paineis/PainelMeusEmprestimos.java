package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;

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
		lblNewLabel.setBounds(195, 24, 165, 30);
		add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(44, 75, 419, 151);
		add(table);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.setBounds(181, 238, 148, 23);
		add(btnNewButton);

	}
}
