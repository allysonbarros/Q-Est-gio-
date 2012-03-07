package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Orientacao;

import br.edu.ifrn.negocio.FichaVisita;

@Remote
public interface FichaVisitaBeanRemote {
	
	public void preencherFichaVisita(FichaVisita ficha);
	public List<Orientacao> listarOrientados() throws DatabaseException;
	

}
