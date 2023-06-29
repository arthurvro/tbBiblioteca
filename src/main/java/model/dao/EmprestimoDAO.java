package model.dao;

import java.time.LocalDateTime;

import model.bo.UsuarioBO;
import model.vo.ExemplaresVO;

public class EmprestimoDAO {
	private int idEmprestimo;
	private int idUsuario;
	private int idCopiaLivro;
	private UsuarioBO usuarioBO;
	private ExemplaresVO copiaLivroVO;
	private LocalDateTime dtEmprestimoFim;
	private LocalDateTime dtEmprestimoInicio;
	private LocalDateTime dtDevolucao;
	private String descricao;
	private double valorMulta;
	

}
