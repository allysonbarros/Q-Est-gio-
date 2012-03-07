package br.edu.ifrn.beans;

import javax.ejb.Stateless;

import br.edu.ifrn.negocio.FichaVisita;

/**
 * Session Bean implementation class FichaVisitaBean
 */
@Stateless
public class FichaVisitaBean implements FichaVisitaBeanRemote {

    /**
     * Default constructor. 
     */
    public FichaVisitaBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void preencherFichaVisita(FichaVisita ficha) {
		// TODO Auto-generated method stub
		
	}

}
