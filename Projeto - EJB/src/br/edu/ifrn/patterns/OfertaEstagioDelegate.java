package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.OfertaEstagioBeanRemote;
import br.edu.ifrn.beans.AlunoBeanRemote;
import br.edu.ifrn.beans.UsuarioBeanRemote;
import br.edu.ifrn.negocio.OfertaEstagio;
import br.edu.ifrn.negocio.Pessoa;
import br.edu.ifrn.negocio.Usuario;

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
	
	public void inserirCandidato(long idOferta, long idPessoa){
		System.out.println(idOferta+"  "+idPessoa);
		
		OfertaEstagio oferta = bean.getOfertaEstagio(idOferta);
		Usuario usuario = beanUsuario.getUsuario(idPessoa);

		Pessoa pessoa = usuario.getPessoa();
		if (oferta.getCandidatos().contains(pessoa))
			return;
		oferta.getCandidatos().add(pessoa);
		System.out.println(oferta.getCandidatos().size());
		editarOfertaEstagio(oferta);
	}
	
	public void removerCandidato(long idOferta, long idPessoa){
		OfertaEstagio oferta = bean.getOfertaEstagio(idOferta);
		Usuario usuario = beanUsuario.getUsuario(idPessoa);
		List<Pessoa> candidatos = oferta.getCandidatos();
		Pessoa pessoa = usuario.getPessoa();
		for (Pessoa pessoalista : candidatos) {
			
			if (pessoalista.getId().equals(pessoa.getId())){
				candidatos.remove(pessoalista);
				break;
			}
		}
		editarOfertaEstagio(oferta);
	}
	
	public OfertaEstagio getOfertaEstagio(long id){
		return bean.getOfertaEstagio(id);
	}
	
	public List<OfertaEstagio> getTodasOfertasEstagio(){
		return bean.getTodasOfertaEstagios();
	}
	
}
