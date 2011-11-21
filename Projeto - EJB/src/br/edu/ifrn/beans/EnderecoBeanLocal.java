package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Local;

import br.edu.ifrn.negocio.Endereco;

@Local
public interface EnderecoBeanLocal {
	public Endereco cadastrarEndereco(Endereco e);
	public void editarEndereco(Endereco e);
	public void deletarEndereco(Endereco e);
	public Endereco getEndereco(Long id);
	public List<Endereco> getTodosEnderecos();
}
