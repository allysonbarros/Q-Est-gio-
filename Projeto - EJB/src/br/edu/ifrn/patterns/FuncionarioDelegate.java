package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.FuncionarioBeanRemote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Funcionario;

public class FuncionarioDelegate {
	
	ServiceLocator locator;
	FuncionarioBeanRemote bean;
	
	public FuncionarioDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getFuncionarioBean();
	}
	
	public void cadastrarFuncionario(Funcionario p) throws DatabaseException {
		bean.cadastrarFuncionario(p);
	}

	public void editarFuncionario(Funcionario p) throws DatabaseException {
		bean.editarFuncionario(p);
	}

	public void deletarFuncionario(Funcionario p) throws DatabaseException {
		bean.deletarFuncionario(p);
	}

	public Funcionario getFuncionario(Long id) throws DatabaseException {
		return bean.getFuncionario(id);
	}

	public List<Funcionario> getTodasFuncionarios() throws DatabaseException {
		return bean.getTodosFuncionarios();
	}

}
