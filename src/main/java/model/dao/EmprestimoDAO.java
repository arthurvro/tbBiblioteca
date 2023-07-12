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

	public List<EmprestimoVO> consultarTodosEmprestimos() {
		List<EmprestimoVO> emprestimoVO = new ArrayList<EmprestimoVO>();

		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM EMPRESTIMO";
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		try {
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				EmprestimoVO emprestimoBuscado = montarEmprestimoComResultadoDobanco(resultado);
				emprestimoVO.add(emprestimoBuscado);
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar todos Emprestimos. \n Causa: " + e.getMessage());
		} finally {
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

		return emprestimoBuscado;
	}

	public EmprestimoVO consultarEmprestimoPorIdEmprestimo(int idEmprestimoConvertido) {
		EmprestimoVO emprestimoPorIdBuscado = null;
		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM EMPRESTIMO WHERE IDEMPRESTIMO = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, idEmprestimoConvertido);
			ResultSet resultado = query.executeQuery();
			if(resultado.next()) {
				emprestimoPorIdBuscado = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar Emprestimo por ID.");
			System.out.println("Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return emprestimoPorIdBuscado;
	}

	private EmprestimoVO converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		EmprestimoVO idEmprestimoConsultado = new EmprestimoVO();
		idEmprestimoConsultado.setIdEmprestimo(resultado.getInt("idemprestimo"));
		idEmprestimoConsultado.setCopiaLivroVO(null);
		idEmprestimoConsultado.setUsuarioVO(null);
		idEmprestimoConsultado.setDescricao(resultado.getString("descricao"));
		idEmprestimoConsultado.setDtEmprestimoInicio(resultado.getDate("dtemprestimoinicio").toLocalDate());
		idEmprestimoConsultado.setDtEmprestimoFim(resultado.getDate("dtemprestimofim").toLocalDate());
		idEmprestimoConsultado.setDtDevolucao(resultado.getDate("dtdevolucao").toLocalDate());
		idEmprestimoConsultado.setValorMulta(resultado.getDouble("valormulta"));
		return idEmprestimoConsultado;
	}
}
