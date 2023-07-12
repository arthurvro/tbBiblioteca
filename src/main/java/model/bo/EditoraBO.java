package model.bo;

import java.util.List;

import model.dao.EditoraDAO;
import model.vo.EditoraVO;

public class EditoraBO {

	public List<EditoraVO> consultarTodasEditoras(List<EditoraVO> consultarTodos) {
		EditoraDAO editoraDAO = new EditoraDAO();
		return editoraDAO.consultarTodasEditoras(consultarTodos);
	}

}
