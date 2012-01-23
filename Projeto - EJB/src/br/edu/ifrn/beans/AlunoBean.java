package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Aluno;
/**
 * Session Bean implementation class AlunoBean
 */
@Stateless
@LocalBean
public class AlunoBean implements AlunoBeanRemote {
    /**
     * Default constructor. 
     */
	DAO dao;
    public AlunoBean() {
        // TODO Auto-generated constructor stub
    	dao = new DAO();
    }

	public void cadastrarAluno(Aluno p) {
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public void editarAluno(Aluno p) {
		// TODO Auto-generated method stub
		dao.update(p);
	}

	public void deletarAluno(Aluno p) {
		dao.delete(p);
	}

	@Override
	public Aluno getAluno(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(Aluno.class, id);
	}

	@Override
	public List<Aluno> getTodosAlunos() {
		// TODO Auto-generated method stub
		return dao.findAll(Aluno.class);
	}

}
