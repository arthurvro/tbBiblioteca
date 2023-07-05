package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.ExemplaresVO;

public class ExemplaresDAO {

	public ExemplaresVO consultarExemplresPorID(int idexemplar) {
		ExemplaresVO idExemplarConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM EXEMPLARES WHERE IDEXEMPLARES = ?";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, idexemplar);
			ResultSet resultado = query.executeQuery();
			if(resultado.next()) {
				idExemplarConsultado = converterDeResultSetParaEntidade(resultado);
			}
		}catch (SQLException e) {
			System.out.println("Erro ao buscar o exemplar por ID: "+idExemplarConsultado+" \n Causa: "+e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		
		return idExemplarConsultado;
	}

	private ExemplaresVO converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		ExemplaresVO idExemplarConsultado = new ExemplaresVO();
		idExemplarConsultado.setIdExemplares(resultado.getInt("idexemplares"));
		idExemplarConsultado.setAtivo(resultado.getInt("ativo"));
		idExemplarConsultado.setRegistro(resultado.getInt("registro"));
		
		return idExemplarConsultado;
	}

}
