package view.paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;

import controller.LivroController;
import exception.CamposInvalidosException;
import model.vo.LivroVO;

public class PainelCadastroLivro extends JPanel {
	private DatePicker dpDataCadastro; 
	private JTextField textFieldIsbn;
	private JTextField textFieldSubtitulo;
	private JTextField textFieldTitulo;
	private JTextField textFieldEditora;
	private JLabel lblNewLabel;
	private JLabel lblTitulo;
	private JLabel lblSubtitulo;
	private JLabel lblIsbn;
	private JLabel lblDataCadastro;
	private JLabel lblEditora;	
	private JLabel lblAutor;
	private JTextField textFieldAutor;
	private JTextField textFieldAnoPublicacao;
	private JLabel lblAnoPublicacao;
	private JTextField textFieldGenero;
	private JLabel lblNewLabel_1;
	

	/**
	 * Create the panel.
	 */
	public PainelCadastroLivro() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		lblNewLabel = new JLabel("CADASTRAR LIVRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(266, 33, 190, 29);
		add(lblNewLabel);
		
		lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitulo.setBounds(172, 102, 89, 14);
		add(lblTitulo);
		
		lblSubtitulo = new JLabel("Subt\u00EDtulo:");
		lblSubtitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSubtitulo.setBounds(172, 140, 89, 14);
		add(lblSubtitulo);
		
		lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIsbn.setBounds(173, 244, 89, 14);
		add(lblIsbn);
		
		lblDataCadastro = new JLabel("Data Cadastro:");
		lblDataCadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataCadastro.setBounds(173, 351, 89, 14);
		add(lblDataCadastro);
		
		dpDataCadastro = new DatePicker();
		dpDataCadastro.getComponentToggleCalendarButton().setBackground(new Color(0, 221, 221));
		dpDataCadastro.getComponentDateTextField().setBackground(new Color(0, 221, 221));
		dpDataCadastro.setBounds(274, 347, 196, 20);
		add(dpDataCadastro);
		
		textFieldIsbn = new JTextField();
		textFieldIsbn.setBackground(new Color(0, 221, 221));
		textFieldIsbn.setBounds(274, 238, 196, 20);
		add(textFieldIsbn);
		textFieldIsbn.setColumns(10);
		
		textFieldSubtitulo = new JTextField();
		textFieldSubtitulo.setBackground(new Color(0, 221, 221));
		textFieldSubtitulo.setBounds(273, 134, 196, 20);
		add(textFieldSubtitulo);
		textFieldSubtitulo.setColumns(10);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBackground(new Color(0, 221, 221));
		textFieldTitulo.setBounds(273, 96, 196, 20);
		add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		lblEditora = new JLabel("Editora:");
		lblEditora.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEditora.setBounds(173, 177, 59, 14);
		add(lblEditora);
		
		textFieldEditora = new JTextField();
		textFieldEditora.setBackground(new Color(0, 221, 221));
		textFieldEditora.setBounds(274, 171, 196, 20);
		add(textFieldEditora);
		textFieldEditora.setColumns(10);				
		
		lblAutor = new JLabel("Autor:");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAutor.setBounds(173, 283, 46, 14);
		add(lblAutor);
		
		textFieldAutor = new JTextField();
		textFieldAutor.setBackground(new Color(0, 221, 221));
		textFieldAutor.setBounds(274, 274, 196, 20);
		add(textFieldAutor);
		textFieldAutor.setColumns(10);
		
		lblAnoPublicacao = new JLabel("Ano Publica\u00E7\u00E3o:");
		lblAnoPublicacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnoPublicacao.setBounds(173, 316, 101, 14);
		add(lblAnoPublicacao);
		
		textFieldAnoPublicacao = new JTextField();
		textFieldAnoPublicacao.setBackground(new Color(0, 221, 221));
		textFieldAnoPublicacao.setBounds(274, 311, 196, 20);
		add(textFieldAnoPublicacao);
		textFieldAnoPublicacao.setColumns(10);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setBackground(new Color(0, 221, 221));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				LivroController livroController = new LivroController();
				LivroVO novoLivro = new LivroVO();				
				novoLivro.setTitulo(textFieldTitulo.getText());
				novoLivro.setSubTitulo(textFieldSubtitulo.getText());
				novoLivro.setEditora(textFieldEditora.getText());
				novoLivro.setIsbn(textFieldIsbn.getText());	
				novoLivro.setAutor(textFieldAutor.getText());
				novoLivro.setDtCadastro(dpDataCadastro.getDate());
				novoLivro.setGenero(textFieldGenero.getText());
				novoLivro.setAnoPublicacao(Integer.valueOf(textFieldAnoPublicacao.getText()));
				
				try {
					novoLivro = livroController.inserirNovoLivroController(novoLivro);
				} catch (CamposInvalidosException e1) {
					TelaAlerta alerta = new TelaAlerta(e1.getMessage());
					alerta.setVisible(true);
				}				
			}
		});
		btnNewButton.setBounds(274, 387, 196, 23);
		add(btnNewButton);			
		
		JLabel lblGenero = new JLabel("G\u00EAnero:");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGenero.setBounds(173, 208, 59, 14);
		add(lblGenero);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setBackground(new Color(0, 221, 221));
		textFieldGenero.setBounds(274, 205, 196, 20);
		add(textFieldGenero);
		textFieldGenero.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Observe, Todos os campos s\u00E3o Obrigat\u00F3rios.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(202, 431, 288, 21);
		add(lblNewLabel_1);
	}
}
