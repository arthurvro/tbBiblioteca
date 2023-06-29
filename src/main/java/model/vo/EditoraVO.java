package model.vo;

public class EditoraVO {
	private int idEditora;
	private String nome;
	private String cnpj;
	private String telefone;
	private EnderecoVO enderecoVO;
	
	
	public EditoraVO(int idEditora, String nome, String cnpj, String telefone, EnderecoVO enderecoVO) {
		super();
		this.idEditora = idEditora;
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.enderecoVO = enderecoVO;
	}
	
	public EditoraVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getIdEditora() {
		return idEditora;
	}
	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public EnderecoVO getEnderecoVO() {
		return enderecoVO;
	}
	public void setEnderecoVO(EnderecoVO enderecoVO) {
		this.enderecoVO = enderecoVO;
	}	
		
}
