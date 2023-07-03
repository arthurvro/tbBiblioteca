package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
				
				int idTipoUsuario = resultado.getInt("idtipousuario");
				usuarioVO.setTipoUsuario(TipoUsuarioVO.getTipoUsuarioVOPorValor(idTipoUsuario));
				
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

	public UsuarioVO inserirNovoUsuarioDAO(UsuarioVO novoUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		

		String sql = "INSERT INTO USUARIO (NOME, CPF, TELEFONE, DTCADASTRO, LOGIN, SENHA)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conn, sql);
		
		
		try {
			
			query.setString(1, novoUsuario.getNome());
			query.setString(2, novoUsuario.getCpf());
			query.setString(3, novoUsuario.getTelefone());
			query.setObject(4, java.sql.Date.valueOf(novoUsuario.getDtCadastro()));
			query.setString(5, novoUsuario.getLogin());
			query.setString(6, novoUsuario.getSenha());
			
			query.execute();
			ResultSet resultado = query.getGeneratedKeys();
			
						
			if(resultado.next()) {	
				novoUsuario.setIdUsuario(resultado.getInt(1));				
			}
			
		} catch (SQLException erro){
			System.out.println("Erro ao inserir novo Usuario.");
			System.out.println("Erro: " +erro.getMessage());
			
		} finally {			
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return novoUsuario;
	}


	
		
}
