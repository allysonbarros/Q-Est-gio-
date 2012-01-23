package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Endereco;

/**
 * Session Bean implementation class EnderecoBean
 */
@Stateless
public class EnderecoBean implements EnderecoBeanRemote {
	DAO dao;
	
    public EnderecoBean() {
		dao = new DAO();
    }

	@Override
	public Endereco cadastrarEndereco(Endereco e) {
		dao.save(e);
		return e;
	}

	@Override
	public void editarEndereco(Endereco e) {
		dao.update(e);
	}

	@Override
	public void deletarEndereco(Endereco e) {
		dao.delete(e);
	}

	@Override
	public Endereco getEndereco(Long id) {
		return dao.findById(Endereco.class, id);
	}

	@Override
	public List<Endereco> getTodosEnderecos() {
		return dao.findAll(Endereco.class);
	}
}
