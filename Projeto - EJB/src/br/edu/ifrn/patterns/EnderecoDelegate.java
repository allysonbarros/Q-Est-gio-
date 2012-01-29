package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.EnderecoBeanRemote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Endereco;


public class EnderecoDelegate {

	ServiceLocator locator;
	EnderecoBeanRemote bean;
	
	public EnderecoDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getEnderecoBean();
	} 

	public Endereco cadastrarEndereco(Endereco e) throws DatabaseException {
		return bean.cadastrarEndereco(e);
	}

	public void editarEndereco(Endereco e) throws DatabaseException {
		bean.editarEndereco(e);
	}

	public void deletarEndereco(Endereco e) throws DatabaseException {
		bean.deletarEndereco(e);
	}

	public Endereco getEndereco(Long id) throws DatabaseException {
		return bean.getEndereco(id);
	}

	public List<Endereco> getTodosEnderecos() throws DatabaseException {
		return bean.getTodosEnderecos();
	}
}
