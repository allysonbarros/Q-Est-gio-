package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.EmpresaBeanRemote;
import br.edu.ifrn.beans.PessoaBeanRemote;
import br.edu.ifrn.negocio.Empresa;
import br.edu.ifrn.negocio.Pessoa;

public class EmpresaDelegate {
	
	ServiceLocator locator;
	EmpresaBeanRemote bean;
	
	public EmpresaDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getEmpresaBean();
	}
	
	public void cadastrarEmpresa(Empresa e) {
		bean.cadastrarEmpresa(e);
	}

	public void editarPessoa(Empresa e) {
		bean.editarEmpresa(e);
	}

	public void deletarPessoa(Empresa e) {
		bean.deletarEmpresa(e);
	}

	public Empresa getPessoa(Long id) {
		return bean.getEmpresa(id);
	}

	public List<Empresa> getTodasPessoas() {
		return bean.getTodasEmpresas();
	}

}
