package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PainelEmprestimosNovo extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelEmprestimosNovo() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novo Empr\u00E9stimo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(195, 24, 165, 30);
		add(lblNewLabel);

	}

}
