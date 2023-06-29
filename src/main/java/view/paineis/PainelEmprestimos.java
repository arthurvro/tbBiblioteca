package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PainelEmprestimos extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelEmprestimos() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Empr\u00E9stimos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(202, 30, 144, 32);
		add(lblNewLabel);

	}

}
