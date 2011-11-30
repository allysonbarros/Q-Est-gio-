package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Local;

import br.edu.ifrn.negocio.Estagio;

@Local
public interface EstagioBeanLocal {
	public void cadastrarEstagio(Estagio e);
	public void editarEstagio(Estagio e);
	public void deletarEstagio(Estagio e);
	public Estagio getEstagio(Long id);
	public List<Estagio> getTodosEstagios();
}
