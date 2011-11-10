package br.edu.ifrn.beans;
import javax.ejb.Local;

import br.edu.ifrn.negocio.Endereco;

@Local
public interface EnderecoBeanLocal {
	public void cadastrarEndereco(Endereco e);
}
