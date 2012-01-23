package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Local;

import br.edu.ifrn.negocio.Orientador;

@Local
public interface OrientadorBeanLocal {
	public void cadastrarOrientador(Orientador p);
	public void editarOrientador(Orientador p);
	public void deletarOrientador(Orientador p);
	public Orientador getOrientador(Long id);
	public List<Orientador> getTodosOrientadores();
	
}
