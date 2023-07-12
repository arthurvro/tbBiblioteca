package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.EmprestimoController;
import model.vo.EmprestimoVO;
import model.vo.LivroVO;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PainelMeusEmprestimos extends JPanel {
	private JTable tableMeusEmprestimos;
	private JButton btnConsultar;
	private JLabel lblMeusEmprestimos;
	private List<EmprestimoVO> emprestimos;
	private JButton btnDevolucao;
	

	/**
	 * Create the panel.
	 */
	public PainelMeusEmprestimos() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		lblMeusEmprestimos = new JLabel("Meus Empr\u00E9stimo");
		lblMeusEmprestimos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMeusEmprestimos.setBounds(274, 25, 165, 30);
		add(lblMeusEmprestimos);
		
		tableMeusEmprestimos = new JTable();
		tableMeusEmprestimos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		tableMeusEmprestimos.setBackground(new Color(0, 221, 221));
		limparTabela();
		tableMeusEmprestimos.setBounds(20, 141, 650, 151);
		add(tableMeusEmprestimos);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBackground(new Color(0, 221, 221));
		btnConsultar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				EmprestimoController emprestimoController = new EmprestimoController();
				emprestimos = emprestimoController.consultarTodosEmprestimos();				
				atualizarTabela();
			}
		});
		btnConsultar.setBounds(274, 327, 148, 23);
		add(btnConsultar);
		
		btnDevolucao = new JButton("DEVOLU\u00C7\u00C3O");
		btnDevolucao.setBackground(new Color(0, 221, 221));
		btnDevolucao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDevolucao.setBounds(274, 375, 148, 23);
		add(btnDevolucao);	
	}
	private void limparTabela() {
		tableMeusEmprestimos.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Data Emprestimo", "Data Devolucao", "Data Devolvida", "Valor Multa", "Descricao", "ID Usuario", "ID Exemplar"},
			},
			new String[] {
					"ID", "Data Emprestimo", "Data Devolucao", "Data Devolvida", "Valor Multa", "Descricao", "ID Usuario", "ID Exemplar"
			}
		));
		tableMeusEmprestimos.getColumnModel().getColumn(0).setPreferredWidth(38);
	}
	protected void atualizarTabela() {
		this.limparTabela();
		
		DefaultTableModel model = (DefaultTableModel) tableMeusEmprestimos.getModel();
		for(EmprestimoVO emprestimo : emprestimos) {
			Object[] novaLinhaTabela = new Object[8];
			
			//"ID", "Data Emprestimo", "Data Devolucao", "Data Devolvida", "Valor Multa", "Descricao", "ID Usuario", "ID Exemplar";
			novaLinhaTabela[0] = emprestimo.getIdEmprestimo();
			novaLinhaTabela[1] = emprestimo.getDtEmprestimoInicio();
			novaLinhaTabela[2] = emprestimo.getDtEmprestimoFim();
			novaLinhaTabela[3] = emprestimo.getDtDevolucao();
			novaLinhaTabela[4] = emprestimo.getValorMulta();
			novaLinhaTabela[5] = emprestimo.getDescricao();
			novaLinhaTabela[6] = emprestimo.getUsuarioVO().getIdUsuario();
			novaLinhaTabela[7] = emprestimo.getCopiaLivroVO().getIdExemplares();
			
			model.addRow(novaLinhaTabela);
		}
	}

	
}
