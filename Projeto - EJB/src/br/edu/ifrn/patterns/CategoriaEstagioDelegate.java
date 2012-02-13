package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.CategoriaEstagioBeanRemote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.CategoriaEstagio;

public class CategoriaEstagioDelegate {

	ServiceLocator locator;
	CategoriaEstagioBeanRemote bean;

	public CategoriaEstagioDelegate() throws Exception {
		locator = ServiceLocator.getInstace();
		bean = locator.getCategoriaEstagioBean();
	}

	public void cadastrarCategoriaEstagio(CategoriaEstagio o) throws DatabaseException {
		bean.cadastrarCategoriaEstagio(o);
	}

	public void editarCategoriaEstagio(CategoriaEstagio o) throws DatabaseException {
		bean.editarCategoriaEstagio(o);
	}

	public void deletarCategoriaEstagio(CategoriaEstagio o) throws DatabaseException {
		bean.deletarCategoriaEstagio(o);
	}

	public CategoriaEstagio getCategoriaEstagio(long id) throws DatabaseException {
		return bean.getCategoriaEstagio(id);
	}

	public List<CategoriaEstagio> getTodasOfertasCategoriaEstagio() throws DatabaseException {
		return bean.getTodasCategoriaEstagios();
	}

}
