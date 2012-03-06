package br.edu.ifrn.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class OrientacaoBean
 */
@Stateless
@LocalBean
public class OrientacaoBean implements OrientacaoBeanRemote {

    /**
     * Default constructor. 
     */
    public OrientacaoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void efetivarOrientacao(long idEstagio, long idOrientador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mudarOrientador(long idOrientador) {
		// TODO Auto-generated method stub
		
	}

}
