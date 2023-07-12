package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.lang.model.element.QualifiedNameable;

import model.vo.EnderecoVO;

public class EnderecoDAO {

	public EnderecoVO consultarPorId(int idEndereco) {
		EnderecoVO enderecoBuscado = null;
		Connection conexao = Banco.getConnection();

		String sql = " SELECT * FROM ENDERECO " + " WHERE IDENDERECO = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			query.setInt(1, idEndereco);
			ResultSet resultado = query.executeQuery();
			if (resultado.next()) {
				enderecoBuscado = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar endereco com id: + " + idEndereco + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return enderecoBuscado;

	}

	private EnderecoVO converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {

		EnderecoVO enderecoBuscado = new EnderecoVO();
		enderecoBuscado.setIdEndereco(resultado.getInt("idendereco"));
		enderecoBuscado.setPais(resultado.getString("pais"));
		enderecoBuscado.setEstado(resultado.getString("estado"));
		enderecoBuscado.setCidade(resultado.getString("cidade"));
		enderecoBuscado.setBairro(resultado.getString("bairro"));
		enderecoBuscado.setCep(resultado.getString("cep"));
		enderecoBuscado.setRua(resultado.getString("rua"));
		enderecoBuscado.setNumero(resultado.getString("numero"));
		return enderecoBuscado;
	}

	public EnderecoVO inserirNovoEnderecoDAO(EnderecoVO novoEndereco) {

		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);

		String sql = "INSERT INTO ENDERECO (PAIS, ESTADO, CIDADE, BAIRRO, CEP, RUA, NUMERO)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		try {
			query.setString(1, novoEndereco.getPais());
			query.setString(2, novoEndereco.getEstado());
			query.setString(3, novoEndereco.getCidade());
			query.setString(4, novoEndereco.getBairro());
			query.setString(5, novoEndereco.getCep());
			query.setString(6, novoEndereco.getRua());
			query.setString(7, novoEndereco.getNumero());
			query.execute();
			ResultSet resultado = query.getGeneratedKeys();
			if (resultado.next()) {
				novoEndereco.setIdEndereco(resultado.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo Endereco.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return novoEndereco;
	}

	public void excluirEndereco(int idUsuario) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM ENDERECO WHERE IDENDERECO= " + idUsuario;
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		try {
			stmt.setInt(1, idUsuario);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao Excluir Endereco.");
			System.out.println("Erro: " + e.getMessage());
		}

	}

}
