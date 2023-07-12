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

import com.github.lgooddatepicker.components.DatePicker;

import controller.EmprestimoController;
import model.vo.EmprestimoVO;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PainelEmprestimoConsultar extends JPanel {
	private JLabel lblConsultarEmprestimo;
	private JTable tableEmprestimo;
	private JTextField textFieldConsultarPorIdEmprestimo;
	private JTextField textFieldConsultarPorIdUsuario;
	private JLabel lblConsultarPorDataEmprestimo;
	private JTextField textFieldDataEmprestimo;
	private JLabel lblConsultarPorIdEmprestimo;
	private JLabel lblConsultarPorIdUsuario;
	private JButton btnConsultar;
	private List<EmprestimoVO> emprestimos;
	private EmprestimoVO emprestimoPorId;
	private JButton btnNewButton;
	private DatePicker dataCadastro;

	/**
	 * Create the panel.
	 */
	public PainelEmprestimoConsultar() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		lblConsultarEmprestimo = new JLabel("CONSULTAR EMPRÉSTIMO");
		lblConsultarEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConsultarEmprestimo.setBounds(231, 24, 248, 38);
		add(lblConsultarEmprestimo);
		
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
		
		lblConsultarPorIdEmprestimo = new JLabel("Consultar por ID_Empr\u00E9stimo:");
		lblConsultarPorIdEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsultarPorIdEmprestimo.setBounds(159, 88, 187, 14);
		add(lblConsultarPorIdEmprestimo);
		
		textFieldConsultarPorIdEmprestimo = new JTextField();
		textFieldConsultarPorIdEmprestimo.setBackground(new Color(0, 221, 221));
		textFieldConsultarPorIdEmprestimo.setBounds(356, 85, 204, 20);
		add(textFieldConsultarPorIdEmprestimo);
		textFieldConsultarPorIdEmprestimo.setColumns(10);
		
		lblConsultarPorIdUsuario = new JLabel("Consultar por ID_Usu\u00E1rio:");
		lblConsultarPorIdUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsultarPorIdUsuario.setBounds(159, 117, 187, 14);
		add(lblConsultarPorIdUsuario);
		
		textFieldConsultarPorIdUsuario = new JTextField();
		textFieldConsultarPorIdUsuario.setBackground(new Color(0, 221, 221));
		textFieldConsultarPorIdUsuario.setBounds(356, 116, 204, 20);
		add(textFieldConsultarPorIdUsuario);
		textFieldConsultarPorIdUsuario.setColumns(10);
		
		lblConsultarPorDataEmprestimo = new JLabel("Consultar por Data Empr\u00E9stimo:");
		lblConsultarPorDataEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsultarPorDataEmprestimo.setBounds(159, 147, 187, 14);
		add(lblConsultarPorDataEmprestimo);
		
		
		dataCadastro = new DatePicker();
		dataCadastro.getComponentToggleCalendarButton().setBackground(new Color(0, 221, 221));
		dataCadastro.getComponentDateTextField().setBackground(new Color(0, 221, 221));
		dataCadastro.setBounds(356, 144, 204, 20);
		add(dataCadastro);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBackground(new Color(0, 221, 221));
		
		
		btnNewButton = new JButton("LIMPAR TABELA");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(0, 221, 221));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.limparTabela();
			}
			private void limparTabela() {
				tableEmprestimo.setModel(new DefaultTableModel(
						new Object[][] {
							{"IDEMP", "IDUSU", "IDEXE", "DTEMPRESTIMO", "DTEMPRESTIMOFIM", "DTEMPRESTIMODEVOL", "DESC", "VALORMULTA"},
						},
						new String[] {
								"IDEMP", "IDUSU", "IDEXE", "DTEMPRESTIMO", "DTEMPRESTIMOFIM", "DTEMPRESTIMODEVOL", "DESC", "VALORMULTA"
						}
					));
					tableEmprestimo.getColumnModel().getColumn(0).setPreferredWidth(35);
					tableEmprestimo.getColumnModel().getColumn(1).setPreferredWidth(35);
					tableEmprestimo.getColumnModel().getColumn(2).setPreferredWidth(35);
			}
		});
		btnNewButton.setBounds(231, 473, 232, 23);
		add(btnNewButton);
		
		btnConsultar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				EmprestimoController emprestimoController = new EmprestimoController();
					//CONSULTAR TODOS EMPRESTIMOS
					if(textFieldConsultarPorIdEmprestimo.getText().isBlank() 
							&& textFieldConsultarPorIdUsuario.getText().isBlank()
							&& dataCadastro.getText().isBlank()) {
						emprestimos = emprestimoController.consultarTodosEmprestimos(); 
						atualizarTabela();
					}
					//CONSULTAR POR IDEMPRESTIMO
					if(!textFieldConsultarPorIdEmprestimo.getText().isBlank() 
							&& textFieldConsultarPorIdUsuario.getText().isBlank()
							&& dataCadastro.getText().isBlank()) {
						String idEmprestimo = textFieldConsultarPorIdEmprestimo.getText();
						int idEmprestimoConvertido = Integer.parseInt(idEmprestimo);
						emprestimoPorId = emprestimoController.consultarEmprestimosPorIdEmprestimo(idEmprestimoConvertido); 
						atualizarTabela();						
					}
					
				
				
			}

			private void atualizarTabela() {
				this.limparTabela();
				
				DefaultTableModel model = (DefaultTableModel)tableEmprestimo.getModel();
				for(EmprestimoVO emprestimo : emprestimos) {
					Object[] novaLinhaTabela = new Object[8];

				novaLinhaTabela[0] = emprestimo.getIdEmprestimo();
				novaLinhaTabela[1] = emprestimo.getUsuarioVO().getIdUsuario();
				novaLinhaTabela[2] = emprestimo.getCopiaLivroVO().getIdExemplares();
				novaLinhaTabela[3] = emprestimo.getDtEmprestimoInicio();
				novaLinhaTabela[4] = emprestimo.getDtEmprestimoFim();
				novaLinhaTabela[5] = emprestimo.getDtDevolucao();
				novaLinhaTabela[6] = emprestimo.getDescricao();				
				novaLinhaTabela[7] = emprestimo.getValorMulta();
				
				model.addRow(novaLinhaTabela);	
				}
			}

			private void limparTabela() {
				tableEmprestimo.setModel(new DefaultTableModel(
						new Object[][] {
							{"IDEMP", "IDUSU", "IDEXE", "DTEMPRESTIMO", "DTEMPRESTIMOFIM", "DTEMPRESTIMODEVOL", "DESC", "VALORMULTA"},
						},
						new String[] {
								"IDEMP", "IDUSU", "IDEXE", "DTEMPRESTIMO", "DTEMPRESTIMOFIM", "DTEMPRESTIMODEVOL", "DESC", "VALORMULTA"
						}
					));
					tableEmprestimo.getColumnModel().getColumn(0).setPreferredWidth(35);
					tableEmprestimo.getColumnModel().getColumn(1).setPreferredWidth(35);
					tableEmprestimo.getColumnModel().getColumn(2).setPreferredWidth(35);
			}
		});
		btnConsultar.setBounds(231, 420, 232, 23);
		add(btnConsultar);

	}
}
