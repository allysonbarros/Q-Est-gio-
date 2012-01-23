package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.FuncionarioBeanRemote;
import br.edu.ifrn.negocio.Funcionario;

public class OrientadorDelegate {
	
	ServiceLocator locator;
	FuncionarioBeanRemote bean;
	
	public OrientadorDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getFuncionarioBean();
	}
	
	public void cadastrarFuncionario(Funcionario p) {
		bean.cadastrarFuncionario(p);
	}

	public void editarFuncionario(Funcionario p) {
		bean.editarFuncionario(p);
	}

	public void deletarFuncionario(Funcionario p) {
		bean.deletarFuncionario(p);
	}

	public Funcionario getFuncionario(Long id) {
		return bean.getFuncionario(id);
	}

	public List<Funcionario> getTodasFuncionarios() {
		return bean.getTodosFuncionarios();
	}

}
