package controllers;

import java.util.List;

import helpers.SessionsHelper;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.ifrn.beans.EnderecoBeanRemote;
import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.OfertaEstagio;
import br.edu.ifrn.patterns.EnderecoDelegate;
import br.edu.ifrn.patterns.OfertaEstagioDelegate;
import br.edu.ifrn.patterns.ServiceLocator;

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
    	OfertaEstagioDelegate del = new OfertaEstagioDelegate();
    	List<OfertaEstagio> lista = del.getTodasOfertasEstagio();
    	
    	render(lista);
    }
}