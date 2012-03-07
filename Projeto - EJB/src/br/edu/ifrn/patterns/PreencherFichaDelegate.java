package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.FichaVisitaBeanRemote;
import br.edu.ifrn.exceptions.ConnectionException;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Orientacao;

public class PreencherFichaDelegate {
	
	ServiceLocator locator;
	FichaVisitaBeanRemote bean;
	
	public PreencherFichaDelegate() throws ConnectionException{
		locator = ServiceLocator.getInstace();
		bean = locator.getFichaVisitaBean();
	}
	
	public List<Orientacao> listarOrientandos() throws DatabaseException{
		return bean.listarOrientados();
	}
	
	

}
