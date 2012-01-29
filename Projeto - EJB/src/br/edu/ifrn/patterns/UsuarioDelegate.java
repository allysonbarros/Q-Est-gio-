package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.UsuarioBeanRemote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Usuario;


public class UsuarioDelegate {

	ServiceLocator locator;
	UsuarioBeanRemote bean;
	
	public UsuarioDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getUsuarioBean();
	} 

	public Usuario cadastrarUsuario(Usuario e) throws DatabaseException {
		return bean.cadastrarUsuario(e);
	}

	public void editarUsuario(Usuario e) throws DatabaseException {
		bean.editarUsuario(e);
	}

	public void deletarUsuario(Usuario e) throws DatabaseException {
		bean.deletarUsuario(e);
	}

	public Usuario getUsuario(Long id) throws DatabaseException {
		return bean.getUsuario(id);
	}
	
	public Usuario getUsuarioByLogin(String login) throws DatabaseException {
		return bean.getUsuarioByLogin(login);
	}
	
	public Usuario getUsuarioByEmail(String email) throws DatabaseException {
		return bean.getUsuarioByEmail(email);
	}
	
	public List<Usuario> getTodosUsuarios() throws DatabaseException {
		return bean.getTodosUsuarios();
	}
}
