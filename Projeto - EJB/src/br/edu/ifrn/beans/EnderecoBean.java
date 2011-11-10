package br.edu.ifrn.beans;

import javax.ejb.Stateless;

import br.edu.ifrn.modelo.EnderecoDAO;
import br.edu.ifrn.negocio.Endereco;

/**
 * Session Bean implementation class EnderecoBean
 */
@Stateless
public class EnderecoBean implements EnderecoBeanLocal {
	
    public EnderecoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void cadastrarEndereco(Endereco e) {
		EnderecoDAO dao = new EnderecoDAO();
		dao.cadastrarEndereco(e);
	}
}
