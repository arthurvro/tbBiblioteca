package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				+ " WHERE IDGENERO = ?";
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

	public List<GeneroVO> consultarTodosOsGenerosDAO() {
		List<GeneroVO> generos = new ArrayList<GeneroVO>();
		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM GENERO";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				GeneroVO generoConsultado = converterDeResultSetParaEntidade(resultado);
				generos.add(generoConsultado);
			}
		}catch(SQLException e) {
			System.out.println("Erro ao buscar todos os Generos"
					+ "\n Causa: " +e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return generos;
	}



}
