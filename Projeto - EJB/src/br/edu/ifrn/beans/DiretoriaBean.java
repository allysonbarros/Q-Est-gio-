package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Diretoria;

/**
 * Session Bean implementation class DiretoriaBean
 */
@Stateless
public class DiretoriaBean implements DiretoriaBeanRemote {

    /**
     * Default constructor. 
     */
	DAO dao;
    public DiretoriaBean() {
        // TODO Auto-generated constructor stub
    	dao = new DAO();
    }
	public void cadastrarDiretoria(Diretoria p) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public void editarDiretoria(Diretoria p) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.update(p);
	}

	public void deletarDiretoria(Diretoria p) throws DatabaseException{
		dao.delete(p);
	}

	@Override
	public Diretoria getDiretoria(Long id) throws DatabaseException{
		// TODO Auto-generated method stub
		return dao.findById(Diretoria.class, id);
	}

	@Override
	public List<Diretoria> getTodasDiretorias() throws DatabaseException{
		// TODO Auto-generated method stub
		return dao.findAll(Diretoria.class);
	}

}
