package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.modelo.DiretoriaDAO;
import br.edu.ifrn.negocio.Diretoria;

/**
 * Session Bean implementation class DiretoriaBean
 */
@Stateless
public class DiretoriaBean implements DiretoriaBeanRemote {

	DiretoriaDAO dao;
    
	public DiretoriaBean() {
    	dao = new DiretoriaDAO();
    }
    
	public void cadastrarDiretoria(Diretoria p) throws DatabaseException{
		dao.save(p);
	}

	public void editarDiretoria(Diretoria p) throws DatabaseException{
		dao.update(p);
	}

	public void deletarDiretoria(Diretoria p) throws DatabaseException{
		dao.delete(p);
	}

	@Override
	public Diretoria getDiretoria(Long id) throws DatabaseException{
		return dao.findById(Diretoria.class, id);
	}

	@Override
	public List<Diretoria> getTodasDiretorias() throws DatabaseException{
		return dao.findAll(Diretoria.class);
	}
	
	@Override
	public Diretoria getDiretoriaBySigla(String sigla) throws DatabaseException {
		return dao.findBySigla(sigla);
	}

}
