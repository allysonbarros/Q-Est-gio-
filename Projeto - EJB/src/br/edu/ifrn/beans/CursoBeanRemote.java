package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Curso;

@Remote
public interface CursoBeanRemote {
	public void cadastrarCurso(Curso p) throws DatabaseException;
	public void editarCurso(Curso p) throws DatabaseException;
	public void deletarCurso(Curso p) throws DatabaseException;
	public Curso getCurso(Long id) throws DatabaseException;
	public List<Curso> getTodosCursos() throws DatabaseException;
	
	
}
