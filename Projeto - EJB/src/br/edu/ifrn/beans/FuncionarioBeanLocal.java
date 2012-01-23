package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Local;

import br.edu.ifrn.negocio.Funcionario;

@Local
public interface FuncionarioBeanLocal {
	public void cadastrarFuncionario(Funcionario p);
	public void editarFuncionario(Funcionario p);
	public void deletarFuncionario(Funcionario p);
	public Funcionario getFuncionario(Long id);
	public List<Funcionario> getTodosFuncionarios();
	
}
