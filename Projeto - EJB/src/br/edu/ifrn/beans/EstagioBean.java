package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Aluno;
import br.edu.ifrn.negocio.Empresa;
import br.edu.ifrn.negocio.Estagio;
import br.edu.ifrn.negocio.OfertaEstagio;
import br.edu.ifrn.negocio.Orientador;
import br.edu.ifrn.patterns.AlunoDelegate;
import br.edu.ifrn.patterns.OfertaEstagioDelegate;
import br.edu.ifrn.patterns.OrientadorDelegate;

/**
 * Session Bean implementation class EstagioBean
 */
@Stateless
public class EstagioBean implements EstagioBeanRemote {

    /**
     * Default constructor. 
     */
	DAO dao;
    public EstagioBean() {
        dao = new DAO();
    }

	@Override
	public void cadastrarEstagio(Estagio e) throws DatabaseException{
		dao.save(e);
	}

	@Override
	public void editarEstagio(Estagio e) throws DatabaseException{
		dao.update(e);
	}

	@Override
	public void deletarEstagio(Estagio e) throws DatabaseException{
		dao.delete(e);
	}

	@Override
	public Estagio getEstagio(Long id) throws DatabaseException{
		return dao.findById(Estagio.class, id);
	}

	@Override
	public List<Estagio> getTodosEstagios() throws DatabaseException{
		return dao.findAll(Estagio.class);
	}

	@Override
	public void registrarEstagio(long alunoid, long orientadorid,
			long ofertaid) throws Exception {
		
		OfertaEstagioDelegate ofd = new OfertaEstagioDelegate();
		AlunoDelegate ad = new AlunoDelegate();
		OrientadorDelegate od = new OrientadorDelegate();
		
		OfertaEstagio oferta = ofd.getOfertaEstagio(ofertaid);
		Aluno aluno = ad.getAluno(alunoid);
		Orientador orientador = od.getOrientador(orientadorid);
		
		if (!oferta.getCandidatos().contains(aluno) || oferta.getNumVagas()==0)
			throw new Exception("Vagas já foram preenchidas pelos candidatos");
		
		oferta.setNumVagas(oferta.getNumVagas());
		Estagio estagio = new Estagio(oferta,orientador,aluno);
		
		ofd.editarOfertaEstagio(oferta);
		cadastrarEstagio(estagio);
		
	}

}
