package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PainelMeusEmprestimos extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		JLabel lblNewLabel_1 = new JLabel("Livro:");
		lblNewLabel_1.setBounds(54, 83, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Editora:");
		lblNewLabel_2.setBounds(54, 128, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Data Empr\u00E9stimo:");
		lblNewLabel_4.setBounds(54, 171, 99, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Data Devolu\u00E7\u00E3o:");
		lblNewLabel_5.setBounds(266, 171, 94, 14);
		add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("RENOVAR +5 DIAS");
		btnNewButton.setBounds(195, 265, 149, 23);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(144, 168, 112, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(354, 168, 112, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 125, 150, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 80, 150, 20);
		add(textField_3);
		textField_3.setColumns(10);

	}
}
