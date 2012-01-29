package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.EmpresaBeanRemote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Empresa;

public class EmpresaDelegate {
	
	ServiceLocator locator;
	EmpresaBeanRemote bean;
	
	public EmpresaDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getEmpresaBean();
	}
	
	public void cadastrarEmpresa(Empresa e) throws DatabaseException {
		bean.cadastrarEmpresa(e);
	}

	public void editarEmpresa(Empresa e) throws DatabaseException {
		bean.editarEmpresa(e);
	}

	public void deletarEmpresa(Empresa e) throws DatabaseException {
		bean.deletarEmpresa(e);
	}

	public Empresa getEmpresa(Long id) throws DatabaseException {
		return bean.getEmpresa(id);
	}

	public List<Empresa> getTodasEmpresas() throws DatabaseException {
		return bean.getTodasEmpresas();
	}

}
