package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;

public class PainelRelatorioLivrosAutor extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelRelatorioLivrosAutor() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Relat\u00F3rio Autor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(169, 27, 147, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autores Cadastrados:");
		lblNewLabel_1.setBounds(52, 90, 117, 14);
		add(lblNewLabel_1);
		
		JList list = new JList();
		list.setBounds(181, 89, 274, 124);
		add(list);

	}

}
