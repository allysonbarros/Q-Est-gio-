package br.edu.ifrn.beans;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.modelo.DAO;
import br.edu.ifrn.negocio.FichaVisita;
import br.edu.ifrn.negocio.Orientacao;
import br.edu.ifrn.negocio.Orientador;

/**
 * Session Bean implementation class FichaVisitaBean
 */
@Stateless
public class FichaVisitaBean implements FichaVisitaBeanRemote {

    /**
     * Default constructor. 
     */
	DAO dao;
	
    public FichaVisitaBean() {
    	dao = new DAO();
    }

	@Override
	public void preencherFichaVisita(FichaVisita ficha) {
		// TODO Auto-generated method stub
		
	}

	public List<Orientacao> listarOrientados() throws DatabaseException {
		return dao.findAll(Orientacao.class);
	}

}
