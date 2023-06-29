package model.vo;

public class CopiaLivroVO {
	private int idCopiaLivro;
	private int idLivro;
	private int ativo;
	private LivroVO livroVO;
	
	
	
	public CopiaLivroVO(int idCopiaLivro, int idLivro, int ativo, LivroVO livroVO) {
		super();
		this.idCopiaLivro = idCopiaLivro;
		this.idLivro = idLivro;
		this.ativo = ativo;
		this.livroVO = livroVO;
	}

	public CopiaLivroVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIdCopiaLivro() {
		return idCopiaLivro;
	}
	public void setIdCopiaLivro(int idCopiaLivro) {
		this.idCopiaLivro = idCopiaLivro;
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
	public LivroVO getLivroVO() {
		return livroVO;
	}
	public void setLivroVO(LivroVO livroVO) {
		this.livroVO = livroVO;
	}
}
