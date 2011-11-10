package br.edu.ifrn.beans;
import javax.ejb.Remote;

import br.edu.ifrn.negocio.Endereco;

@Remote
public interface EnderecoBeanRemote {
	public void cadastrarEndereco(Endereco e);
}
