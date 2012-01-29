package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Endereco;

/**
 * Session Bean implementation class EnderecoBean
 */
@Stateless
public class EnderecoBean implements EnderecoBeanRemote, EnderecoBeanLocal  {
	DAO dao;
	
    public EnderecoBean() {
		dao = new DAO();
    }

	@Override
	public Endereco cadastrarEndereco(Endereco e) throws DatabaseException {
		dao.save(e);
		return e;
	}

	@Override
	public void editarEndereco(Endereco e) throws DatabaseException {
		dao.update(e);
	}

	@Override
	public void deletarEndereco(Endereco e) throws DatabaseException {
		dao.delete(e);
	}

	@Override
	public Endereco getEndereco(Long id) throws DatabaseException {
		return dao.findById(Endereco.class, id);
	}

	@Override
	public List<Endereco> getTodosEnderecos() throws DatabaseException {
		return dao.findAll(Endereco.class);
	}
}
