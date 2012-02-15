package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.DiretoriaBeanRemote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Diretoria;

public class DiretoriaDelegate {

	ServiceLocator locator;
	DiretoriaBeanRemote bean;

	public DiretoriaDelegate() throws Exception {
		locator = ServiceLocator.getInstace();
		bean = locator.getDiretoriaBean();
	}

	public void cadastrarDiretoria(Diretoria o) throws DatabaseException {
		bean.cadastrarDiretoria(o);
	}

	public void editarDiretoria(Diretoria o) throws DatabaseException {
		bean.editarDiretoria(o);
	}

	public void deletarDiretoria(Diretoria o) throws DatabaseException {
		bean.deletarDiretoria(o);
	}

	public Diretoria getDiretoria(long id) throws DatabaseException {
		return bean.getDiretoria(id);
	}

	public List<Diretoria> getTodasDiretoria() throws DatabaseException {
		return bean.getTodasDiretorias();
	}
	
//	public List<Diretoria> getTodasOfertasDiretoria() throws DatabaseException {
//		return bean.getTodasDiretorias();
//	}

}
