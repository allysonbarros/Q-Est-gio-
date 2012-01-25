package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Funcionario;

/**
 * Session Bean implementation class FuncionarioBean
 */
@Stateless
public class FuncionarioBean implements FuncionarioBeanRemote {

    /**
     * Default constructor. 
     */
	DAO dao;
    public FuncionarioBean() {
        // TODO Auto-generated constructor stub
    	dao = new DAO();
    }
	public void cadastrarFuncionario(Funcionario p) {
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public void editarFuncionario(Funcionario p) {
		// TODO Auto-generated method stub
		dao.update(p);
	}

	public void deletarFuncionario(Funcionario p) {
		dao.delete(p);
	}

	@Override
	public Funcionario getFuncionario(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(Funcionario.class, id);
	}

	@Override
	public List<Funcionario> getTodosFuncionarios() {
		// TODO Auto-generated method stub
		return dao.findAll(Funcionario.class);
	}

}
