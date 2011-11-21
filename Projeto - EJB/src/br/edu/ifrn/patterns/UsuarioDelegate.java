package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.UsuarioBeanRemote;
import br.edu.ifrn.negocio.Usuario;


public class UsuarioDelegate {

	ServiceLocator locator;
	UsuarioBeanRemote bean;
	
	public UsuarioDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getUsuarioBean();
	} 

	public Usuario cadastrarUsuario(Usuario e) {
		return bean.cadastrarUsuario(e);
	}

	public void editarUsuario(Usuario e) {
		bean.editarUsuario(e);
	}

	public void deletarUsuario(Usuario e) {
		bean.deletarUsuario(e);
	}

	public Usuario getUsuario(Long id) {
		return bean.getUsuario(id);
	}
	
	public Usuario getUsuarioByLogin(String login) {
		return bean.getUsuarioByLogin(login);
	}

	public List<Usuario> getTodosUsuarios() {
		return bean.getTodosUsuarios();
	}
}
