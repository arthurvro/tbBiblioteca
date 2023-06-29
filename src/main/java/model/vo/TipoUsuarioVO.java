package model.vo;

public enum TipoUsuarioVO {
	ADMINISTRADOR (1),
	LEITOR (2);
	
	private int valor;

	TipoUsuarioVO(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}

	

}
