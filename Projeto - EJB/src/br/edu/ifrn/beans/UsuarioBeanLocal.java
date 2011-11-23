package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Local;

import br.edu.ifrn.negocio.Usuario;

@Local
public interface UsuarioBeanLocal {
	public Usuario cadastrarUsuario(Usuario p);
	public void editarUsuario(Usuario p);
	public void deletarUsuario(Usuario p);
	public Usuario getUsuario(Long id);
	public Usuario getUsuarioByLogin(String login);
	public Usuario getUsuarioByEmail(String email);
	public List<Usuario> getTodosUsuarios();
}
