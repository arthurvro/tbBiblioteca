package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PainelSobreSistema extends JPanel {

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Create the panel.
	 */
	public PainelSobreSistema() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		lblNewLabel = new JLabel("Sobre o Sistema");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(281, 23, 158, 35);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Sistema na sua vers\u00E3o 1.0");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(267, 91, 220, 53);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Desenvolvido por Henrique R. Martins e Arthur V. Ribeiro");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(157, 249, 379, 25);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Com Auxilio do Professor Vilmar C. P. Junior.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(196, 290, 311, 25);
		add(lblNewLabel_3);

	}

}
