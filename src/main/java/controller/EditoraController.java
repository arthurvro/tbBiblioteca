package controller;

import java.util.List;

import model.bo.EditoraBO;
import model.vo.EditoraVO;

public class EditoraController {

	public List<EditoraVO> consultarTodasEditoras(List<EditoraVO> consultarTodos) {
		EditoraBO editoraBO = new EditoraBO(); 
		return editoraBO.consultarTodasEditoras(consultarTodos);
	}

}
