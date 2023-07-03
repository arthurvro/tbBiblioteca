package controller;

import model.bo.UsuarioBO;
import model.vo.UsuarioVO;
import view.paineis.TelaAlerta;

public class UsuarioController {	


	public UsuarioVO autenticarLoginController(String login, String senha) {
		UsuarioBO usuarioBO = new UsuarioBO();				
		if(login == null || senha == null) {
			TelaAlerta alerta = new TelaAlerta("Por Favor, preencha os campos corretamente.");
			alerta.setVisible(true);
			alerta.setModal(true);			
		}
		
		return usuarioBO.realizarLoginBO(login, senha);
	}

	public UsuarioVO inserirNovoUsuarioController(UsuarioVO novoUsuario) {		
		UsuarioBO novoUsuarioBO = new UsuarioBO();
		
		
		return novoUsuarioBO.inserirNovoUsuarioBO(novoUsuario);
	}

	

	

	

}
