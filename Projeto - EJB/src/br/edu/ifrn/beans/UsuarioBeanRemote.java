package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.negocio.Usuario;

@Remote
public interface UsuarioBeanRemote {
	public void cadastrarUsuario(Usuario p);
	public void editarUsuario(Usuario p);
	public void deletarUsuario(Usuario p);
	public Usuario getUsuario(Long id);
	public List<Usuario> getTodosUsuarios();
	
}
