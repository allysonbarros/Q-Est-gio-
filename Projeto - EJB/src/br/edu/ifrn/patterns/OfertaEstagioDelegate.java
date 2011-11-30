package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.OfertaEstagioBeanRemote;
import br.edu.ifrn.negocio.OfertaEstagio;

public class OfertaEstagioDelegate {
	
	ServiceLocator locator;
	OfertaEstagioBeanRemote bean;
	
	public OfertaEstagioDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getOfertaEstagioBean();
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
	
	public OfertaEstagio getOfertaEstagio(long id){
		return bean.getOfertaEstagio(id);
	}
	
	public List<OfertaEstagio> getTodasOfertasEstagio(){
		return bean.getTodasOfertaEstagios();
	}
	
}
