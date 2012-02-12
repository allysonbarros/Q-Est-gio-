package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.InstituicaoEnsino;

/**
 * Session Bean implementation class InstituicaoEnsinoBean
 */
@Stateless
public class InstituicaoEnsinoBean implements InstituicaoEnsinoBeanRemote {

    /**
     * Default constructor. 
     */
	DAO dao;
    public InstituicaoEnsinoBean() {
        // TODO Auto-generated constructor stub
    	dao = new DAO();
    }
	public void cadastrarInstituicaoEnsino(InstituicaoEnsino p) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public void editarInstituicaoEnsino(InstituicaoEnsino p) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.update(p);
	}

	public void deletarInstituicaoEnsino(InstituicaoEnsino p) throws DatabaseException{
		dao.delete(p);
	}

	@Override
	public InstituicaoEnsino getInstituicaoEnsino(Long id) throws DatabaseException{
		// TODO Auto-generated method stub
		return dao.findById(InstituicaoEnsino.class, id);
	}

	@Override
	public List<InstituicaoEnsino> getTodasInstituicoesEnsino() throws DatabaseException{
		// TODO Auto-generated method stub
		return dao.findAll(InstituicaoEnsino.class);
	}

}
