package controller;

import model.bo.EnderecoBO;
import model.vo.EnderecoVO;

public class EnderecoController {
		
	public EnderecoVO inserirNovoEnderecoController(EnderecoVO novoEndereco) {
		EnderecoBO enderecoBO = new EnderecoBO();
		return enderecoBO.inserirNovoEnderecoBO(novoEndereco);
	}

}
