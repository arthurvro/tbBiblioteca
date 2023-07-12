package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PainelEditarEndereco extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelEditarEndereco() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EDITAR ENDERE\u00C7O");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(267, 27, 192, 36);
		add(lblNewLabel);

	}

}
