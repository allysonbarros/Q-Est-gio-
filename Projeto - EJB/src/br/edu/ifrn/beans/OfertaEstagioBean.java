package br.edu.ifrn.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Aluno;
import br.edu.ifrn.negocio.OfertaEstagio;

/**
 * Session Bean implementation class OfertaEstagioBean
 */
@Stateless
public class OfertaEstagioBean implements OfertaEstagioBeanRemote, OfertaEstagioBeanLocal {

    /**
     * Default constructor. 
     */
	DAO dao;
    public OfertaEstagioBean() {
        dao = new DAO();
    }

	@Override
	public void cadastrarOfertaEstagio(OfertaEstagio e) throws DatabaseException{
		dao.save(e);
	}
	
	@Override
	public void deletarOfertaEstagio(OfertaEstagio e) throws DatabaseException{
		dao.delete(e);
	}

	@Override
	public OfertaEstagio getOfertaEstagio(Long id) throws DatabaseException{
		return dao.findById(OfertaEstagio.class, id);
	}

	@Override
	public List<OfertaEstagio> getTodasOfertaEstagios() throws DatabaseException{
		return dao.findAll(OfertaEstagio.class);
	}

	@Override
	public void editarOfertaEstagio(OfertaEstagio e) throws DatabaseException{
		dao.update(e);
	}

	@Override
	public void removerCandidato(long idOferta, long idAluno) throws DatabaseException{
		
		
		
	}

	@Override
	public void inserirCandidato(long idOferta, long idAluno) throws DatabaseException{
		Aluno a = dao.findById(Aluno.class, idAluno);
		OfertaEstagio o = dao.findById(OfertaEstagio.class, idOferta);
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(a);
		o.setCandidatos(alunos);
		dao.update(o);
		
	}

	

}
