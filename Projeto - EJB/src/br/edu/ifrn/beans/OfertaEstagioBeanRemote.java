package br.edu.ifrn.beans;
import java.util.List;
import javax.ejb.Remote;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.OfertaEstagio;


@Remote
public interface OfertaEstagioBeanRemote {
	public void cadastrarOfertaEstagio(OfertaEstagio e) throws DatabaseException;
	public void editarOfertaEstagio(OfertaEstagio e) throws DatabaseException;
	public void deletarOfertaEstagio(OfertaEstagio e) throws DatabaseException;
	public OfertaEstagio getOfertaEstagio(Long id) throws DatabaseException;
	public List<OfertaEstagio> getTodasOfertaEstagios() throws DatabaseException;
	public List<OfertaEstagio> getTodasOfertaEstagiosByDiretoria(String sigla) throws DatabaseException;
	public void removerCandidato(long idOferta , long idAluno) throws DatabaseException;
	public void inserirCandidato(long idOferta, long idAluno) throws DatabaseException;
}
