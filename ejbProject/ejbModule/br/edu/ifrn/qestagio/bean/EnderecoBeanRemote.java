package br.edu.ifrn.qestagio.bean;
import javax.ejb.Remote;

import br.edu.ifrn.qestagio.modelo.Endereco;

@Remote
public interface EnderecoBeanRemote {
	
	public void cadastrarEndereco(Endereco endereco);

}
