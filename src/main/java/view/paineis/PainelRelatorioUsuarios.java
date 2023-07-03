package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PainelRelatorioUsuarios extends JPanel {
	private JTable tableUsuarios;
	private JTextField textFieldPesquisaNome;
	private JTextField textFieldPesquisaCpf;

	/**
	 * Create the panel.
	 */
	public PainelRelatorioUsuarios() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		JLabel lblRelatorioUsuarios = new JLabel("RELAT\u00D3RIO DE USU\u00C1RIOS");
		lblRelatorioUsuarios.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRelatorioUsuarios.setBounds(191, 34, 263, 39);
		add(lblRelatorioUsuarios);
		
		tableUsuarios = new JTable();
		tableUsuarios.setBackground(new Color(0, 221, 221));
		tableUsuarios.setBounds(10, 198, 665, 206);
		add(tableUsuarios);
		
		JLabel lblPequisaNome = new JLabel("Pesquisar por Nome:");
		lblPequisaNome.setBounds(157, 84, 128, 19);
		add(lblPequisaNome);
		
		textFieldPesquisaNome = new JTextField();
		textFieldPesquisaNome.setBackground(new Color(0, 221, 221));
		textFieldPesquisaNome.setBounds(283, 84, 154, 20);
		add(textFieldPesquisaNome);
		textFieldPesquisaNome.setColumns(10);
		
		JLabel lblPesquisaCpf = new JLabel("Pesquisar por CPF:");
		lblPesquisaCpf.setBounds(157, 132, 117, 19);
		add(lblPesquisaCpf);
		
		textFieldPesquisaCpf = new JTextField();
		textFieldPesquisaCpf.setBackground(new Color(0, 221, 221));
		textFieldPesquisaCpf.setBounds(283, 131, 154, 20);
		add(textFieldPesquisaCpf);
		textFieldPesquisaCpf.setColumns(10);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(185, 415, 89, 23);
		add(btnEditar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(386, 415, 89, 23);
		add(btnExcluir);
		
		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.setBounds(453, 105, 106, 23);
		add(btnPesquisar);

	}

}
