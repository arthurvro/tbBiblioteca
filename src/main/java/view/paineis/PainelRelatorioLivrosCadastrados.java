package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JList;

public class PainelRelatorioLivrosCadastrados extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelRelatorioLivrosCadastrados() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Relat\u00F3rio Livros");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(218, 24, 150, 24);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Livros Cadastrados:");
		lblNewLabel_1.setBounds(65, 89, 109, 24);
		add(lblNewLabel_1);
		
		JList list = new JList();
		list.setBounds(168, 93, 319, 124);
		add(list);

	}
}
