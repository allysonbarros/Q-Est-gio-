package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.LocalBean;

import br.edu.ifrn.negocio.Estagio;
import  br.edu.ifrn.negocio.Orientacao;
import br.edu.ifrn.negocio.Orientador;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;

/**
 * Session Bean implementation class OrientacaoBean
 */
@Stateless
@LocalBean
public class OrientacaoBean implements OrientacaoBeanRemote {

	private DAO dao;
	private Orientacao orientacao;
	
	
    public OrientacaoBean() {
        dao = new DAO();
        orientacao =  new Orientacao();
    }

	@Override
	public void efetivarOrientacao(long idEstagio, long idOrientador) throws DatabaseException {
		Orientador orientador = dao.findById(Orientador.class, idOrientador);
		Estagio estagio = dao.findById(Estagio.class, idEstagio);
		orientacao.setEstagio(estagio);
		orientacao.setOrientador( orientador);
		dao.save(orientacao);
	}

	@Override
	public void mudarOrientador(long idOrientador) throws DatabaseException {
		List<Orientacao> lista = getTodasOrientacoes();
		for(Orientacao o : lista){
			if(o.getOrientador().getId()==idOrientador){
				Orientacao orientacao = getOrientacao(idOrientador);
				dao.update(orientacao);
			}
		}
	}	
	@Override
	public List<Orientacao> getTodasOrientacoes() throws DatabaseException {
		return dao.findAll(Orientacao.class);
	}

	@Override
	public Orientacao getOrientacao(long idOrientacao) throws DatabaseException {
		return dao.findById(Orientacao.class, idOrientacao);
	}

	@Override
	public void removerOrientacao(Orientacao orientacao)
			throws DatabaseException {
		dao.delete(orientacao);
		
	}

}
