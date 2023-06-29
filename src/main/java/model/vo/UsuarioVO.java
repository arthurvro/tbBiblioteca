package model.vo;

import java.time.LocalDate;

public class UsuarioVO {
	
	private int idUsuario;
	private TipoUsuarioVO tipoUsuario;
	private String nome;
	private String cpf;
	private String telefone;
	private LocalDate dtCadastro;
	private String login;
	private String senha;
	private EnderecoVO enderecoVO;
	
	
	public UsuarioVO(int idUsuario, TipoUsuarioVO tipoUsuario, String nome, String cpf, String telefone,
			LocalDate dtCadastro, String login, String senha, EnderecoVO enderecoVO) {
		super();
		this.idUsuario = idUsuario;
		this.tipoUsuario = tipoUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dtCadastro = dtCadastro;
		this.login = login;
		this.senha = senha;
		this.enderecoVO = enderecoVO;
	}

	public UsuarioVO() {
		super();
		
	}
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public TipoUsuarioVO getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuarioVO tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(LocalDate dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public EnderecoVO getEnderecoVO() {
		return enderecoVO;
	}
	public void setEnderecoVO(EnderecoVO enderecoVO) {
		this.enderecoVO = enderecoVO;
	}
	
}
