package controller;

import java.util.List;

import exception.CamposInvalidosException;
import exception.ClienteComEnderecoException;
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

	public UsuarioVO inserirNovoUsuarioController(UsuarioVO novoUsuario) throws CamposInvalidosException {		
		UsuarioBO novoUsuarioBO = new UsuarioBO();
		
		
		return novoUsuarioBO.inserirNovoUsuarioBO(novoUsuario);
	}

	public List<UsuarioVO> consultarTodosUsuarios() {
		UsuarioBO usuarioBO = new UsuarioBO();
		return usuarioBO.consultarTodosUsuarios();
	}

	public boolean excluir(int idUsuario)throws ClienteComEnderecoException {
		
		return UsuarioBO.excluir(idUsuario);

		
	}

	

	

	

}
