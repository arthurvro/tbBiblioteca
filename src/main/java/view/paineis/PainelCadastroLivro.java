package view.paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import controller.LivroController;
import exception.CamposInvalidosException;
import model.vo.LivroVO;
import javax.swing.JSeparator;

public class PainelCadastroLivro extends JPanel {
	private DatePicker dpDataCadastro; 
	private JTextField textFieldIsbn;
	private JTextField textFieldSubtitulo;
	private JTextField textFieldTitulo;
	private JLabel lblNewLabel;
	private JLabel lblTitulo;
	private JLabel lblSubtitulo;
	private JLabel lblIsbn;
	private JLabel lblDataCadastro;
	private JLabel lblAutor;
	private JTextField textFieldAutor;
	private JTextField textFieldAnoPublicacao;
	private JLabel lblAnoPublicacao;
	private MaskFormatter mascaraIsbn;
	private JTextField textFieldQtdTotal;
	private JLabel lbl;
	private JLabel lblNewLabel_2;
	private JTextField textFieldEditora;
	private JTextField textFieldGenero;
	private String isbnSemMascara;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public PainelCadastroLivro() throws ParseException {
		setBackground(new Color(255, 128, 0));
		setLayout(null);
		
		lblNewLabel = new JLabel("CADASTRAR LIVRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(266, 11, 190, 29);
		add(lblNewLabel);
		
		lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitulo.setBounds(173, 67, 89, 14);
		add(lblTitulo);
		
		lblSubtitulo = new JLabel("Subt\u00EDtulo:");
		lblSubtitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSubtitulo.setBounds(173, 105, 89, 14);
		add(lblSubtitulo);
		
		lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIsbn.setBounds(173, 136, 89, 14);
		add(lblIsbn);
		
		lblDataCadastro = new JLabel("Data Cadastro:");
		lblDataCadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataCadastro.setBounds(173, 268, 89, 14);
		add(lblDataCadastro);
		
		dpDataCadastro = new DatePicker();
		dpDataCadastro.getComponentToggleCalendarButton().setBackground(new Color(0, 221, 221));
		dpDataCadastro.getComponentDateTextField().setBackground(new Color(0, 221, 221));
		dpDataCadastro.setBounds(274, 264, 196, 20);
		add(dpDataCadastro);
		
		mascaraIsbn = new MaskFormatter("###-#-##-######-#");
		mascaraIsbn.setValueContainsLiteralCharacters(false);
		textFieldIsbn = new JFormattedTextField(mascaraIsbn);
		textFieldIsbn.setBackground(new Color(0, 221, 221));
		textFieldIsbn.setBounds(274, 130, 196, 20);
		add(textFieldIsbn);
		textFieldIsbn.setColumns(10);
		
		textFieldSubtitulo = new JTextField();
		textFieldSubtitulo.setBackground(new Color(0, 221, 221));
		textFieldSubtitulo.setBounds(274, 99, 196, 20);
		add(textFieldSubtitulo);
		textFieldSubtitulo.setColumns(10);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBackground(new Color(0, 221, 221));
		textFieldTitulo.setBounds(274, 61, 196, 20);
		add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		lblAutor = new JLabel("Autor:");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAutor.setBounds(173, 164, 46, 14);
		add(lblAutor);
		
		textFieldAutor = new JTextField();
		textFieldAutor.setBackground(new Color(0, 221, 221));
		textFieldAutor.setBounds(274, 161, 196, 20);
		add(textFieldAutor);
		textFieldAutor.setColumns(10);
		
		lblAnoPublicacao = new JLabel("Ano Publica\u00E7\u00E3o:");
		lblAnoPublicacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnoPublicacao.setBounds(173, 197, 101, 14);
		add(lblAnoPublicacao);
		
		textFieldAnoPublicacao = new JTextField();
		textFieldAnoPublicacao.setBackground(new Color(0, 221, 221));
		textFieldAnoPublicacao.setBounds(274, 192, 196, 20);
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
				isbnSemMascara = textFieldIsbn.getText().replace("-", "");
				novoLivro.setIsbn(isbnSemMascara);	
				novoLivro.setAutor(textFieldAutor.getText());
				novoLivro.setDtCadastro(dpDataCadastro.getDate());
				novoLivro.setGenero(textFieldGenero.getText());
				novoLivro.setAnoPublicacao(Integer.valueOf(textFieldAnoPublicacao.getText()));
				novoLivro.setQtdLivros(Integer.valueOf(textFieldQtdTotal.getText()));
				novoLivro.setQtdDisponivel(Integer.valueOf(textFieldQtdTotal.getText()));
				
				try {
					novoLivro = livroController.inserirNovoLivroController(novoLivro);
				} catch (CamposInvalidosException e1) {
					TelaAlerta alerta = new TelaAlerta(e1.getMessage());
					alerta.setVisible(true);
				}				
			}
		});
		btnNewButton.setBounds(260, 607, 196, 23);
		add(btnNewButton);
		
		textFieldQtdTotal = new JTextField();
		textFieldQtdTotal.setBackground(new Color(0, 221, 221));
		textFieldQtdTotal.setBounds(273, 223, 197, 20);
		add(textFieldQtdTotal);
		textFieldQtdTotal.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantidade.setBounds(173, 229, 89, 14);
		add(lblQuantidade);
		
		lbl = new JLabel("Editora:");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl.setBackground(new Color(0, 221, 221));
		lbl.setBounds(173, 319, 74, 14);
		add(lbl);
		
		lblNewLabel_2 = new JLabel("G\u00EAnero:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(173, 367, 46, 14);
		add(lblNewLabel_2);
		
		textFieldEditora = new JTextField();
		textFieldEditora.setBackground(new Color(0, 221, 221));
		textFieldEditora.setBounds(274, 316, 196, 20);
		add(textFieldEditora);
		textFieldEditora.setColumns(10);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setBackground(new Color(0, 221, 221));
		textFieldGenero.setBounds(274, 364, 196, 20);
		add(textFieldGenero);
		textFieldGenero.setColumns(10);
	}
}
