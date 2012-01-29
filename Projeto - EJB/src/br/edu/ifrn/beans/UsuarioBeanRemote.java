package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Usuario;

@Remote
public interface UsuarioBeanRemote {
	public Usuario cadastrarUsuario(Usuario p) throws DatabaseException;
	public void editarUsuario(Usuario p) throws DatabaseException;
	public void deletarUsuario(Usuario p) throws DatabaseException;
	public Usuario getUsuario(Long id) throws DatabaseException;
	public Usuario getUsuarioByLogin(String login) throws DatabaseException;
	public Usuario getUsuarioByEmail(String email) throws DatabaseException;
	public List<Usuario> getTodosUsuarios() throws DatabaseException;
}
