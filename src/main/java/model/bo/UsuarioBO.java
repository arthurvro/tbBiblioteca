package model.bo;

import model.vo.UsuarioVO;
import view.paineis.TelaAlerta;
import model.dao.UsuarioDAO;

public class UsuarioBO {
	
	public UsuarioVO realizarLoginBO(String login, String senha) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if(login.isBlank() || senha.isBlank())
		{
			TelaAlerta alerta = new TelaAlerta("Por Favor, preencha os campos corretamente.");
			alerta.setVisible(true);
			alerta.setModal(true);
		}
		return usuarioDAO.realizarLoginDAO(login, senha);
	}

		

}
