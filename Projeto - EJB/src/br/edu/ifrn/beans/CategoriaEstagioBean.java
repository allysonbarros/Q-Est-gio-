package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.CategoriaEstagio;

/**
 * Session Bean implementation class CategoriaEstagio
 */
@Stateless
public class CategoriaEstagioBean implements CategoriaEstagioBeanRemote {

    /**
     * Default constructor. 
     */
	DAO dao;
    public CategoriaEstagioBean() {
        // TODO Auto-generated constructor stub
    	dao = new DAO();
    }
	public void cadastrarCategoriaEstagio(CategoriaEstagio p) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public void editarCategoriaEstagio(CategoriaEstagio p) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.update(p);
	}

	public void deletarCategoriaEstagio(CategoriaEstagio p) throws DatabaseException{
		dao.delete(p);
	}

	@Override
	public CategoriaEstagio getCategoriaEstagio(Long id) throws DatabaseException{
		// TODO Auto-generated method stub
		return dao.findById(CategoriaEstagio.class, id);
	}

	@Override
	public List<CategoriaEstagio> getTodasCategoriaEstagios() throws DatabaseException{
		// TODO Auto-generated method stub
		return dao.findAll(CategoriaEstagio.class);
	}
}
