package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.EnderecoVO;

public class EnderecoDAO {

	public EnderecoVO consultarPorId(int idEndereco) {
		EnderecoVO enderecoBuscado = null;
		Connection conexao = Banco.getConnection();
		
		String sql = " SELECT * FROM ENDERECO " 
				+ " WHERE IDENDERECO = ? ";
		PreparedStatement query  = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, idEndereco);
			ResultSet resultado = query.executeQuery();
			if(resultado.next()) {
				enderecoBuscado = converterDeResultSetParaEntidade (resultado);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar endereco com id: + " +idEndereco+"\n Causa: " +e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return enderecoBuscado;
		
	}
	private EnderecoVO converterDeResultSetParaEntidade (ResultSet resultado)throws SQLException{

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
}
