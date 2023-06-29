package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.EditoraVO;

public class EditoraDAO {

	public EditoraVO consultarEditora(int idEditora) {
		// TODO Auto-generated method stub
		return null;
	}

	public EditoraVO consultarPorIdEditora(int idEditoraDoLivro) {
		EditoraVO idEditoraDoLivroConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM EDITORA "
				+ " WHERE IDEDITORA = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, idEditoraDoLivro);
			ResultSet resultado = query.executeQuery();
			if(resultado.next()) {
				idEditoraDoLivroConsultado = converterDeResultSetParaEntidade(resultado);
			}
		}catch (SQLException e) {
			System.out.println("Erro ao buscar editora com o id: + "+idEditoraDoLivro+"\n Causa: "+ e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return idEditoraDoLivroConsultado;
	}

	private EditoraVO converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		EditoraVO idEditoraDoLivroConsultado = new EditoraVO();
		idEditoraDoLivroConsultado.setIdEditora(resultado.getInt("ideditora"));
		idEditoraDoLivroConsultado.setNome(resultado.getString("nome"));
		idEditoraDoLivroConsultado.setCnpj(resultado.getString("cnpj"));
		idEditoraDoLivroConsultado.setTelefone(resultado.getString("telefone"));
		
		
		return idEditoraDoLivroConsultado;
	}

}
