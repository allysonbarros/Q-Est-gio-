package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Empresa;

@Remote
public interface EmpresaBeanRemote {
	public void cadastrarEmpresa(Empresa e) throws DatabaseException;
	public void editarEmpresa(Empresa e) throws DatabaseException;
	public void deletarEmpresa(Empresa e) throws DatabaseException;
	public Empresa getEmpresa(Long id) throws DatabaseException;
	public List<Empresa> getTodasEmpresas() throws DatabaseException;
}
