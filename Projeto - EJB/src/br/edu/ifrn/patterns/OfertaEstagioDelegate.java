package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.OfertaEstagioBeanRemote;
import br.edu.ifrn.beans.PessoaBeanRemote;
import br.edu.ifrn.negocio.OfertaEstagio;
import br.edu.ifrn.negocio.Pessoa;

public class OfertaEstagioDelegate {
	
	ServiceLocator locator;
	OfertaEstagioBeanRemote bean;
	PessoaBeanRemote beanPessoa;
	
	public OfertaEstagioDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getOfertaEstagioBean();
		beanPessoa = locator.getPessoaBean();
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
	
	public void inserirCandidato(long idOferta, long idPessoa){
		OfertaEstagio oferta = bean.getOfertaEstagio(idOferta);
		Pessoa pessoa = beanPessoa.getPessoa(idPessoa);
		
		oferta.getCandidatos().add(pessoa);
		editarOfertaEstagio(oferta);
	}
	
	public void removerCandidato(long idOferta, long idPessoa){
		OfertaEstagio oferta = bean.getOfertaEstagio(idOferta);
		Pessoa pessoa = beanPessoa.getPessoa(idPessoa);
		
		oferta.getCandidatos().remove(pessoa);
		editarOfertaEstagio(oferta);
	}
	
	public OfertaEstagio getOfertaEstagio(long id){
		return bean.getOfertaEstagio(id);
	}
	
	public List<OfertaEstagio> getTodasOfertasEstagio(){
		return bean.getTodasOfertaEstagios();
	}
	
}
