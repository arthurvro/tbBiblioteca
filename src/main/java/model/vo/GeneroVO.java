package model.vo;

public class GeneroVO {
	private int idGenero;
	private String genero;	
	
	
	public GeneroVO(int idGenero, String genero) {
		super();
		this.idGenero = idGenero;
		this.genero = genero;
	}

	public GeneroVO() {
		super();
	}
	
	
	
	public int getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return  genero ;
	}
	

}
