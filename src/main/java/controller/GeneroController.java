package controller;

import model.vo.GeneroVO;

import java.util.List;

import model.bo.GeneroBO;

public class GeneroController {
	
public List<GeneroVO> consultarTodosOsGeneros(List<GeneroVO> consultarTodos) {
	GeneroBO generoBO = new GeneroBO();
	return generoBO.consultarTodosOsGenerosBO(consultarTodos);
}
	
}
