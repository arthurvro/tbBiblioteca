package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.vo.UsuarioVO;
import model.vo.EnderecoVO;
import model.vo.TipoUsuarioVO;

public class UsuarioDAO {


	public UsuarioVO realizarLoginDAO(String login, String senha) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = " SELECT * FROM usuario "
				+ " WHERE usuario.login = '" +login +"' "
				+ " AND usuario.senha = '" +senha +"' ";
		
		UsuarioVO usuarioVO= null;
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				usuarioVO = new UsuarioVO();
				
				usuarioVO.setIdUsuario(resultado.getInt("idusuario"));
				usuarioVO.setLogin(resultado.getString("login"));
				usuarioVO.setSenha(resultado.getString("senha"));
				//usuarioVO.setTipoUsuario(TipoUsuarioVO.valueOf(resultado.getString("idtipousuario")));
				usuarioVO.setNome(resultado.getString("nome"));
				usuarioVO.setCpf(resultado.getString("cpf"));
				usuarioVO.setTelefone(resultado.getString("telefone"));
				usuarioVO.setDtCadastro(resultado.getDate("dtcadastro").toLocalDate());
				
				int idEndereco = resultado.getInt("idendereco");
				EnderecoDAO enderecoDAO = new EnderecoDAO();
				EnderecoVO enderecoDoUsuario = enderecoDAO.consultarPorId(idEndereco);				
				usuarioVO.setEnderecoVO(enderecoDoUsuario);
				
			}
			
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query");
			System.out.println("Erro: " +erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}		
		
		return usuarioVO;
	}


	
		
}
