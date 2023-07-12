package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.vo.EditoraVO;
import model.vo.GeneroVO;
import model.vo.LivroVO;

public class LivroDAO {

	public LivroVO inserirNovoLivroDAO(LivroVO novoLivro) {
		Connection conn = Banco.getConnection();				
		
		
		String sql = "INSERT INTO LIVRO (TITULO, SUBTITULO, EDITORA, ISBN, DTCADASTRO,"
				+ " AUTOR, ANOPUBLICACAO)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		 PreparedStatement query = Banco.getPreparedStatementWithPk(conn, sql);
		
		 try {
			
				query.setString(1, novoLivro.getTitulo());
				query.setString(2, novoLivro.getSubTitulo());
				query.setString(3, novoLivro.getEditora());
				query.setString(4, novoLivro.getIsbn());				
				query.setObject(5, java.sql.Date.valueOf(novoLivro.getDtCadastro()));
				query.setString(6, novoLivro.getAutor());
				query.setObject(7, novoLivro.getAnoPublicacao());
				query.setObject(8, novoLivro.getQtdLivros());
				query.setObject(9, novoLivro.getQtdDisponivel());
				
				query.execute();
				ResultSet resultado = query.getGeneratedKeys();
				
				if(resultado.next()) {
					//TODO REVISAR
					novoLivro.setIdLivro(resultado.getInt(1));
					//novoLivro.setIdEditora(resultado.getInt(1));
				}
		
		} catch (SQLException erro) {
			System.out.println("Erro ao inserir novo livro");
			System.out.println("Erro: " +erro.getMessage());
			
		} finally {			
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);			
		}
		return novoLivro;
	}

	public List<LivroVO> consultarTodosLivros() {
		List<LivroVO> livros = new ArrayList<LivroVO>();
		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM LIVRO";
		
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		try {
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				LivroVO livroBuscado = montarLivroComResultadoDoBanco(resultado);
				livros.add(livroBuscado);
			}
		}catch (Exception e) {
			System.out.println("Erro ao buscar todos os Livros. "
					+ "\n Causa: "+e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);
		}
		
		return livros;
	}

	private LivroVO montarLivroComResultadoDoBanco(ResultSet resultado) throws SQLException {
		LivroVO livroBuscado = new LivroVO();
		
		livroBuscado.setIdLivro(resultado.getInt("idlivro"));
		livroBuscado.setTitulo(resultado.getString("titulo"));
		livroBuscado.setSubTitulo(resultado.getString("subtitulo"));
		livroBuscado.setEditora(resultado.getString("editora"));
		livroBuscado.setIsbn(resultado.getString("isbn"));
		livroBuscado.setAutor(resultado.getString("autor"));
		livroBuscado.setDtCadastro(resultado.getDate("dtcadastro").toLocalDate());
		livroBuscado.setAnoPublicacao(resultado.getInt("anopublicacao"));
		
		int idGeneroDoLivro = resultado.getInt("idgenero");
		GeneroDAO generoDAO = new GeneroDAO();
		GeneroVO generoVO = generoDAO.consultarPorIdGenero(idGeneroDoLivro);
		livroBuscado.setGeneroVO(generoVO);
		
		int idEditoraDoLivro = resultado.getInt("ideditora");
		EditoraDAO editoraDAO = new EditoraDAO();
		EditoraVO editoraVO = editoraDAO.consultarPorIdEditora(idEditoraDoLivro);
		livroBuscado.setEditoraVO(editoraVO);		
		
		return livroBuscado;
	}

	public List<LivroVO> consultarLivroPorAutor(String nomeAutor) {
		List<LivroVO> livrosBuscado = new ArrayList<LivroVO>();
		
		Connection conexao = Banco.getConnection();
		
		String sql = "SELECT * FROM LIVRO WHERE AUTOR = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setString(1, nomeAutor);
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				LivroVO autorBuscado= converterDeResultSetParaEntidade(resultado);
				livrosBuscado.add(autorBuscado);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar livro por autor."+nomeAutor);
			System.out.println("Causa: " +e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return livrosBuscado;
	}

	private LivroVO converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		LivroVO livrosBuscado = new LivroVO();
		livrosBuscado.setIdLivro(resultado.getInt("idlivro"));
		livrosBuscado.setTitulo(resultado.getString("titulo"));
		livrosBuscado.setSubTitulo(resultado.getString("subtitulo"));
		livrosBuscado.setIsbn(resultado.getString("isbn"));
		livrosBuscado.setDtCadastro(resultado.getDate("dtcadastro").toLocalDate());
		livrosBuscado.setAutor(resultado.getString("autor"));
		livrosBuscado.setAnoPublicacao(resultado.getInt("anopublicacao"));
		
		int idEditoraDoLivro = resultado.getInt("ideditora");
		EditoraDAO editoraDAO = new EditoraDAO();
		EditoraVO editoraVO = editoraDAO.consultarPorIdEditora(idEditoraDoLivro);
		
		livrosBuscado.setEditoraVO(editoraVO);
		
		return livrosBuscado;
	}

}
