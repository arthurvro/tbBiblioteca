package model.bo;

import java.util.List;

import exception.CamposInvalidosException;
import model.dao.LivroDAO;
import model.vo.LivroVO;
import view.paineis.TelaAlerta;

public class LivroBO {

	private LivroDAO livroDAO = new LivroDAO();

	public LivroVO inserirNovoLivroBO(LivroVO novoLivro) throws CamposInvalidosException {
		LivroDAO livroDAO = new LivroDAO();
		if (novoLivro.getTitulo().isBlank() || novoLivro.getSubTitulo().isBlank() || novoLivro.getEditora().isBlank()
				|| novoLivro.getGenero().isBlank() || novoLivro.getIsbn().isBlank() || novoLivro.getAutor().isBlank()
				|| novoLivro.getDtCadastro() == null || novoLivro.getAnoPublicacao() == 0) {
			throw new CamposInvalidosException("Por Favor, preencha todos campos corretamente.");
		} else {
			return livroDAO.inserirNovoLivroDAO(novoLivro);
		}
	}

	public List<LivroVO> consultarTodosLivros() {

		return livroDAO.consultarTodosLivros();
	}

	public List<LivroVO> consultarLivroPorAutor(String nomeAutor) {

		return livroDAO.consultarLivroPorAutor(nomeAutor);
	}

}
