package model.vo;

import java.time.LocalDate;


public class LivroVO {
	
	private int idLivro;
	private int idGenero;
	private int idEditora;
	private String titulo;
	private String subTitulo;
	private String editora;
	private String isbn;
	private LocalDate dtCadastro;
	private String autor;
	private int anoPublicacao;
	private EditoraVO editoraVO;
	private GeneroVO generoVO;	
	
	public LivroVO(int idLivro, int idGenero, int idEditora, String titulo, String subTitulo, String editora,
			String isbn, LocalDate dtCadastro, String autor, int anoPublicacao, EditoraVO editoraVO,
			GeneroVO generoVO) {
		super();
		this.idLivro = idLivro;
		this.idGenero = idGenero;
		this.idEditora = idEditora;
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.editora = editora;
		this.isbn = isbn;
		this.dtCadastro = dtCadastro;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;
		this.editoraVO = editoraVO;
		this.generoVO = generoVO;
	}
	
	public LivroVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public int getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	public int getIdEditora() {
		return idEditora;
	}
	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
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
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
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
