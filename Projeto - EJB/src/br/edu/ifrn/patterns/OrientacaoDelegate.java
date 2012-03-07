package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.OrientacaoBeanRemote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Orientacao;

public class OrientacaoDelegate {

	ServiceLocator locator;
	OrientacaoBeanRemote bean;

	public OrientacaoDelegate() throws Exception {
		locator = ServiceLocator.getInstace();
		bean = locator.getOrientacaoBean();
	}

	public void efetivarOrientacao(long idEstagio, long idOrientador) throws DatabaseException {
		bean.efetivarOrientacao(idEstagio, idOrientador);
	}

	public Orientacao getOrientacao(long idOrientacao) throws DatabaseException {
		return bean.getOrientacao(idOrientacao);
	}

	public void removerOrientacao(Orientacao orientacao) throws DatabaseException {
		bean.removerOrientacao(orientacao);
	}
	
	public void mudarOrientador(long idOrientador) throws DatabaseException{
		bean.mudarOrientador(idOrientador);
	}

	public List<Orientacao> getTodasOrientacoes() throws DatabaseException {
		return bean.getTodasOrientacoes();
	}

}
