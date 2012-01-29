package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Orientador;

@Remote
public interface OrientadorBeanRemote {
	public void cadastrarOrientador(Orientador p) throws DatabaseException;
	public void editarOrientador(Orientador p) throws DatabaseException;
	public void deletarOrientador(Orientador p) throws DatabaseException;
	public Orientador getOrientador(Long id) throws DatabaseException;
	public List<Orientador> getTodosOrientadores() throws DatabaseException;
}
