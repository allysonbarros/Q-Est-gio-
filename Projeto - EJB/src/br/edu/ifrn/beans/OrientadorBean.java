package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Orientador;

/**
 * Session Bean implementation class OrientadorBean
 */
@Stateless
public class OrientadorBean implements OrientadorBeanRemote, OrientadorBeanLocal {

	DAO dao;
    public OrientadorBean() {
        // TODO Auto-generated constructor stub
    	dao = new DAO();
    }

	public void cadastrarOrientador(Orientador p) {
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public void editarOrientador(Orientador p) {
		// TODO Auto-generated method stub
		dao.update(p);
	}

	public void deletarOrientador(Orientador p) {
		dao.delete(p);
	}

	@Override
	public Orientador getOrientador(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(Orientador.class, id);
	}

	@Override
	public List<Orientador> getTodosOrientadores() {
		// TODO Auto-generated method stub
		return dao.findAll(Orientador.class);
	}

}
