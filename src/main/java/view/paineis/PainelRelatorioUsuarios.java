package view.paineis;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.UsuarioController;
import exception.ClienteComEnderecoException;
import model.vo.UsuarioVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainelRelatorioUsuarios extends JPanel {
	private JTable tableUsuarios;
	private JTextField textFieldPesquisaNome;
	private JTextField textFieldPesquisaCpf;
	private List<UsuarioVO> usuarios;
	private JLabel lblPesquisaCpf;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnPesquisar;
	private JLabel lblPequisaNome;
	private JButton btnNewButton;
	UsuarioController usuarioController = new UsuarioController();
	private UsuarioVO usuarioSelecionado;
	
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
		tableUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indiceSelecionado = tableUsuarios.getSelectedRow();
				
				if(indiceSelecionado >0) {
					btnExcluir.setEnabled(true);
					btnEditar.setEnabled(true);
					usuarioSelecionado = usuarios.get(indiceSelecionado -1);
				}else {
					btnExcluir.setEnabled(false);
					btnEditar.setEnabled(false);
				}
				
			}
		});
		tableUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"IDUSUARIO", "IDENDERECO", "TIPO USUARIO", "NOME", "CPF", "TELEFONE", "DTCADASTRO", "LOGIN"
			}
		));
		tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(59);
		tableUsuarios.setBackground(new Color(0, 221, 221));
		tableUsuarios.setBounds(10, 198, 665, 206);
		add(tableUsuarios);
		
		lblPequisaNome = new JLabel("Pesquisar por Nome:");
		lblPequisaNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPequisaNome.setBounds(157, 84, 128, 19);
		add(lblPequisaNome);
		
		textFieldPesquisaNome = new JTextField();
		textFieldPesquisaNome.setBackground(new Color(0, 221, 221));
		textFieldPesquisaNome.setBounds(283, 84, 154, 20);
		add(textFieldPesquisaNome);
		textFieldPesquisaNome.setColumns(10);
		
		lblPesquisaCpf = new JLabel("Pesquisar por CPF:");
		lblPesquisaCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPesquisaCpf.setBounds(157, 132, 117, 19);
		add(lblPesquisaCpf);
		
		textFieldPesquisaCpf = new JTextField();
		textFieldPesquisaCpf.setBackground(new Color(0, 221, 221));
		textFieldPesquisaCpf.setBounds(283, 131, 154, 20);
		add(textFieldPesquisaCpf);
		textFieldPesquisaCpf.setColumns(10);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				int linhaSelecionadaNaTabela = tableUsuarios.getSelectedRow();
				UsuarioVO usuarioSelecionado = usuarios.get(linhaSelecionadaNaTabela -1);
				PainelEditarUsuario painelEditar = new PainelEditarUsuario();
				
								
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBackground(new Color(0, 221, 221));
		btnEditar.setBounds(283, 431, 154, 23);
		add(btnEditar);
		
		btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					usuarioController.excluir(usuarioSelecionado.getIdUsuario());
				} catch (ClienteComEnderecoException e1) {
					TelaAlerta alerta = new TelaAlerta("Erro: " +e1);
					alerta.setVisible(true);
				}
				usuarios = (ArrayList<UsuarioVO>) usuarioController.consultarTodosUsuarios();
				
				
			}
		});
		btnExcluir.setBackground(new Color(0, 221, 221));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.setBounds(283, 463, 154, 23);
		add(btnExcluir);
		
		btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisar.setBackground(new Color(0, 221, 221));
		btnPesquisar.addActionListener(new ActionListener() {			

			public void actionPerformed(ActionEvent e) {
				UsuarioController usuarioController = new UsuarioController();
				usuarios = usuarioController.consultarTodosUsuarios();
				atualizarTabela();
				
			}

			private void atualizarTabela() {
				this.limparTabela();
				
				DefaultTableModel model = (DefaultTableModel) tableUsuarios.getModel();
				for(UsuarioVO usuario : usuarios) {
					Object[] novaLinhaTabela = new Object[8];
					novaLinhaTabela[0] = usuario.getIdUsuario();
					novaLinhaTabela[1] = usuario.getEnderecoVO().getIdEndereco(); 
					novaLinhaTabela[2] = usuario.getTipoUsuario();
					novaLinhaTabela[3] = usuario.getNome();
					novaLinhaTabela[4] = usuario.getCpf();
					novaLinhaTabela[5] = usuario.getTelefone();
					novaLinhaTabela[6] = usuario.getDtCadastro();
					novaLinhaTabela[7] = usuario.getLogin();
					
					model.addRow(novaLinhaTabela);
				}
			}

			private void limparTabela() {
				tableUsuarios.setModel(new DefaultTableModel(
						new Object[][] {
							{"IDUSU", "IDEND", "TPUSU", "NOME", "CPF", "TELEFONE", "DTCADASTRO", "LOGIN"},
						},
						new String[] {
								"IDUSU", "IDEND", "TIPO USU", "NOME", "CPF", "TELEFONE", "DTCADASTRO", "LOGIN"
						}
					));
					tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(30);
					tableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(30);
					tableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(30);
			}
		});
		btnPesquisar.setBounds(283, 162, 154, 23);
		add(btnPesquisar);
		
		btnNewButton = new JButton("LIMPAR TABELA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				this.limparTabela();
			}

			private void limparTabela() {
				tableUsuarios.setModel(new DefaultTableModel(
						new Object[][] {
							{"IDUSU", "IDEND", "TPUSU", "NOME", "CPF", "TELEFONE", "DTCADASTRO", "LOGIN"},
						},
						new String[] {
								"IDUSU", "IDEND", "TIPO USU", "NOME", "CPF", "TELEFONE", "DTCADASTRO", "LOGIN"
						}
					));
					tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(30);
					tableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(30);
					tableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(30);				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(0, 221, 221));
		btnNewButton.setBounds(283, 498, 154, 23);
		add(btnNewButton);

	}

}
