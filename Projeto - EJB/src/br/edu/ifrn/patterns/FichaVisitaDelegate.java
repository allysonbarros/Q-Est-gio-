package br.edu.ifrn.patterns;


import br.edu.ifrn.beans.FichaVisitaBeanRemote;
import br.edu.ifrn.negocio.FichaVisita;

public class FichaVisitaDelegate {
	
	ServiceLocator locator;
	FichaVisitaBeanRemote bean;
	
	public FichaVisitaDelegate(){
		
	}
	
	public void preencherFichaVisita(FichaVisita ficha){
		bean.preencherFichaVisita(ficha);
	}

}
