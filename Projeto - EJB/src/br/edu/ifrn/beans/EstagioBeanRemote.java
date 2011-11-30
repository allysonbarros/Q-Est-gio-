package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.negocio.Estagio;

@Remote
public interface EstagioBeanRemote {
	public void cadastrarEstagio(Estagio e);
	public void editarEstagio(Estagio e);
	public void deletarEstagio(Estagio e);
	public Estagio getEstagio(Long id);
	public List<Estagio> getTodosEstagios();
}
