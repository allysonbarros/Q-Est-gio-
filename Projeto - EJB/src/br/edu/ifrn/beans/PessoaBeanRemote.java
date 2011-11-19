package br.edu.ifrn.beans;
import javax.ejb.Remote;

import br.edu.ifrn.negocio.Pessoa;

@Remote
public interface PessoaBeanRemote {
	public void cadastrarPessoa(Pessoa p);
}
