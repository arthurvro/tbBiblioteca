package model.bo;

import java.util.List;

import model.dao.EmprestimoDAO;
import model.vo.EmprestimoVO;

public class EmprestimoBO {
	EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
	
	public List<EmprestimoVO> consultarTodosEmprestimos() {
		
		return emprestimoDAO.consultarTodosEmprestimos();
	}

	public EmprestimoVO consultarEmprestimoPorIdEmprestimo(int idEmprestimoConvertido) {

		return emprestimoDAO.consultarEmprestimoPorIdEmprestimo(idEmprestimoConvertido);
	}

}
