package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.EstagioBeanRemote;
import br.edu.ifrn.negocio.Estagio;

public class EstagioDelegate {

	ServiceLocator locator;
	EstagioBeanRemote bean;

	public EstagioDelegate() throws Exception {
		locator = ServiceLocator.getInstace();
		bean = locator.getEstagioBean();
	}

	public void cadastrarEstagio(Estagio o) {
		bean.cadastrarEstagio(o);
	}

	public void editarEstagio(Estagio o) {
		bean.editarEstagio(o);
	}

	public void deletarEstagio(Estagio o) {
		bean.deletarEstagio(o);
	}

	public Estagio getEstagio(long id) {
		return bean.getEstagio(id);
	}

	public List<Estagio> getTodasOfertasEstagio() {
		return bean.getTodosEstagios();
	}

}
