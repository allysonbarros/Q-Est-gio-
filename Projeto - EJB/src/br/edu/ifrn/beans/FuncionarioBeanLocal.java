package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Local;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Funcionario;

@Local
public interface FuncionarioBeanLocal {
	public void cadastrarFuncionario(Funcionario p) throws DatabaseException;
	public void editarFuncionario(Funcionario p) throws DatabaseException;
	public void deletarFuncionario(Funcionario p) throws DatabaseException;
	public Funcionario getFuncionario(Long id) throws DatabaseException;
	public List<Funcionario> getTodosFuncionarios() throws DatabaseException;
	
}
