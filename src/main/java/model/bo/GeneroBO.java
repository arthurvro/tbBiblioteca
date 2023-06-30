package model.bo;

import java.util.List;

import model.dao.GeneroDAO;
import model.vo.GeneroVO;

public class GeneroBO {

	public List<GeneroVO> consultarTodosOsGenerosBO(List<GeneroVO> consultarTodos) {
		GeneroDAO generoDAO = new GeneroDAO();
		return generoDAO.consultarTodosOsGenerosDAO();
	}
	


}
