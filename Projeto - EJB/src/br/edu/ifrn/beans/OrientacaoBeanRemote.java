package br.edu.ifrn.beans;
import javax.ejb.Remote;

@Remote
public interface OrientacaoBeanRemote {
	
	public void efetivarOrientacao(long idEstagio, long idOrientador);
	public void mudarOrientador(long idOrientador);

}
