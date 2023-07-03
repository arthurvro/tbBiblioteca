package model.vo;

import java.time.LocalDate;

public class EmprestimoVO {
	private int idEmprestimo;
	private LocalDate  dtEmprestimoInicio;
	private LocalDate dtEmprestimoFim;
	private LocalDate dtDevolucao;
	private double valorMulta;
	private String descricao;
	private UsuarioVO usuarioVO;
	private ExemplaresVO exemplaresVO;
	
	
	public EmprestimoVO(int idEmprestimo, LocalDate dtEmprestimoInicio, LocalDate dtEmprestimoFim,
			LocalDate dtDevolucao, double valorMulta, String descricao, UsuarioVO usuarioVO,
			ExemplaresVO copiaLivroVO) {
		super();
		this.idEmprestimo = idEmprestimo;
		this.dtEmprestimoInicio = dtEmprestimoInicio;
		this.dtEmprestimoFim = dtEmprestimoFim;
		this.dtDevolucao = dtDevolucao;
		this.valorMulta = valorMulta;
		this.descricao = descricao;
		this.usuarioVO = usuarioVO;
		this.exemplaresVO = copiaLivroVO;
	}

	public EmprestimoVO() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	public int getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public LocalDate getDtEmprestimoInicio() {
		return dtEmprestimoInicio;
	}
	public void setDtEmprestimoInicio(LocalDate dtEmprestimoInicio) {
		this.dtEmprestimoInicio = dtEmprestimoInicio;
	}
	public LocalDate getDtEmprestimoFim() {
		return dtEmprestimoFim;
	}
	public void setDtEmprestimoFim(LocalDate dtEmprestimoFim) {
		this.dtEmprestimoFim = dtEmprestimoFim;
	}
	public LocalDate getDtDevolucao() {
		return dtDevolucao;
	}
	public void setDtDevolucao(LocalDate dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}
	public double getValorMulta() {
		return valorMulta;
	}
	public void setValorMulta(double valorMulta) {
		this.valorMulta = valorMulta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public UsuarioVO getUsuarioVO() {
		return usuarioVO;
	}
	public void setUsuarioVO(UsuarioVO usuarioVO) {
		this.usuarioVO = usuarioVO;
	}
	public ExemplaresVO getCopiaLivroVO() {
		return exemplaresVO;
	}
	public void setCopiaLivroVO(ExemplaresVO copiaLivroVO) {
		this.exemplaresVO = copiaLivroVO;
	}		
}
