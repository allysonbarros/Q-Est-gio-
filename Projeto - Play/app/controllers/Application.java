package controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import helpers.SessionsHelper;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.ifrn.beans.EnderecoBeanRemote;
import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.OfertaEstagio;
import br.edu.ifrn.negocio.Pessoa;
import br.edu.ifrn.patterns.EnderecoDelegate;
import br.edu.ifrn.patterns.OfertaEstagioDelegate;
import br.edu.ifrn.patterns.ServiceLocator;
import br.edu.ifrn.patterns.UsuarioDelegate;

import play.mvc.Controller;
import play.mvc.With;

@With(SessionsHelper.class)
public class Application extends Controller {

    public static void index() {
    	render();
    }
    
    public static void informacoesEstagio() {
    	render();
    }
    
    public static void modeloDeclaracaoEstagio() {
    	render();
    }
    
    public static void legislacaoNormas() {
    	render();
    }
    
    public static void modelosFormularios() {
    	render();
    }
    
    public static void ofertaEstagio() throws Exception {
    	List<OfertaEstagio> lista = new ArrayList<OfertaEstagio>();
    	try{
	    	UsuarioDelegate ud = new UsuarioDelegate();
	    	OfertaEstagioDelegate del = new OfertaEstagioDelegate();
	    	lista = del.getTodasOfertasEstagio();
	    	List<Boolean> listaCand = new ArrayList<Boolean>();
	    	Pessoa pessoa = ud.getUsuario(Long.parseLong(session.get("usuarioAtivoID"))).getPessoa();
	    	
	    	for (OfertaEstagio oe : lista) {
	    		boolean esta = false;
				for (Pessoa p : oe.getCandidatos()) {
					if (p.getId().equals(pessoa.getId()))
						esta=true;
				}
				listaCand.add(esta);
			}
	    	render(lista,listaCand, pessoa);
    	} catch (Exception e) {
    		e.printStackTrace();
			flash.error("<strong>Erro:</strong> " + e.getMessage());
			
			render(lista);
		}
    }
}