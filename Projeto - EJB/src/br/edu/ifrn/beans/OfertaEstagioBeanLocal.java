package br.edu.ifrn.beans;
import java.util.List;
import javax.ejb.Local;
import br.edu.ifrn.negocio.OfertaEstagio;

@Local
public interface OfertaEstagioBeanLocal {
	public void cadastrarOfertaEstagio(OfertaEstagio e);
	public void editarOfertaEstagio(OfertaEstagio e);
	public void deletarOfertaEstagio(OfertaEstagio e);
	public OfertaEstagio getOfertaEstagio(Long id);
	public List<OfertaEstagio> getTodasOfertaEstagios();
	public void removerCandidato(long idOferta , long idAluno);
	public void inserirCandidato(long idOferta, long idAluno);;
}
