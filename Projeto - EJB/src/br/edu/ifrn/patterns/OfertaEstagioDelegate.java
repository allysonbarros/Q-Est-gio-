package br.edu.ifrn.patterns;

import java.util.List;
import br.edu.ifrn.beans.OfertaEstagioBeanRemote;
import br.edu.ifrn.beans.AlunoBeanRemote;
import br.edu.ifrn.beans.UsuarioBeanRemote;
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
	
	public void cadastrarOfertaEstagio(OfertaEstagio o){
		bean.cadastrarOfertaEstagio(o);
	}

	public void editarOfertaEstagio(OfertaEstagio o){
		bean.editarOfertaEstagio(o);
	}
	
	public void deletarOfertaEstagio(OfertaEstagio o){
		bean.deletarOfertaEstagio(o);
	}
	
	public void inserirCandidato(long idOferta, long idAluno){
		bean.inserirCandidato(idOferta, idAluno);
	}
	
	public void removerCandidato(long idOferta, long idAluno){
		bean.removerCandidato(idOferta, idAluno);
}
	
	public OfertaEstagio getOfertaEstagio(long id){
		return bean.getOfertaEstagio(id);
	}
	
	public List<OfertaEstagio> getTodasOfertasEstagio(){
		return bean.getTodasOfertaEstagios();
	}
	
}
