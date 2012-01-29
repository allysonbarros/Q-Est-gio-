package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.Empresa;

/**
 * Session Bean implementation class EmpresaBean
 */
@Stateless
public class EmpresaBean implements EmpresaBeanRemote, EmpresaBeanLocal {

    /**
     * Default constructor. 
     */
	DAO dao;
    public EmpresaBean() {
        dao = new DAO();
    }

	@Override
	public void cadastrarEmpresa(Empresa e) {
		dao.save(e);
	}

	@Override
	public void editarEmpresa(Empresa e) {
		dao.update(e);
	}

	@Override
	public void deletarEmpresa(Empresa e) {
		dao.delete(e);
	}

	@Override
	public Empresa getEmpresa(Long id) {
		return dao.findById(Empresa.class, id);
	}

	@Override
	public List<Empresa> getTodasEmpresas() {
		return dao.findAll(Empresa.class);
	}

}
