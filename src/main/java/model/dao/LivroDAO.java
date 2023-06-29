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
		System.out.println(novoLivro.getAutor());
		
		String sql = "INSERT INTO LIVRO (TITULO, SUBTITULO, EDITORA, ISBN, DTCADASTRO,"
				+ " AUTOR, ANOPUBLICACAO)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?) ";
		 PreparedStatement query = Banco.getPreparedStatementWithPk(conn, sql);
		
		 try {
			
				query.setString(1, novoLivro.getTitulo());
				query.setString(2, novoLivro.getSubTitulo());
				query.setString(3, novoLivro.getEditora());
				query.setString(4, novoLivro.getIsbn());				
				query.setObject(5, java.sql.Date.valueOf(novoLivro.getDtCadastro()));
				query.setString(6, novoLivro.getAutor());
				query.setObject(7, novoLivro.getAnoPublicacao());
				
				query.execute();
				ResultSet resultado = query.getGeneratedKeys();
				
				if(resultado.next()) {
					novoLivro.setIdLivro(resultado.getInt(1));
					novoLivro.setIdEditora(resultado.getInt(1));
					novoLivro.setIdGenero(resultado.getInt(1));
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
			System.out.println("Erro ao buscar todos os Livros. \n Causa: "+e.getMessage());
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

}
