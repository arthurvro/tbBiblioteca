package model.bo;

import model.dao.EnderecoDAO;
import model.vo.EnderecoVO;

public class EnderecoBO {
	EnderecoDAO enderecoDAO = new EnderecoDAO();
	public EnderecoVO inserirNovoEnderecoBO(EnderecoVO novoEndereco) {
		

		return enderecoDAO.inserirNovoEnderecoDAO(novoEndereco);
	}

}
