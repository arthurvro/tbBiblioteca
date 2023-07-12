package model.vo;

import java.time.LocalDate;


public class LivroVO {
	
	private int idLivro;
	private int anoPublicacao;
	private String titulo;
	private String subTitulo;
	private String isbn;
	private String autor;
	private String editora;
	private String genero;
	private int qtdLivros;
	private int qtdDisponivel;
	private LocalDate dtCadastro;
	private EditoraVO editoraVO;
	private GeneroVO generoVO;
	
	

	
	public LivroVO(int idLivro, int anoPublicacao, String titulo, String subTitulo,	String isbn, String autor, String editora, String genero, int qtdLivros, int qtdDisponivel, LocalDate dtCadastro, EditoraVO editoraVO,
			GeneroVO generoVO) {
		super();
		this.idLivro = idLivro;
		this.anoPublicacao = anoPublicacao;
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.isbn = isbn;
		this.autor = autor;
		this.editora = editora;
		this.genero = genero;
		this.qtdLivros = qtdLivros;
		this.qtdDisponivel = qtdDisponivel;
		this.dtCadastro = dtCadastro;
		this.editoraVO = editoraVO;
		this.generoVO = generoVO;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public LivroVO() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	public String getEditora() {
		return editora;
	}


	public void setEditora(String editora) {
		this.editora = editora;
	}


	public int getQtdLivros() {
		return qtdLivros;
	}

	public void setQtdLivros(int qtdLivros) {
		this.qtdLivros = qtdLivros;
	}

	public int getQtdDisponivel() {
		return qtdDisponivel;
	}

	public void setQtdDisponivel(int qtdDisponivel) {
		this.qtdDisponivel = qtdDisponivel;
	}

	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubTitulo() {
		return subTitulo;
	}
	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public LocalDate getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(LocalDate dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public EditoraVO getEditoraVO() {
		return editoraVO;
	}
	public void setEditoraVO(EditoraVO editoraVO) {
		this.editoraVO = editoraVO;
	}
	public GeneroVO getGeneroVO() {
		return generoVO;
	}
	public void setGeneroVO(GeneroVO generoVO) {
		this.generoVO = generoVO;
	}	
}
