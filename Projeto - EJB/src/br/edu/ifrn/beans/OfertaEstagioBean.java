package br.edu.ifrn.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.modelo.DiretoriaDAO;
import br.edu.ifrn.modelo.OfertaEstagioDAO;
import br.edu.ifrn.negocio.Aluno;
import br.edu.ifrn.negocio.OfertaEstagio;
import br.edu.ifrn.negocio.Pessoa;
import br.edu.ifrn.negocio.Usuario;

/**
 * Session Bean implementation class OfertaEstagioBean
 */
@Stateless
public class OfertaEstagioBean implements OfertaEstagioBeanRemote {

	/**
	 * Default constructor. 
	 */
	OfertaEstagioDAO dao;
	public OfertaEstagioBean() {
		dao = new OfertaEstagioDAO();
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
	public List<OfertaEstagio> getTodasOfertaEstagiosByDiretoria(String sigla) throws DatabaseException {
		return dao.findByDiretoria(sigla);
	}

	@Override
	public void editarOfertaEstagio(OfertaEstagio e) throws DatabaseException{
		dao.update(e);
	}

	@Override
	public void removerCandidato(long idOferta, long idAluno) throws DatabaseException{
		Usuario u = dao.findById(Usuario.class, idAluno);
		Pessoa p = u.getPessoa();
		if (p instanceof Aluno){
			Aluno a = (Aluno) p;
			OfertaEstagio o = dao.findById(OfertaEstagio.class, idOferta);
			List<Aluno> candidatos = o.getCandidatos();
			Aluno ar = null;
			for (Aluno aluno : candidatos) {
				if (aluno.getId().equals(a.getId())){
					ar = aluno;
					break;
				}
			}
			candidatos.remove(ar);
			o.setCandidatos(candidatos);
			dao.update(o);
		}
	}

	@Override
	public void inserirCandidato(long idOferta, long idAluno) throws DatabaseException{
		Usuario u = dao.findById(Usuario.class, idAluno);
		Pessoa p = u.getPessoa();
		if (p instanceof Aluno){
			Aluno a = (Aluno) p;
			OfertaEstagio o = dao.findById(OfertaEstagio.class, idOferta);
			List<Aluno> alunos = new ArrayList<Aluno>();
			alunos.add(a);
			o.setCandidatos(alunos);
			dao.update(o);
		}

	}
}
