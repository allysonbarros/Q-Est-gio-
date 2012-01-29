package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.UsuarioDAO;
import br.edu.ifrn.negocio.Usuario;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
@LocalBean
public class UsuarioBean implements UsuarioBeanRemote , UsuarioBeanLocal {

    /**
     * Default constructor. 
     */
	UsuarioDAO dao;
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    	dao = new UsuarioDAO();
    }

	@Override
	public Usuario cadastrarUsuario(Usuario o) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.save(o);
		return o;
	}

	@Override
	public void editarUsuario(Usuario o) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.update(o);
	}

	@Override
	public void deletarUsuario(Usuario o) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.delete(o);
	}

	@Override
	public Usuario getUsuario(Long id) throws DatabaseException{
		// TODO Auto-generated method stub
		return dao.findById(Usuario.class, id);
	}

	@Override
	public List<Usuario> getTodosUsuarios() throws DatabaseException{
		// TODO Auto-generated method stub
		return dao.findAll(Usuario.class);
	}

	@Override
	public Usuario getUsuarioByLogin(String login) throws DatabaseException{
		return dao.findByLogin(login);
	}

	@Override
	public Usuario getUsuarioByEmail(String email) throws DatabaseException{
		return dao.findByEmail(email);
	}

}
