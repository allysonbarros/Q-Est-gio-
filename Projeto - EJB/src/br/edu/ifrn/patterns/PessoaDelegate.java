package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.PessoaBeanRemote;
import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.Pessoa;

public class PessoaDelegate {
	
	ServiceLocator locator;
	PessoaBeanRemote bean;
	
	public PessoaDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getPessoaBean();
	}
	
	public void cadastrarPessoa(Pessoa p) {
		bean.cadastrarPessoa(p);
	}

	public void editarPessoa(Pessoa p) {
		bean.editarPessoa(p);
	}

	public void deletarPessoa(Pessoa p) {
		bean.deletarPessoa(p);
	}

	public Pessoa getPessoa(Long id) {
		return bean.getPessoa(id);
	}

	public List<Pessoa> getTodasPessoas() {
		return bean.getTodasPessoas();
	}

}
