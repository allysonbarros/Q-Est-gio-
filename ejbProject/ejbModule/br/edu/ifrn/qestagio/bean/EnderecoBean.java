package br.edu.ifrn.qestagio.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.edu.ifrn.qestagio.dao.Dao;
import br.edu.ifrn.qestagio.modelo.Endereco;

/**
 * Session Bean implementation class EnderecoBean
 */
@Stateless
@LocalBean
public class EnderecoBean implements EnderecoBeanRemote {

	Dao dao = new Dao();
    /**
     * Default constructor. 
     */
    public EnderecoBean() {
        // TODO Auto-generated constructor stub
    	
    }

	public void cadastrarEndereco(Endereco endereco) {
		dao.inserirEndereco(endereco);
	}

}
