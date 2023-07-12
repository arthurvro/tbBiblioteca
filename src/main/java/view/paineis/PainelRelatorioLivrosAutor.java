package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;

public class PainelRelatorioLivrosAutor extends JPanel {
	private JTable tableAutores;

	/**
	 * Create the panel.
	 */
	public PainelRelatorioLivrosAutor() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblRelatorioAutores = new JLabel("RELAT\u00D3RIO AUTORES");
		lblRelatorioAutores.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRelatorioAutores.setBounds(254, 27, 213, 33);
		add(lblRelatorioAutores);
		
		tableAutores = new JTable();
		tableAutores.setBackground(new Color(0, 221, 221));
		tableAutores.setBounds(10, 105, 665, 195);
		add(tableAutores);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBackground(new Color(0, 221, 221));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBounds(50, 363, 102, 23);
		add(btnEditar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBackground(new Color(0, 221, 221));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.setBounds(529, 363, 102, 23);
		add(btnExcluir);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBackground(new Color(0, 221, 221));
		btnConsultar.setBounds(274, 363, 128, 23);
		add(btnConsultar);

	}

}
