package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controller.LivroController;

public class PainelConsultar extends JPanel {
	private JTable tableLivros;
	private String[] nomesColunas = { "ID", "TÍTULO", "SUBTÍTULO", "GÊNERO", "AUTOR", "DATA LANÇAMENTO" };
	private JComboBox comboBoxConsultar;

	/**
	 * Create the panel.
	 */
	public PainelConsultar() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULTAR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(258, 26, 127, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Consultar Por: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(101, 81, 93, 19);
		add(lblNewLabel_1);
		LivroController livroController = new LivroController();
		comboBoxConsultar = new JComboBox(livroController.consultarTodosLivros().toArray());
		comboBoxConsultar.setBounds(214, 79, 171, 22);
		add(comboBoxConsultar);
		
		tableLivros = new JTable();
		tableLivros.setModel(new DefaultTableModel(new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "TITULO", "SUBTITULO", "GENERO", "AUTOR", "DATA LANCAMENTO"
			}
		));
		tableLivros.getColumnModel().getColumn(0).setPreferredWidth(45);
		tableLivros.getColumnModel().getColumn(1).setPreferredWidth(125);
		tableLivros.getColumnModel().getColumn(2).setPreferredWidth(138);
		tableLivros.getColumnModel().getColumn(3).setPreferredWidth(88);
		tableLivros.getColumnModel().getColumn(4).setPreferredWidth(88);
		tableLivros.getColumnModel().getColumn(5).setPreferredWidth(108);
		tableLivros.setBounds(61, 198, 494, 91);
		add(tableLivros);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.setBounds(214, 437, 171, 23);
		add(btnNewButton);

	}
}
