package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.InstituicaoEnsinoBeanRemote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.InstituicaoEnsino;

public class InstituicaoEnsinoDelegate {

	ServiceLocator locator;
	InstituicaoEnsinoBeanRemote bean;

	public InstituicaoEnsinoDelegate() throws Exception {
		locator = ServiceLocator.getInstace();
		bean = locator.getInstituicaoEnsinoBean();
	}

	public void cadastrarInstituicaoEnsino(InstituicaoEnsino o) throws DatabaseException {
		bean.cadastrarInstituicaoEnsino(o);
	}

	public void editarInstituicaoEnsino(InstituicaoEnsino o) throws DatabaseException {
		bean.editarInstituicaoEnsino(o);
	}

	public void deletarInstituicaoEnsino(InstituicaoEnsino o) throws DatabaseException {
		bean.deletarInstituicaoEnsino(o);
	}

	public InstituicaoEnsino getInstituicaoEnsino(long id) throws DatabaseException {
		return bean.getInstituicaoEnsino(id);
	}

	public List<InstituicaoEnsino> getTodasOfertasInstituicaoEnsino() throws DatabaseException {
		return bean.getTodasInstituicoesEnsino();
	}

}
