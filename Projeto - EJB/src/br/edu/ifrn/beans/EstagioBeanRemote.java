package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Estagio;

@Remote
public interface EstagioBeanRemote {
	public void cadastrarEstagio(Estagio e) throws DatabaseException;
	public void editarEstagio(Estagio e) throws DatabaseException;
	public void deletarEstagio(Estagio e) throws DatabaseException;
	public Estagio getEstagio(Long id) throws DatabaseException;
	public List<Estagio> getTodosEstagios() throws DatabaseException;
	public void registrarEstagio(long alunoid, long orientadorid, long ofertaid)
			throws Exception;
}
