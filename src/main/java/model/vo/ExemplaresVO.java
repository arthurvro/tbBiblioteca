package model.vo;

public class ExemplaresVO {
	private int idExemplares;
	private int idLivro;
	private int registro;
	private int ativo;
	private LivroVO livroVO;
	
	public ExemplaresVO(int idExemplares, int idLivro, int registro, int ativo, LivroVO livroVO) {
	
		super();
		this.idExemplares = idExemplares;
		this.idLivro = idLivro;
		this.registro = registro;
		this.ativo = ativo;
		this.livroVO = livroVO;
	}
	
	public ExemplaresVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getIdExemplares() {
		return idExemplares;
	}
	public void setIdExemplares(int idExemplares) {
		this.idExemplares = idExemplares;
	}
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	public LivroVO getLivroVO() {
		return livroVO;
	}
	public void setLivroVO(LivroVO livroVO) {
		this.livroVO = livroVO;
	}	
	
}
