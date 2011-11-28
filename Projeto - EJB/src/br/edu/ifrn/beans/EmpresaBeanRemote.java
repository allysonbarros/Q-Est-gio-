package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.negocio.Empresa;

@Remote
public interface EmpresaBeanRemote {
	public void cadastrarEmpresa(Empresa e);
	public void editarEmpresa(Empresa e);
	public void deletarEmpresa(Empresa e);
	public Empresa getEmpresa(Long id);
	public List<Empresa> getTodasEmpresas();
}
