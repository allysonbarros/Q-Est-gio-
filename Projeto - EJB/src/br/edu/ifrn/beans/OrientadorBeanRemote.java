package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.negocio.Orientador;

@Remote
public interface OrientadorBeanRemote {
	public void cadastrarOrientador(Orientador p);
	public void editarOrientador(Orientador p);
	public void deletarOrientador(Orientador p);
	public Orientador getOrientador(Long id);
	public List<Orientador> getTodosOrientadores();
}
