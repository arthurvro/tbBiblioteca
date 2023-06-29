package controller;


import java.util.List;

import model.bo.LivroBO;
import model.vo.LivroVO;
import view.paineis.TelaAlerta;

public class LivroController {	
	LivroBO livroBO = new LivroBO();
	
	public LivroVO inserirNovoLivroController(LivroVO novoLivro) {
		LivroBO livroBO = new LivroBO();
//		if(novoLivro != null) {
//			TelaAlerta alerta = new TelaAlerta("Por Favor, preencha os campos corretamente.");
//			alerta.setVisible(true);
//			alerta.setModal(true);
//		}
		
		return livroBO.inserirNovoLivroBO(novoLivro);
	}

	public List<LivroVO> consultarTodosLivros() {
		
		return livroBO.consultarTodosLivros();
	}

}
