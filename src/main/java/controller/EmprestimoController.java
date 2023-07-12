package controller;

import java.util.List;

import model.bo.EmprestimoBO;
import model.vo.EmprestimoVO;

public class EmprestimoController {
	EmprestimoBO emprestimoBO = new EmprestimoBO();

	public List<EmprestimoVO> consultarTodosEmprestimos() {		
		return emprestimoBO.consultarTodosEmprestimos();
	}

	public EmprestimoVO consultarEmprestimosPorIdEmprestimo(int idEmprestimoConvertido) {
		

		return emprestimoBO.consultarEmprestimoPorIdEmprestimo(idEmprestimoConvertido);
	}

}
