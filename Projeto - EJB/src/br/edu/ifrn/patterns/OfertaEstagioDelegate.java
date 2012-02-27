package br.edu.ifrn.patterns;

import java.util.List;
import br.edu.ifrn.beans.OfertaEstagioBeanRemote;
import br.edu.ifrn.beans.AlunoBeanRemote;
import br.edu.ifrn.beans.UsuarioBeanRemote;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.OfertaEstagio;


public class OfertaEstagioDelegate {
	
	ServiceLocator locator;
	OfertaEstagioBeanRemote bean;
	AlunoBeanRemote beanPessoa;
	UsuarioBeanRemote beanUsuario;
	
	public OfertaEstagioDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getOfertaEstagioBean();
		beanPessoa = locator.getPessoaBean();
		beanUsuario = locator.getUsuarioBean();
	}
	
	public void cadastrarOfertaEstagio(OfertaEstagio o) throws DatabaseException{
		bean.cadastrarOfertaEstagio(o);
	}

	public void editarOfertaEstagio(OfertaEstagio o) throws DatabaseException{
		bean.editarOfertaEstagio(o);
	}
	
	public void deletarOfertaEstagio(OfertaEstagio o) throws DatabaseException{
		bean.deletarOfertaEstagio(o);
	}
	
	public void inserirCandidato(long idOferta, long idAluno) throws DatabaseException{
		bean.inserirCandidato(idOferta, idAluno);
	}
	
	public void removerCandidato(long idOferta, long idAluno) throws DatabaseException{
		bean.removerCandidato(idOferta, idAluno);
}
	
	public OfertaEstagio getOfertaEstagio(long id) throws DatabaseException{
		return bean.getOfertaEstagio(id);
	}
	
	public List<OfertaEstagio> getTodasOfertasEstagio() throws DatabaseException{
		return bean.getTodasOfertaEstagios();
	}
	
	public List<OfertaEstagio> getTodasOfertasEstagioByDiretoria(String sigla) throws DatabaseException{
		return bean.getTodasOfertaEstagiosByDiretoria(sigla);
	}
}
