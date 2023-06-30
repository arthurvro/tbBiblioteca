package view.paineis;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import controller.LivroController;
import controller.UsuarioController;
import model.util.DateUtil;
import model.vo.EditoraVO;
import model.vo.GeneroVO;
import model.vo.LivroVO;
import model.vo.UsuarioVO;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.awt.event.ActionEvent;

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
	private JLabel lblAno;
	private JTextField textFieldAutor;
	private JTextField textFieldAno;
	private JTextField textFieldAnoPublicacao;
	private JLabel lblAnoPublicacao;
	

	/**
	 * Create the panel.
	 */
	public PainelCadastroLivro() {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		lblNewLabel = new JLabel("Cadastro Livro");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(157, 32, 174, 29);
		add(lblNewLabel);
		
		lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setBounds(28, 92, 89, 14);
		add(lblTitulo);
		
		lblSubtitulo = new JLabel("Subt\u00EDtulo:");
		lblSubtitulo.setBounds(28, 128, 89, 14);
		add(lblSubtitulo);
		
		lblIsbn = new JLabel("ISBN:");
		lblIsbn.setBounds(28, 199, 89, 14);
		add(lblIsbn);
		
		lblDataCadastro = new JLabel("Data Cadastro:");
		lblDataCadastro.setBounds(28, 353, 89, 14);
		add(lblDataCadastro);
		
		dpDataCadastro = new DatePicker();
		dpDataCadastro.setBounds(124, 347, 196, 20);
		add(dpDataCadastro);
		
		textFieldIsbn = new JTextField();
		textFieldIsbn.setBounds(124, 193, 196, 20);
		add(textFieldIsbn);
		textFieldIsbn.setColumns(10);
		
		textFieldSubtitulo = new JTextField();
		textFieldSubtitulo.setBounds(124, 122, 196, 20);
		add(textFieldSubtitulo);
		textFieldSubtitulo.setColumns(10);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(124, 86, 196, 20);
		add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		lblEditora = new JLabel("Editora:");
		lblEditora.setBounds(28, 163, 59, 14);
		add(lblEditora);
		
		textFieldEditora = new JTextField();
		textFieldEditora.setBounds(124, 157, 196, 20);
		add(textFieldEditora);
		textFieldEditora.setColumns(10);				
		
		lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(28, 237, 46, 14);
		add(lblAutor);
		
		lblAno = new JLabel("Ano:");
		lblAno.setBounds(28, 273, 46, 14);
		add(lblAno);
		
		textFieldAutor = new JTextField();
		textFieldAutor.setBounds(124, 231, 196, 20);
		add(textFieldAutor);
		textFieldAutor.setColumns(10);
		
		textFieldAno = new JTextField();
		textFieldAno.setBounds(124, 267, 196, 20);
		add(textFieldAno);
		textFieldAno.setColumns(10);
		
		lblAnoPublicacao = new JLabel("Ano Publica\u00E7\u00E3o:");
		lblAnoPublicacao.setBounds(28, 315, 78, 14);
		add(lblAnoPublicacao);
		
		textFieldAnoPublicacao = new JTextField();
		textFieldAnoPublicacao.setBounds(124, 309, 196, 20);
		add(textFieldAnoPublicacao);
		textFieldAnoPublicacao.setColumns(10);
		
		JButton btnNewButton = new JButton("CADASTRAR");
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
				novoLivro.setAnoPublicacao(Integer.valueOf(textFieldAnoPublicacao.getText()));
				novoLivro = livroController.inserirNovoLivroController(novoLivro);				
			}
		});
		btnNewButton.setBounds(124, 378, 196, 23);
		add(btnNewButton);			
	}
}
