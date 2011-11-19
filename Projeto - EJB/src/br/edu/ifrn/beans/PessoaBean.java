package br.edu.ifrn.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.edu.ifrn.negocio.Pessoa;

/**
 * Session Bean implementation class PessoaBean
 */
@Stateless
@LocalBean
public class PessoaBean implements PessoaBeanRemote, PessoaBeanLocal {

    /**
     * Default constructor. 
     */
    public PessoaBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void cadastrarPessoa(Pessoa p) {
		// TODO Auto-generated method stub
		
	}

}
