package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controller.GeneroController;
import controller.LivroController;
import model.dao.GeneroDAO;
import javax.swing.JTextField;

public class PainelConsultar extends JPanel {
	private JTable tableLivros;
	private String[] nomesColunas = { "ID", "T�TULO", "SUBT�TULO", "G�NERO", "AUTOR", "DATA LAN�AMENTO" };
	private JComboBox cbConsultarPorGenero;
	private JTextField textFieldConsultarPorAutor;
	private JTextField textFieldConsultarPorTitulo;

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
		
		JLabel lblConsultarPorGenero = new JLabel("Consultar por G\u00EAnero: ");
		lblConsultarPorGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsultarPorGenero.setBounds(62, 81, 137, 19);
		add(lblConsultarPorGenero);
		GeneroDAO generoDAO = new GeneroDAO();
		cbConsultarPorGenero = new JComboBox(generoDAO.consultarTodosOsGenerosDAO().toArray());
		cbConsultarPorGenero.setSelectedIndex(-1);
		cbConsultarPorGenero.setBounds(214, 79, 171, 21);
		add(cbConsultarPorGenero);
		
		tableLivros = new JTable();
		tableLivros.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "T\u00CDTULO", "SUBT\u00CDTULO", "G\u00CANERO", "AUTOR", "DATA LAN\u00C7AMENTO"},
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
		tableLivros.setBounds(28, 223, 557, 96);
		add(tableLivros);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.setBounds(214, 357, 190, 23);
		add(btnNewButton);
		
		JLabel lblConsultarPorAutor = new JLabel("Consultar por Autor:");
		lblConsultarPorAutor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsultarPorAutor.setBounds(62, 119, 137, 14);
		add(lblConsultarPorAutor);
		
		textFieldConsultarPorAutor = new JTextField();
		textFieldConsultarPorAutor.setBounds(214, 116, 171, 20);
		add(textFieldConsultarPorAutor);
		textFieldConsultarPorAutor.setColumns(10);
		
		JLabel lblConsultarPorTitulo = new JLabel("Consultar por T\u00EDtulo:");
		lblConsultarPorTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsultarPorTitulo.setBounds(62, 153, 137, 14);
		add(lblConsultarPorTitulo);
		
		textFieldConsultarPorTitulo = new JTextField();
		textFieldConsultarPorTitulo.setBounds(214, 147, 171, 20);
		add(textFieldConsultarPorTitulo);
		textFieldConsultarPorTitulo.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SOLICITAR EMPR\u00C9STIMO");
		btnNewButton_1.setBounds(214, 402, 190, 23);
		add(btnNewButton_1);

	}
}
