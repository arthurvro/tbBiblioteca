package model.vo;

public class EnderecoVO {
	
	private int idEndereco;
	private String pais;
	private String estado;
	private String cidade;
	private String bairro;
	private String cep;
	private String rua;
	private String numero;
	
	
	public EnderecoVO(int idEndereco, String pais, String estado, String cidade, String bairro, String cep, String rua,
			String numero) {
		super();
		this.idEndereco = idEndereco;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
	}


	public EnderecoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
