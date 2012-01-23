package br.edu.ifrn.beans;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Pessoa;
/**
 * Session Bean implementation class PessoaBean
 */
@Stateless
@LocalBean
public class PessoaBean implements PessoaBeanRemote {
    /**
     * Default constructor. 
     */
	DAO dao;
    public PessoaBean() {
        // TODO Auto-generated constructor stub
    	dao = new DAO();
    }

	public void cadastrarPessoa(Pessoa p) {
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public void editarPessoa(Pessoa p) {
		// TODO Auto-generated method stub
		dao.update(p);
	}

	public void deletarPessoa(Pessoa p) {
		dao.delete(p);
	}

	@Override
	public Pessoa getPessoa(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(Pessoa.class, id);
	}

	@Override
	public List<Pessoa> getTodasPessoas() {
		// TODO Auto-generated method stub
		return dao.findAll(Pessoa.class);
	}

}
