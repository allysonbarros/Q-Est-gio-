package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.negocio.Funcionario;

@Remote
public interface FuncionarioBeanRemote {
	public void cadastrarFuncionario(Funcionario p);
	public void editarFuncionario(Funcionario p);
	public void deletarFuncionario(Funcionario p);
	public Funcionario getFuncionario(Long id);
	public List<Funcionario> getTodosFuncionarios();
	
	
}
