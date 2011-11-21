package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.negocio.Endereco;

@Remote
public interface EnderecoBeanRemote {
	public Endereco cadastrarEndereco(Endereco e);
	public void editarEndereco(Endereco e);
	public void deletarEndereco(Endereco e);
	public Endereco getEndereco(Long id);
	public List<Endereco> getTodosEnderecos();
}
