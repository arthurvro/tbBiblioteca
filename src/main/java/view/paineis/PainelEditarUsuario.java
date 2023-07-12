package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PainelEditarUsuario extends JPanel {
	private JTextField textFieldTelefone;
	private JTextField textFieldCpf;
	private JTextField textFieldNome;

	/**
	 * Create the panel.
	 */
	public PainelEditarUsuario() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EDITAR USU\u00C1RIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(271, 11, 223, 41);
		add(lblNewLabel);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(201, 133, 62, 14);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(201, 178, 62, 14);
		add(lblCpf);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(201, 229, 81, 14);
		add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBackground(new Color(0, 221, 221));
		textFieldTelefone.setBounds(295, 226, 185, 20);
		add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBackground(new Color(0, 221, 221));
		textFieldCpf.setBounds(295, 175, 185, 20);
		add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setBackground(new Color(0, 221, 221));
		textFieldNome.setBounds(295, 130, 185, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setBackground(new Color(0, 221, 221));
		btnSalvar.setBounds(201, 322, 89, 23);
		add(btnSalvar);
		
		JButton btnNewButton = new JButton("CALCELAR");
		btnNewButton.setBackground(new Color(0, 221, 221));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(391, 322, 89, 23);
		add(btnNewButton);

	}
}
