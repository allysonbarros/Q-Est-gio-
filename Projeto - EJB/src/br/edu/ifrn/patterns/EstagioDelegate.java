package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.EstagioBeanRemote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Estagio;

public class EstagioDelegate {

	ServiceLocator locator;
	EstagioBeanRemote bean;

	public EstagioDelegate() throws Exception {
		locator = ServiceLocator.getInstace();
		bean = locator.getEstagioBean();
	}

	public void cadastrarEstagio(Estagio o) throws DatabaseException {
		bean.cadastrarEstagio(o);
	}

	public void registrarEstagio(Long alunoid, Long orientadorid, Long ofertaid) throws Exception {
		bean.registrarEstagio(alunoid,orientadorid,ofertaid);
	}

	public void editarEstagio(Estagio o) throws DatabaseException {
		bean.editarEstagio(o);
	}

	public void deletarEstagio(Estagio o) throws DatabaseException {
		bean.deletarEstagio(o);
	}

	public Estagio getEstagio(long id) throws DatabaseException {
		return bean.getEstagio(id);
	}

	public List<Estagio> getTodasOfertasEstagio() throws DatabaseException {
		return bean.getTodosEstagios();
	}

}
