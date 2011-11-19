package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Pessoa;
import br.edu.ifrn.negocio.Usuario;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
@LocalBean
public class UsuarioBean implements UsuarioBeanRemote, UsuarioBeanLocal {

    /**
     * Default constructor. 
     */
	DAO dao;
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    	dao = new DAO();
    }

	@Override
	public void cadastrarUsuario(Usuario o) {
		// TODO Auto-generated method stub
		dao.save(o);
	}

	@Override
	public void editarUsuario(Usuario o) {
		// TODO Auto-generated method stub
		dao.update(o);
	}

	@Override
	public void deletarUsuario(Usuario o) {
		// TODO Auto-generated method stub
		dao.delete(o);
	}

	@Override
	public Usuario getUsuario(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(Pessoa.class, id);
	}

	@Override
	public List<Usuario> getTodosUsuarios() {
		// TODO Auto-generated method stub
		return dao.findAll(Usuario.class);
	}

}