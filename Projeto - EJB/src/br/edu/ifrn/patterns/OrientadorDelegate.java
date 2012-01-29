package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.OrientadorBeanRemote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Orientador;

public class OrientadorDelegate {
	
	ServiceLocator locator;
	OrientadorBeanRemote bean;
	
	public OrientadorDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getOrientadorBean();
	}
	
	public void cadastrarOrientador(Orientador p) throws DatabaseException {
		bean.cadastrarOrientador(p);
	}

	public void editarOrientador(Orientador p) throws DatabaseException {
		bean.editarOrientador(p);
	}

	public void deletarOrientador(Orientador p) throws DatabaseException {
		bean.deletarOrientador(p);
	}

	public Orientador getOrientador(Long id) throws DatabaseException {
		return bean.getOrientador(id);
	}

	public List<Orientador> getTodosOrientadores() throws DatabaseException {
		return bean.getTodosOrientadores();
	}

}
