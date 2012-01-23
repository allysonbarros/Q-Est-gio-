package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.negocio.Aluno;
import br.edu.ifrn.negocio.Pessoa;

@Remote
public interface PessoaBeanRemote {
	
	public void cadastrarPessoa(Aluno p);
	public void editarPessoa(Pessoa p);
	public void deletarPessoa(Pessoa p);
	public Pessoa getPessoa(Long id);
	public List<Pessoa> getTodasPessoas();
	
	
}


