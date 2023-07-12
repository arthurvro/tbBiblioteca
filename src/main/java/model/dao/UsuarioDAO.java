package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.vo.UsuarioVO;
import model.vo.EnderecoVO;
import model.vo.LivroVO;
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
	
	//-----------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------
	
	public UsuarioVO salvar(UsuarioVO novoUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		String sql = "INSERT INTO USUARIO (NOME, CPF, IDENDERECO, IDTIPOUSUARIO, TELEFONE, DTCADASTRO, LOGIN, SENHA)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conn, sql);
		
		if(novoUsuario.getEnderecoVO().getIdEndereco() == 0) {
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			EnderecoVO enderecoSalvo = enderecoDAO.inserirNovoEnderecoDAO(novoUsuario.getEnderecoVO());
			novoUsuario.setEnderecoVO(enderecoSalvo);
		}
		
		try {
			query.setString(1, novoUsuario.getNome());
			query.setString(2, novoUsuario.getCpf());
			query.setInt(3, novoUsuario.getEnderecoVO().getIdEndereco());			
			query.setInt(4, novoUsuario.getTipoUsuario().getValor());
			query.setString(5, novoUsuario.getTelefone());
			query.setObject(6, java.sql.Date.valueOf(novoUsuario.getDtCadastro()));
			query.setString(7, novoUsuario.getLogin());
			query.setString(8, novoUsuario.getSenha());
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
	
	//-----------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------

	public UsuarioVO consultarUsuarioPorID(int idusuario) {
		UsuarioVO idUsuarioConsultado =null;
		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM USUARIO WHERE IDUSUARIO = ?";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, idusuario);
			ResultSet resultado = query.executeQuery();
			if(resultado.next()) {
				idUsuarioConsultado = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar o Usuário por ID com ID: +"+idUsuarioConsultado+" \n Causa: "+e.getMessage());
						
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
			}
		
		return idUsuarioConsultado;
	}
	//-----------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------
	
	private UsuarioVO converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		UsuarioVO idUsuarioConsultado = new UsuarioVO();
		idUsuarioConsultado.setIdUsuario(resultado.getInt("idusuario"));
		idUsuarioConsultado.setNome(resultado.getString("nome"));
		idUsuarioConsultado.setCpf(resultado.getString("cpf"));
		idUsuarioConsultado.setDtCadastro(resultado.getDate("dtcadastro").toLocalDate());
		return idUsuarioConsultado;
	}
	//-----------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------
	public List<UsuarioVO> consultarTodosUsuarios() {
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM USUARIO";
		
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				UsuarioVO usuarioBuscado = montarUsuarioComResultadoDoBanco(resultado);
				usuarios.add(usuarioBuscado);
			}
			
		}catch(Exception e) {
			System.out.println("Erro ao buscar todos usuarios.");
			System.out.println("Causa: " +e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);
		}
		
		return usuarios;
	}


	//-----------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------
	
	private UsuarioVO montarUsuarioComResultadoDoBanco(ResultSet resultado) throws SQLException {
		UsuarioVO usuarioBuscado = new UsuarioVO();
		
		usuarioBuscado.setIdUsuario(resultado.getInt("idusuario"));
		usuarioBuscado.setTipoUsuario(TipoUsuarioVO.getTipoUsuarioVOPorValor(resultado.getInt("idtipousuario")));
		usuarioBuscado.setNome(resultado.getString("nome"));
		usuarioBuscado.setCpf(resultado.getString("cpf"));
		usuarioBuscado.setTelefone(resultado.getString("telefone"));
		usuarioBuscado.setDtCadastro(resultado.getDate("dtcadastro").toLocalDate());
		usuarioBuscado.setLogin(resultado.getString("login"));
		usuarioBuscado.setSenha(resultado.getString("senha"));
		
		int idEnderecoDoUsuario = resultado.getInt("idendereco");
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		EnderecoVO enderecoVO = enderecoDAO.consultarPorId(idEnderecoDoUsuario);
		usuarioBuscado.setEnderecoVO(enderecoVO);
		
		return usuarioBuscado;
	}

	public boolean existeRegistroPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		System.out.println(cpf);
		String query =  "SELECT cpf FROM usuario WHERE cpf = '" + cpf + "'";
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica a existencia de usuario por CPF.");
			System.out.println("Causa: " +e.getMessage());
			return false;
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public boolean existeRegistroPorLogin(String login) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query =  "SELECT login FROM usuario WHERE login = '" + login + "'";
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica a existencia de usuario por LOGIN.");
			System.out.println("Causa: " +e.getMessage());
			return false;
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public boolean excluir(int idUsuario) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = "+idUsuario;
		Statement stmt = Banco.getStatement(conn);
		
		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		}catch(SQLException e) {
			System.out.println("Erro ao excluir Usuario.");
			System.out.println("Erro: "+e.getMessage());
		}
		boolean excluiu = quantidadeLinhasAfetadas >0;
		if(excluiu) {
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.excluirEndereco(idUsuario);
		}
		return excluiu;
	}


	
		
}
