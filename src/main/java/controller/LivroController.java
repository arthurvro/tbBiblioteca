package controller;


import java.util.List;

import exception.CamposInvalidosException;
import model.bo.LivroBO;
import model.vo.LivroVO;

public class LivroController {	
	LivroBO livroBO = new LivroBO();
	
	public LivroVO inserirNovoLivroController(LivroVO novoLivro) throws CamposInvalidosException {
		LivroBO livroBO = new LivroBO();		
		return livroBO.inserirNovoLivroBO(novoLivro);
	}

	public List<LivroVO> consultarTodosLivros() {
		return livroBO.consultarTodosLivros();
	}

	public List<LivroVO> consultarLivroPorAutor(String nomeAutor) {
		
		return livroBO.consultarLivroPorAutor(nomeAutor);
	}

}
