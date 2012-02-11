package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Empresa;

/**
 * Session Bean implementation class EmpresaBean
 */
@Stateless
public class EmpresaBean implements EmpresaBeanRemote {

    /**
     * Default constructor. 
     */
	DAO dao;
    public EmpresaBean(){
        dao = new DAO();
    }

	@Override
	public void cadastrarEmpresa(Empresa e) throws DatabaseException{
		dao.save(e);
	}

	@Override
	public void editarEmpresa(Empresa e) throws DatabaseException{
		dao.update(e);
	}

	@Override
	public void deletarEmpresa(Empresa e) throws DatabaseException{
		dao.delete(e);
	}

	@Override
	public Empresa getEmpresa(Long id) throws DatabaseException{
		return dao.findById(Empresa.class, id);
	}

	@Override
	public List<Empresa> getTodasEmpresas() throws DatabaseException{
		return dao.findAll(Empresa.class);
	}

}
