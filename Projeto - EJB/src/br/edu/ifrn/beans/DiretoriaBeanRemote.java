package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Diretoria;

@Remote
public interface DiretoriaBeanRemote {
	public void cadastrarDiretoria(Diretoria p) throws DatabaseException;
	public void editarDiretoria(Diretoria p) throws DatabaseException;
	public void deletarDiretoria(Diretoria p) throws DatabaseException;
	public Diretoria getDiretoria(Long id) throws DatabaseException;
	public Diretoria getDiretoriaBySigla(String sigla) throws DatabaseException;
	public List<Diretoria> getTodasDiretorias() throws DatabaseException;
}
