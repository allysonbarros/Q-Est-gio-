package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.EnderecoBeanRemote;
import br.edu.ifrn.negocio.Endereco;


public class EnderecoDelegate {

	ServiceLocator locator;
	EnderecoBeanRemote bean;
	
	public EnderecoDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getEnderecoBean();
	} 

	public Endereco cadastrarEndereco(Endereco e) {
		return bean.cadastrarEndereco(e);
	}

	public void editarEndereco(Endereco e) {
		bean.editarEndereco(e);
	}

	public void deletarEndereco(Endereco e) {
		bean.deletarEndereco(e);
	}

	public Endereco getEndereco(Long id) {
		return bean.getEndereco(id);
	}

	public List<Endereco> getTodosEnderecos() {
		return bean.getTodosEnderecos();
	}
}
