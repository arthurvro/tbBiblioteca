package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.bo.UsuarioBO;
import model.vo.EmprestimoVO;
import model.vo.ExemplaresVO;
import model.vo.LivroVO;
import model.vo.UsuarioVO;

public class EmprestimoDAO {
//	private int idEmprestimo;
//	private int idUsuario;
//	private int idCopiaLivro;
//	private UsuarioBO usuarioBO;
//	private ExemplaresVO copiaLivroVO;
//	private LocalDateTime dtEmprestimoFim;
//	private LocalDateTime dtEmprestimoInicio;
//	private LocalDateTime dtDevolucao;
//	private String descricao;
//	private double valorMulta;
	
	public List<EmprestimoVO> consultarTodosEmprestimos() {
		List<EmprestimoVO> emprestimoVO = new ArrayList<EmprestimoVO>();
		
		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM EMPRESTIMO";
		
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				EmprestimoVO emprestimoBuscado = montarEmprestimoComResultadoDobanco(resultado);
				emprestimoVO.add(emprestimoBuscado);				
			}
		}catch (Exception e) {
			System.out.println("Erro ao buscar todos Emprestimos. \n Causa: "+e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);
		}	
		
		return emprestimoVO;
	}

	private EmprestimoVO montarEmprestimoComResultadoDobanco(ResultSet resultado) throws SQLException {
		EmprestimoVO emprestimoBuscado = new EmprestimoVO();
		
		emprestimoBuscado.setIdEmprestimo(resultado.getInt("idemprestimo"));
		emprestimoBuscado.setDescricao(resultado.getString("descricao"));
		emprestimoBuscado.setDtEmprestimoInicio(resultado.getDate("dtemprestimoinicio").toLocalDate());
		emprestimoBuscado.setDtEmprestimoFim(resultado.getDate("dtemprestimofim").toLocalDate());
		emprestimoBuscado.setDtDevolucao(resultado.getDate("dtdevolucao").toLocalDate());
		emprestimoBuscado.setValorMulta(resultado.getDouble("valormulta"));
		
		int idusuario = resultado.getInt("idusuario");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuarioVO = usuarioDAO.consultarUsuarioPorID(idusuario);
		emprestimoBuscado.setUsuarioVO(usuarioVO);
		
		int idexemplar = resultado.getInt("idexemplares");
		ExemplaresDAO exemplaresDAO = new ExemplaresDAO();
		ExemplaresVO exemplaresVO = exemplaresDAO.consultarExemplresPorID(idexemplar);
		emprestimoBuscado.setCopiaLivroVO(exemplaresVO);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}
	

}
