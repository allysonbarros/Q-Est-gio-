package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Local;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Estagio;

@Local
public interface EstagioBeanLocal {
	public void cadastrarEstagio(Estagio e) throws DatabaseException;
	public void editarEstagio(Estagio e) throws DatabaseException;
	public void deletarEstagio(Estagio e) throws DatabaseException;
	public Estagio getEstagio(Long id) throws DatabaseException;
	public List<Estagio> getTodosEstagios() throws DatabaseException;
}
