package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Aluno;

@Stateless
public class AlunoBean implements AlunoBeanRemote {
    /**
     * Default constructor. 
     */
	DAO dao;
    public AlunoBean() {
        // TODO Auto-generated constructor stub
    	dao = new DAO();
    }

	public void cadastrarAluno(Aluno p) throws DatabaseException {
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public void editarAluno(Aluno p) throws DatabaseException {
		// TODO Auto-generated method stub
		dao.update(p);
	}

	public void deletarAluno(Aluno p) throws DatabaseException {
		dao.delete(p);
	}

	@Override
	public Aluno getAluno(Long id) throws DatabaseException {
		// TODO Auto-generated method stub
		return dao.findById(Aluno.class, id);
	}

	@Override
	public List<Aluno> getTodosAlunos() throws DatabaseException {
		// TODO Auto-generated method stub
		return dao.findAll(Aluno.class);
	}

}
