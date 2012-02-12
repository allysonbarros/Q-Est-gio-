package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.CategoriaEstagio;

@Remote
public interface CategoriaEstagioBeanRemote {
	public void cadastrarCategoriaEstagio(CategoriaEstagio p) throws DatabaseException;
	public void editarCategoriaEstagio(CategoriaEstagio p) throws DatabaseException;
	public void deletarCategoriaEstagio(CategoriaEstagio p) throws DatabaseException;
	public CategoriaEstagio getCategoriaEstagio(Long id) throws DatabaseException;
	public List<CategoriaEstagio> getTodasCategoriaEstagios() throws DatabaseException;
	
	
}
