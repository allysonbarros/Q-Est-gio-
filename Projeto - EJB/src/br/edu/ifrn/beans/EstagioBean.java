package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Estagio;

/**
 * Session Bean implementation class EstagioBean
 */
@Stateless
public class EstagioBean implements EstagioBeanRemote, EstagioBeanLocal {

    /**
     * Default constructor. 
     */
	DAO dao;
    public EstagioBean() {
        dao = new DAO();
    }

	@Override
	public void cadastrarEstagio(Estagio e) {
		dao.save(e);
	}

	@Override
	public void editarEstagio(Estagio e) {
		dao.update(e);
	}

	@Override
	public void deletarEstagio(Estagio e) {
		dao.delete(e);
	}

	@Override
	public Estagio getEstagio(Long id) {
		return dao.findById(Estagio.class, id);
	}

	@Override
	public List<Estagio> getTodosEstagios() {
		return dao.findAll(Estagio.class);
	}

}
