package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.EditoraVO;
import model.vo.EnderecoVO;

public class EditoraDAO {

	public List<EditoraVO> consultarTodasEditoras(List<EditoraVO> consultarTodos) {
		List<EditoraVO> editoras = new ArrayList<EditoraVO>();
		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM EDITORA";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				EditoraVO editoraConsultado = montarEditoraComResultadoDoBanco(resultado);
				editoras.add(editoraConsultado);
			}
		}catch (SQLException e) {
			System.out.println("Erro ao buscar todas Editoras.");
			System.out.println("Causa: " +e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return editoras;
	}

	private EditoraVO montarEditoraComResultadoDoBanco(ResultSet resultado) throws SQLException {
		EditoraVO editoraBuscado = new EditoraVO();
		
		editoraBuscado.setIdEditora(resultado.getInt("ideditora"));
		editoraBuscado.setNome(resultado.getString("nome"));
		editoraBuscado.setCnpj(resultado.getString("cnpj"));
		editoraBuscado.setTelefone(resultado.getString("telefone"));
		
		int idEnderecoDaEditora = resultado.getInt("idendereco");
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		EnderecoVO enderecoVO = enderecoDAO.consultarPorId(idEnderecoDaEditora);
		editoraBuscado.setEnderecoVO(enderecoVO);
		
		
		return editoraBuscado;
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
