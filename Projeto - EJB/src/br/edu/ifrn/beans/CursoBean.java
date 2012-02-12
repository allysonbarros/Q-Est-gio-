package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Curso;

/**
 * Session Bean implementation class CursoBean
 */
@Stateless
public class CursoBean implements CursoBeanRemote {

    /**
     * Default constructor. 
     */
	DAO dao;
    public CursoBean() {
        // TODO Auto-generated constructor stub
    	dao = new DAO();
    }
	public void cadastrarCurso(Curso p) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public void editarCurso(Curso p) throws DatabaseException{
		// TODO Auto-generated method stub
		dao.update(p);
	}

	public void deletarCurso(Curso p) throws DatabaseException{
		dao.delete(p);
	}

	@Override
	public Curso getCurso(Long id) throws DatabaseException{
		// TODO Auto-generated method stub
		return dao.findById(Curso.class, id);
	}

	@Override
	public List<Curso> getTodosCursos() throws DatabaseException{
		// TODO Auto-generated method stub
		return dao.findAll(Curso.class);
	}

}
