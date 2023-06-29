package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.GeneroVO;

public class GeneroDAO {

	public GeneroVO consultarGenero(int idGenero) {
		// TODO Auto-generated method stub
		return null;
	}

	public GeneroVO consultarPorIdGenero(int idGeneroDoLivro) {
		GeneroVO idGeneroConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql =" SELECT * FROM GENERO "
				+ " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, idGeneroDoLivro);
			ResultSet resultado = query.executeQuery();
			if(resultado.next()) {
				idGeneroConsultado = converterDeResultSetParaEntidade(resultado);
			}
		}catch (SQLException e) {
			System.out.println("Erro ao buscar o genero com ID: + "+idGeneroDoLivro+"\n Causa: "+e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}		
		return idGeneroConsultado;
	}

	private GeneroVO converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		GeneroVO idGeneroConsultado = new GeneroVO();
		idGeneroConsultado.setIdGenero(resultado.getInt("idgenero"));
		idGeneroConsultado.setGenero(resultado.getString("genero"));
		
		return idGeneroConsultado;
	}

}
