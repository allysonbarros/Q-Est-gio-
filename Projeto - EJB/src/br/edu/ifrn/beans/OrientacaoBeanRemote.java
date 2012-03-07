package br.edu.ifrn.beans;
import java.util.List;
import javax.ejb.Remote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Orientacao;

@Remote
public interface OrientacaoBeanRemote {
	
	
	public void efetivarOrientacao(long idEstagio, long idOrientador) throws DatabaseException;
	public void mudarOrientador(long idOrientador) throws DatabaseException;
	public void removerOrientacao(Orientacao orientacao)throws DatabaseException;
	public List<Orientacao> getTodasOrientacoes() throws DatabaseException;
	public Orientacao getOrientacao(long idOrientacao) throws DatabaseException;

}
