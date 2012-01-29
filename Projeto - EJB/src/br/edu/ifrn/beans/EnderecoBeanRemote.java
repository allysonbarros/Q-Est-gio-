package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Endereco;

@Remote
public interface EnderecoBeanRemote {
	public Endereco cadastrarEndereco(Endereco e) throws DatabaseException;
	public void editarEndereco(Endereco e) throws DatabaseException;
	public void deletarEndereco(Endereco e) throws DatabaseException;
	public Endereco getEndereco(Long id) throws DatabaseException;
	public List<Endereco> getTodosEnderecos() throws DatabaseException;
}
