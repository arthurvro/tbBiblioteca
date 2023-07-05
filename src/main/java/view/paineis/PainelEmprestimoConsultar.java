package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PainelEmprestimoConsultar extends JPanel {
	private JButton btnConsultarTodos;
	private JLabel lblConsultarEmprestimo;
	private JTable tableEmprestimo;
	private JTextField textFieldConsultarPorIdEmprestimo;
	private JTextField textFieldConsultarPorIdUsuario;
	private JLabel lblConsultarPorDataEmprestimo;
	private JTextField textFieldDataEmprestimo;
	

	/**
	 * Create the panel.
	 */
	public PainelEmprestimoConsultar() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		lblConsultarEmprestimo = new JLabel("CONSULTAR EMPR�STIMO");
		lblConsultarEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConsultarEmprestimo.setBounds(231, 24, 248, 38);
		add(lblConsultarEmprestimo);
		
		btnConsultarTodos = new JButton("CONSULTAR ");
		btnConsultarTodos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultarTodos.setBackground(new Color(0, 221, 221));
		btnConsultarTodos.setBounds(180, 393, 339, 23);
		add(btnConsultarTodos);
		
		tableEmprestimo = new JTable();
		tableEmprestimo.setBackground(new Color(0, 221, 221));
		tableEmprestimo.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		tableEmprestimo.setBounds(10, 172, 665, 186);
		add(tableEmprestimo);
		
		JLabel lblConsultarPorIdEmprestimo = new JLabel("Consultar por ID_Empr\u00E9stimo:");
		lblConsultarPorIdEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsultarPorIdEmprestimo.setBounds(196, 89, 187, 14);
		add(lblConsultarPorIdEmprestimo);
		
		textFieldConsultarPorIdEmprestimo = new JTextField();
		textFieldConsultarPorIdEmprestimo.setBackground(new Color(0, 221, 221));
		textFieldConsultarPorIdEmprestimo.setBounds(393, 86, 112, 20);
		add(textFieldConsultarPorIdEmprestimo);
		textFieldConsultarPorIdEmprestimo.setColumns(10);
		
		JLabel lblConsultarPorIdUsuario = new JLabel("Consultar por ID_Usu\u00E1rio:");
		lblConsultarPorIdUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsultarPorIdUsuario.setBounds(196, 118, 187, 14);
		add(lblConsultarPorIdUsuario);
		
		textFieldConsultarPorIdUsuario = new JTextField();
		textFieldConsultarPorIdUsuario.setBackground(new Color(0, 221, 221));
		textFieldConsultarPorIdUsuario.setBounds(393, 117, 112, 20);
		add(textFieldConsultarPorIdUsuario);
		textFieldConsultarPorIdUsuario.setColumns(10);
		
		lblConsultarPorDataEmprestimo = new JLabel("Consultar por Data Empr\u00E9stimo:");
		lblConsultarPorDataEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsultarPorDataEmprestimo.setBounds(196, 147, 187, 14);
		add(lblConsultarPorDataEmprestimo);
		
		textFieldDataEmprestimo = new JTextField();
		textFieldDataEmprestimo.setBackground(new Color(0, 221, 221));
		textFieldDataEmprestimo.setBounds(393, 148, 112, 20);
		add(textFieldDataEmprestimo);
		textFieldDataEmprestimo.setColumns(10);

	}
}
