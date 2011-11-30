package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.negocio.OfertaEstagio;
import br.edu.ifrn.negocio.Pessoa;

@Remote
public interface OfertaEstagioBeanRemote {
	public void cadastrarOfertaEstagio(OfertaEstagio e);
	public void editarOfertaEstagio(OfertaEstagio e);
	public void deletarOfertaEstagio(OfertaEstagio e);
	public OfertaEstagio getOfertaEstagio(Long id);
	public List<OfertaEstagio> getTodasOfertaEstagios();
	public void inserirCandidato(OfertaEstagio e, Pessoa p);
	public void removerCandidato(OfertaEstagio e, Pessoa p);
}
