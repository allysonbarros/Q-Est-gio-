package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.CursoBeanRemote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Curso;

public class CursoDelegate {

	ServiceLocator locator;
	CursoBeanRemote bean;

	public CursoDelegate() throws Exception {
		locator = ServiceLocator.getInstace();
		bean = locator.getCursoBean();
	}

	public void cadastrarCurso(Curso o) throws DatabaseException {
		bean.cadastrarCurso(o);
	}

	public void editarCurso(Curso o) throws DatabaseException {
		bean.editarCurso(o);
	}

	public void deletarCurso(Curso o) throws DatabaseException {
		bean.deletarCurso(o);
	}

	public Curso getCurso(long id) throws DatabaseException {
		return bean.getCurso(id);
	}

	public List<Curso> getTodasOfertasCurso() throws DatabaseException {
		return bean.getTodosCursos();
	}

}
