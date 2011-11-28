package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Local;

import br.edu.ifrn.negocio.Empresa;

@Local
public interface EmpresaBeanLocal {
	public void cadastrarEmpresa(Empresa e);
	public void editarEmpresa(Empresa e);
	public void deletarEmpresa(Empresa e);
	public Empresa getEmpresa(Long id);
	public List<Empresa> getTodasEmpresas();
}
