package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Funcionario;

/**
 * Session Bean implementation class FuncionarioBean
 */
@Stateless
public class FuncionarioBean implements FuncionarioBeanRemote, FuncionarioBeanLocal {

    /**
     * Default constructor. 
     */
	DAO dao;
    public FuncionarioBean() {
        // TODO Auto-generated constructor stub
    	dao = new DAO();
    }
	public void cadastrarFuncionario(Funcionario p) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public void editarFuncionario(Funcionario p) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.update(p);
	}

	public void deletarFuncionario(Funcionario p) throws DatabaseException{
		dao.delete(p);
	}

	@Override
	public Funcionario getFuncionario(Long id) throws DatabaseException{
		// TODO Auto-generated method stub
		return dao.findById(Funcionario.class, id);
	}

	@Override
	public List<Funcionario> getTodosFuncionarios() throws DatabaseException{
		// TODO Auto-generated method stub
		return dao.findAll(Funcionario.class);
	}

}
