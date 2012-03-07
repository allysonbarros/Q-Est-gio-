package br.edu.ifrn.beans;
import javax.ejb.Remote;

import br.edu.ifrn.negocio.FichaVisita;

@Remote
public interface FichaVisitaBeanRemote {
	
	public void preencherFichaVisita(FichaVisita ficha);
	

}
